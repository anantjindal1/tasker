package com.anant.tasker.models;

public class Contact {

    int id;
    String name, email, phone, address, company, department, created_at, updated_at;
    int user_id;
    /**
     *  "id" bigint NOT NULL,
     *     "name" character varying NOT NULL,
     *     "email" character varying,
     *     "phone" character varying,
     *     "address" "text",
     *     "company" character varying,
     *     "department" character varying,
     *     "created_at" timestamp(6) without time zone NOT NULL,
     *     "updated_at" timestamp(6) without time zone NOT NULL,
     *     "user_id" integer
     * );
     */
}
