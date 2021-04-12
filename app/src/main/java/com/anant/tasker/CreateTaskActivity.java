package com.anant.tasker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.anant.tasker.database.DatabaseHandler;
import com.anant.tasker.models.Board;
import com.anant.tasker.models.Task;

import java.util.List;

public class CreateTaskActivity extends AppCompatActivity {
    EditText etTitle, etDescription, etDuedate,etPriority,etTag;
    Spinner sBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        etTitle = findViewById(R.id.taskName);
        etDescription = findViewById(R.id.taskDescription);
        etDuedate = findViewById(R.id.dueDate);
        etPriority = findViewById(R.id.priority);
        sBoard = findViewById(R.id.board);
        etTag = findViewById(R.id.tags);


        //set board spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        List<Board> itemNames = DatabaseHandler.getInstance(getApplicationContext()).getAllBoards();

        for (int i = 0; i < itemNames.size(); i++) // Maximum size of i upto --> Your Array Size
        {
            dataAdapter.add(itemNames.get(i).Name);
        }

        sBoard.setAdapter(dataAdapter);
    }

    public void createTask(View view) {
        String title,desc,duedate,priority,board,tag;
        title = etTitle.getText().toString();
        desc = etDescription.getText().toString();
        duedate = etDuedate.getText().toString();
        priority = etPriority.getText().toString();
        board = sBoard.getSelectedItem().toString();
        tag = etTag.getText().toString();

        Task task = new Task("task ",title, "proj1","grp1");
        task.description = desc;
        task.due_date = duedate;
        task.priority = Integer.parseInt(priority);
        task.board_id = board;
        task.tag  = tag;

        DatabaseHandler dbHandler =  DatabaseHandler.getInstance(getApplicationContext());
        dbHandler.createTask(task);

        Intent output = new Intent();
        output.putExtra("task", ""+title);

        setResult(RESULT_OK, output);
        finish();

        //get all values, create a task object, insert in database
    }
}
