package com.epam.lab.task5.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JunctionTable {
    String tableName();
    Class<?> foreignObjectsType();
    String currentColumnIdName();
    String junctionTableConditionColumnName();
    String junctionTableForeignColumnIdName();
    String foreignColumnIdName();
}
