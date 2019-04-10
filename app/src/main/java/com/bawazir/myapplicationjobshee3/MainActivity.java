package com.bawazir.myapplicationjobshee3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.OnAdapterClickListener {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_students);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Bawazir", "123"));
        students.add(new Student("Bagas", "3456"));
        students.add(new Student("Lukman", "789"));
        students.add(new Student("Dini", "1011"));
        students.add(new Student("Choirul", "1213"));
        students.add(new Student("Fuzia", "1415"));
        students.add(new Student("Bayu", "1617"));
        students.add(new Student("Zulfikar", "11819"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        StudentAdapter studentAdapter = new StudentAdapter(students, this, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    @Override
    public void onClick(Student student) {

    }
}
