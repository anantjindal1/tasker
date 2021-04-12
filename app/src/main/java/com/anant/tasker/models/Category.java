package com.anant.tasker.models;

public class Category {

    int id, category_id, task_id;
    String cat_values;
    String created_at, updated_at;

    /**
     *      "id" bigint NOT NULL,
     *     "category_id" integer NOT NULL,
     *     "task_id" integer NOT NULL,
     *     "cat_values" "json" NOT NULL,
     *     "created_at" timestamp(6) without time zone NOT NULL,
     *     "updated_at" timestamp(6) without time zone NOT NULL
     */
}
