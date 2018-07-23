package com.epam.lab.task5.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface ColumnName {
    String columnName();
    boolean foreignKey() default false;
    String foreignColumnIdName() default "";
}