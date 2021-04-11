package com.anant.tasker.models;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DataType {
    String PROJECT = "Project";
    String GROUP = "Group";
    String TASK ="Task";
}
