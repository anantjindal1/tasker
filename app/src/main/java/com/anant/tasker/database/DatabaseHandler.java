package com.anant.tasker.database;

import android.content.Context;
import android.util.Log;

import com.anant.tasker.models.Board;
import com.anant.tasker.models.DataEntity;
import com.anant.tasker.models.DataType;
import com.anant.tasker.models.Project;
import com.anant.tasker.models.Task;
import com.anant.tasker.utils.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    private  static  DatabaseHandler mHandler = null;
    enum FILTERTYPE{
    BOARD,PRIORITY,TAG,SEARCH, MOOD;
    }
    private Gson gson;
    private List<Board> boards;
    private  List<Project> projects;
    private  List<Task> tasks;
    private Context mContext;

    private DatabaseHandler(Context mContext) {
        this.mContext = mContext;
        loadDummyData();
        //loadData(Utility.readFromAssets(mContext));

    }
    public  static  DatabaseHandler getInstance(Context mContext){
        if(mHandler == null)
            mHandler = new DatabaseHandler(mContext);
        return  mHandler;
    }

    public void loadDummyData(){
        boards = new ArrayList<>();
        projects = new ArrayList<>();
        tasks = new ArrayList<>();
        for(int i=0;i<5;i++){

            Project project = new Project(i +"","project "+ i, "project des "+i);
            projects.add(project);

            Board board = new Board(i+" 1","board1 "+i,"tag tag",i+"");
            boards.add(board);
            for(int j = 0;j<5; j++)
            {
                Task task = new Task(i+" 1 "+j,"task "+j+" 1 "+i,i+"",i+" 1");
                task.priority = 1;
                task.description = "task is task "+ j+" 1 "+ i;
                task.due_date = "10/10/2021";
                tasks.add(task);
            }

             board = new Board(i+" 2","board2 "+i,"tag tag",i+"");
             boards.add(board);
            for(int j = 0;j<5; j++)
            {
                Task task = new Task(i+" 2 "+j,"task "+j+" 2 "+i,i+"",i+" 2");
                tasks.add(task);
                task.priority = 1;
                task.description = "task is task "+ j+" 2 "+ i;
                task.due_date = "10/10/2021";
            }


        }


    }
    /**
     *
     * @param task - task to be created
     * @return -1 if task is not created, 1 if task is created
     */
    public int createTask(Task task){

        if(tasks == null)return  -1;
        tasks.add(0,task);
        return 1;
    }

    public int deleteTask(Task task){

        tasks.remove(task);
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

       // List<Task> tasks = new ArrayList<>();

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

       // List<Task> tasks = new ArrayList<>();

        return  tasks;
    }

    public List<Board> getAllBoards(){

       // List<Board> boards = new ArrayList<>();
        return  boards;
    }

    public List<Board> getBoards(Project project){

       // List<Board> boards = new ArrayList<>();
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
       // List<Project> projects = new ArrayList<>();
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


    /**
     * Temporary Database loader (using json)
     */
    private void loadData(String s){
        gson = new Gson();
        //String s = readFromAssets();
        Log.d("ANSHU", s);
        Type listType = new TypeToken<ArrayList<DataEntity>>(){}.getType();
        List<DataEntity> listEntry = gson.fromJson(s,listType);

        boards = new ArrayList<>();
        projects = new ArrayList<>();
        tasks = new ArrayList<>();

        for(DataEntity de: listEntry)
        {
            Log.d("ANSHU",de.ID);
            switch (de.type)
            {
                case DataType.GROUP:
                    Board board = new Board(de.ID,de.Name,de.Tags,de.Project_id);
                    boards.add(board);

                    break;
                case DataType.PROJECT:
                    Project project = new Project(de.ID,de.Name);
                    projects.add(project);
                    break;
                case DataType.TASK:
                    Task task = new Task(de.ID,de.Name,de.Tags,de.Duedate,de.location_id,de.Category,de.Project_id,de.Group_id,de.notes);
                    tasks.add(task);
                    break;
            }
        }

    }

   }
