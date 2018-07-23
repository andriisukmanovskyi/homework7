package com.epam.lab.task5.universal.transformer;


import com.epam.lab.task5.annotations.ColumnName;
import com.epam.lab.task5.annotations.JunctionTable;
import com.epam.lab.task5.annotations.TableName;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

public class Transformer<T> {

    private T object;

    public Transformer(T object) {
        this.object = object;
    }

    public T getObject(Connection connection, ResultSet resultSet) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            JunctionTable annotation = field.getAnnotation(JunctionTable.class);
            if (Objects.nonNull(annotation)) {
                setJunctionValue(connection, fields, field, annotation);
            } else
                setObjectValue(connection, resultSet, field);
        }
        return object;
    }

    private void setJunctionValue(Connection connection, Field[] fields, Field field, JunctionTable annotation) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        List idList = new ArrayList();
        List innerObjects = new ArrayList();
        String junctionTableName = annotation.tableName();
        Class<?> foreignClass = annotation.foreignObjectsType();
        String foreignTableName = foreignClass.getAnnotation(TableName.class).tableName();
        ResultSet junctionTableResultSet = getJunctionTableResultSet(connection, fields, annotation, junctionTableName);
        getForeignTableIdList(annotation, idList, junctionTableResultSet);
        junctionTableResultSet = getJunctionTableForeignResultSet(connection,
                foreignTableName, annotation.foreignColumnIdName(), idList);
        while (junctionTableResultSet.next()) {
            Transformer transformer = new Transformer(foreignClass.getConstructor().newInstance());
            innerObjects.add(transformer.getObject(connection, junctionTableResultSet));
        }
        setJunctionTableValue(field, innerObjects);
    }

    private void getForeignTableIdList(JunctionTable annotation, List list, ResultSet junctionTableResultSet) throws SQLException {
        while (junctionTableResultSet.next()) {
            list.add(junctionTableResultSet.getObject(annotation.junctionTableForeignColumnIdName()));
        }
    }

    private ResultSet getJunctionTableResultSet(Connection connection, Field[] fields, JunctionTable annotation, String junctionTableName) throws SQLException, IllegalAccessException {
        return connection.createStatement().
                executeQuery("SELECT * FROM " + junctionTableName + " WHERE " +
                        annotation.junctionTableConditionColumnName() + "=" +
                        getConditionId(fields, annotation.currentColumnIdName()));
    }

    private ResultSet getJunctionTableForeignResultSet(Connection connection, String tableName,
                                                       String foreignColumnIdName, List idList) throws SQLException {
        String sqlInId = "";
        for (Object id : idList) {
            sqlInId += String.valueOf(id + ",");
        }
        sqlInId = sqlInId.substring(0, sqlInId.length() - 1);
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM " +
                tableName + " WHERE " + foreignColumnIdName + " IN(" + sqlInId + ");");
        return resultSet;
    }

    private int getConditionId(Field[] fields, String currentColumnIdName) throws IllegalAccessException {
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(ColumnName.class);
            if (Objects.nonNull(annotation) && ((ColumnName) annotation).columnName().equalsIgnoreCase(currentColumnIdName)) {
                return (int) field.get(object);
            }
        }
        return 0;
    }

    private void setJunctionTableValue(Field field, Object o) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(object, o);
    }

    private void setObjectValue(Connection connection, ResultSet resultSet, Field field) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ColumnName annotation;
        Object o;
        field.setAccessible(true);
        annotation = field.getAnnotation(ColumnName.class);
        String columnName = annotation.columnName();
        o = resultSet.getObject(columnName);
        o = annotation.foreignKey() ? getForeignKeyValue(connection, annotation, o, field) : o;
        field.set(object, o);
    }

    private Object getForeignKeyValue(Connection connection, ColumnName annotation, Object o, Field field) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SQLException {
        String foreignTableName = field.getType().getAnnotation(TableName.class).tableName();
        String foreignColumnIdName = annotation.foreignColumnIdName();
        Transformer transformer = new Transformer(field.getType().getConstructor().newInstance());
        o = transformer.getObject(connection, getForeignResultSet(connection,
                foreignTableName, foreignColumnIdName, Integer.parseInt(String.valueOf(o))));
        return o;
    }

    private ResultSet getForeignResultSet(Connection connection, String tableName, String foreignColumnIdName, int id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM " +
                tableName + " WHERE " + foreignColumnIdName + "=" + id);
        resultSet.next();
        return resultSet;
    }

    public PreparedStatement getStatement(Connection connection) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = object.getClass();
        String tableName = c.getAnnotation(TableName.class).tableName();
        String sql = "INSERT INTO " + tableName + "(";
        String values = "VALUES(";
        Field[] fields = c.getDeclaredFields();
        sql = getSqlQuery(sql, values, fields);
        return connection.prepareStatement(sql);
    }

    private String getSqlQuery(String sql, String values, Field[] fields) throws IllegalAccessException {
        ColumnName annotation;
        for (Field field : fields) {
            field.setAccessible(true);
            annotation = field.getAnnotation(ColumnName.class);
            if (!Objects.nonNull(annotation))
                continue;
            Object value = annotation.foreignKey() ? getForeignId(field) : field.get(object);
            values += String.valueOf("\'" + value + "\',");
            sql += annotation.columnName() + ",";
        }
        sql = sql.substring(0, sql.length() - 1);
        values = values.substring(0, values.length() - 1);
        sql = sql + ") " + values + ");";
        return sql;
    }

    private int getForeignId(Field field) throws IllegalAccessException {
        int foreignId = 0;
        Annotation annotation;
        for (Field f : field.get(object).getClass().getDeclaredFields()) {
            annotation = f.getAnnotation(ColumnName.class);
            f.setAccessible(true);
            if (Objects.nonNull(annotation) && ((ColumnName) annotation).columnName().
                    equalsIgnoreCase(field.getAnnotation(ColumnName.class).foreignColumnIdName())) {
                foreignId = (int) f.get(field.get(object));
            }
        }
        return foreignId;
    }

    public PreparedStatement getJunctionTableStatement(Connection connection, Object o) throws IllegalAccessException, SQLException {
        Class<?> c = object.getClass();
        String sql = "";
        String values = "VALUES(";
        JunctionTable annotation;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            annotation = field.getAnnotation(JunctionTable.class);
            if (!Objects.nonNull(annotation))
                continue;
            sql = "INSERT INTO " + annotation.tableName() + " (" + annotation.junctionTableConditionColumnName() + "," +
                    annotation.junctionTableForeignColumnIdName() + ") ";
            values += String.valueOf("\'" + getCurrentObjectId(fields, annotation.currentColumnIdName()) + "\'," +
                    "\'" + o + "\'");
            sql += " " + values + ");";
        }
        System.out.println(sql);
        return connection.prepareStatement(sql);
    }

    private Object getCurrentObjectId(Field[] fields, String currentColumnIdName) throws IllegalAccessException {
        for (Field field : fields) {
            field.setAccessible(true);
            ColumnName annotation = field.getAnnotation(ColumnName.class);
            if (Objects.nonNull(annotation) && annotation.columnName().equalsIgnoreCase(currentColumnIdName)) {
                return field.get(object);
            }
        }
        return new Object();
    }
}