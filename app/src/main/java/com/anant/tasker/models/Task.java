package com.anant.tasker.models;

import java.util.List;

public class Task {
    public String ID,Name,Tags,Duedate,location_id,Category,Project_id, board_id,notes;

    public Task(String ID, String name, String tags, String duedate, String location_id, String category, String project_id, String board_id, String notes) {
        this.ID = ID;
        Name = name;
        Tags = tags;
        Duedate = duedate;
        this.location_id = location_id;
        Category = category;
        Project_id = project_id;
        this.board_id = board_id;
        this.notes = notes;

    }

    public Task(String ID, String name, String project_id, String board_id) {
        this.ID = ID;
        Name = name;
        title = name;
        Project_id = project_id;
        this.board_id = board_id;
    }

    public int age, priority;
    public String title, description, task_status, due_date, loc_lat, loc_long, created_at,updated_at,used_id,completed_at, tag;
    List<Task> pre_requisites;
    Board board;
    /**
     *   "id" bigint NOT NULL,
     *     "title" character varying NOT NULL,
     *     "desc" "text",
     *     "age" integer DEFAULT 0,
     *     "task_status" character varying,
     *     "due_date" timestamp without time zone,
     *     "priority" integer DEFAULT 100 NOT NULL,
     *     "pre_requisites" integer[] DEFAULT '{}'::integer[],
     *     "loc_lat" double precision,
     *     "loc_long" double precision,
     *     "board_id" integer,
     *     "created_at" timestamp(6) without time zone NOT NULL,
     *     "updated_at" timestamp(6) without time zone NOT NULL,
     *     "user_id" integer,
     *     "completed_at" timestamp without time zone
     */
}
