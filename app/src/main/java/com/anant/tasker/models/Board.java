package com.anant.tasker.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public String ID,Name,Tags,Project_id;
    List<Task> tasks;

    public Board(String ID, String name, String tags, String project_id) {
        this.ID = ID;
        Name = name;
        Tags = tags;
        Project_id = project_id;
        tasks = new ArrayList<>();
    }
}
