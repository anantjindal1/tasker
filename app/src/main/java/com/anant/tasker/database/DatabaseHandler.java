package com.anant.tasker.database;

import com.anant.tasker.models.Board;
import com.anant.tasker.models.Project;
import com.anant.tasker.models.Task;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    enum FILTERTYPE{
    BOARD,PRIORITY,TAG,SEARCH, MOOD;
    }

    /**
     *
     * @param task - task to be created
     * @return -1 if task is not created, 1 if task is created
     */
    public int createTask(Task task){

        return -1;
    }

    public int deleteTask(Task task){
       return  -1;
    }
    public int updateTask(Task task){
        return  -1;
    }
    /**
     * list of all tasks sorted by priority
     * @return
     */
    public List<Task> getAllTasks()
    {

        List<Task> tasks = new ArrayList<>();

        return  tasks;
    }

    /**
     *
     * @param type - select tasks based on
     * @param key - value to be selected, null for priority
     * @return
     */
    public List<Task> getTasks(FILTERTYPE type,String key)
    {

        List<Task> tasks = new ArrayList<>();

        return  tasks;
    }

    public List<Board> getAllBoards(){

        List<Board> boards = new ArrayList<>();
        return  boards;
    }

    public List<Board> getBoards(Project project){

        List<Board> boards = new ArrayList<>();
        return boards;
    }

    public int createBoard(Board board){

        return  -1;
    }

    public int deleteBoard (Board board){
        return  -1;
    }
    public int updateBoard(Board board){
        return  -1;
    }


    public List<Project> getAllProjects(){
        List<Project> projects = new ArrayList<>();
        return projects;
    }
    public int deleteProject(Project project){
        return  -1;
    }
    public int createProject(Project project){
        return  -1;

    }
    public  int updateProject(Project project){
        return  -1;
    }

}
