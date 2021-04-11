package com.anant.tasker.models;

public class User {

    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }


/**
     * "id" bigint NOT NULL,
     *     "email" character varying DEFAULT ''::character varying NOT NULL,
     *     "encrypted_password" character varying DEFAULT ''::character varying NOT NULL,
     *     "reset_password_token" character varying,
     *     "reset_password_sent_at" timestamp without time zone,
     *     "remember_created_at" timestamp without time zone,
     *     "created_at" timestamp(6) without time zone NOT NULL,
     *     "updated_at" timestamp(6) without time zone NOT NULL,
     *     "provider" character varying,
     *     "uid" character varying
     */
}
