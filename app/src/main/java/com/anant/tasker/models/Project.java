package com.anant.tasker.models;

import java.util.ArrayList;
import java.util.List;

public class Project {
    public String ID,Name;
    List<Board> boards;

    public Project(String ID, String name) {
        this.ID = ID;
        Name = name;
        boards = new ArrayList<>();
    }
}
