package com.anant.tasker.models;

public class SubTask {
    /**
     *     "id" bigint NOT NULL,
     *     "name" character varying NOT NULL,
     *     "desc" "text",
     *     "task_id" integer NOT NULL,
     *     "loc_lat" double precision,
     *     "loc_long" double precision,
     *     "internal_pre_requisites" integer[] DEFAULT '{}'::integer[],
     *     "pre_requisites" integer[] DEFAULT '{}'::integer[],
     *     "created_at" timestamp(6) without time zone NOT NULL,
     *     "updated_at" timestamp(6) without time zone NOT NULL,
     *     "user_id" integer
     */
}
