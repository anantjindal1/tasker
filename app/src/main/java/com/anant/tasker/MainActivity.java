package com.anant.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.anant.tasker.models.DataEntity;
import com.anant.tasker.models.DataType;
import com.anant.tasker.models.Board;
import com.anant.tasker.models.Project;
import com.anant.tasker.models.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Gson gson;
    private List<Board> boards;
    private  List<Project> projects;
    private  List<Task> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvTasks);

        // Initialize contacts

        // Create adapter passing in the sample user data
        CustomAdapter adapter = new CustomAdapter(tasks);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        Button btn = findViewById(R.id.buttonCreateTask);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateTaskActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        // That's all!

    }

    private void loadData(){
        gson = new Gson();
        String s = readFromAssets();
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

    private String readFromAssets() {
        StringBuilder sb = new StringBuilder();
        //reading from assets
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("sample.json")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                sb.append(mLine);
                ///...
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return sb.toString();
    }
}
