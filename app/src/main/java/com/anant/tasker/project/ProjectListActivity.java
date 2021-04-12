package com.anant.tasker.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.anant.tasker.MainRVAdapter;
import com.anant.tasker.R;
import com.anant.tasker.database.DatabaseHandler;

public class ProjectListActivity extends AppCompatActivity {
    RecyclerView rvProjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        // Lookup the recyclerview in activity layout
        rvProjects = (RecyclerView) findViewById(R.id.rvTasks);

        // Initialize contacts

        // Create adapter passing in the sample user data
        ProjectRVAdapter adapter = new ProjectRVAdapter(DatabaseHandler.getInstance(this).getAllProjects());
        // Attach the adapter to the recyclerview to populate items
        rvProjects.setAdapter(adapter);
        // Set layout manager to position the items
        rvProjects.setLayoutManager(new LinearLayoutManager(this));

    }

    public void startNewProject(View view) {

    }
}
