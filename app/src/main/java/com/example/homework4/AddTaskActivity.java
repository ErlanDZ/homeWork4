package com.example.homework4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity {

    private EditText etTitle, etDescription;
    private Button btnAddTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        btnAddTask = findViewById(R.id.btn_add_task);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String description  = etDescription.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
                String date = sdf.format(new Date());
                if (!title.isEmpty() && ! description.isEmpty()){
                    Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
                    intent.putExtra("title",title);
                    intent.putExtra("description", description);
                    intent.putExtra("date", date);
                    setResult(RESULT_OK, intent);
                    finish();

                }

            }
        });
    }
}