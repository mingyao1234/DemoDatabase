package com.myapplicationdev.android.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert;
    Button btnGetTasks;
    ListView lv;
    EditText etTask;
    EditText etDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        lv = (ListView) findViewById(R.id.lv);
        etTask = findViewById(R.id.etTask);
        etDate = findViewById(R.id.etDate);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertTask(etTask.getText().toString(), etDate.getText().toString());
            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<Task> al = db.getTasks();
                db.close();

                ArrayAdapter aa = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1, al);
                lv.setAdapter(aa);
            }
        });
    }
}