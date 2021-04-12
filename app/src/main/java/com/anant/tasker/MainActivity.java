package com.anant.tasker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.anant.tasker.database.DatabaseHandler;
import com.anant.tasker.models.DataEntity;
import com.anant.tasker.models.DataType;
import com.anant.tasker.models.Board;
import com.anant.tasker.models.Project;
import com.anant.tasker.models.Task;
import com.anant.tasker.project.ProjectListActivity;
import com.anant.tasker.utils.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Gson gson;
    private List<Board> boards;
    private  List<Project> projects;
    private  List<Task> tasks;

    RecyclerView rvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // loadData();

        DatabaseHandler dbHandler =  DatabaseHandler.getInstance(getApplicationContext());
        tasks = dbHandler.getAllTasks();

        // Lookup the recyclerview in activity layout
         rvContacts = (RecyclerView) findViewById(R.id.rvTasks);

        // Initialize contacts

        // Create adapter passing in the sample user data
        MainRVAdapter adapter = new MainRVAdapter(tasks);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));


        // That's all!

    }

    public void startProject(View view) {
        Intent intent = new Intent(getApplicationContext(), ProjectListActivity.class);
        startActivity(intent);
    }
    public void startCreateTask(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateTaskActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = "";
        if(data.hasExtra("task"))
             result = data.getStringExtra("task");
        rvContacts.getAdapter().notifyDataSetChanged();
        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
    }

}
