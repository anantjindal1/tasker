package com.anant.tasker.models;

public class Task {
    public String ID,Name,Tags,Duedate,location_id,Category,Project_id,Group_id,notes;

    public Task(String ID, String name, String tags, String duedate, String location_id, String category, String project_id, String group_id, String notes) {
        this.ID = ID;
        Name = name;
        Tags = tags;
        Duedate = duedate;
        this.location_id = location_id;
        Category = category;
        Project_id = project_id;
        Group_id = group_id;
        this.notes = notes;

    }

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
