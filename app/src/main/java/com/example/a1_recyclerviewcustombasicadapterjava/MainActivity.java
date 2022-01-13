package com.example.a1_recyclerviewcustombasicadapterjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> studentArrayList;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        studentArrayList = new ArrayList();
        recyclerView = findViewById(R.id.recycler_view);
        customAdapter = new CustomAdapter(MainActivity.this, studentArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        addItemsToTheStudentArrayList();
    }

    private void addItemsToTheStudentArrayList() {
        for (int i = 0; i < 20; i++) {

            if (i % 4 == 0) {
                studentArrayList.add(new Student("Bozorboyeva Muyassar Davron qizi", 19, false));
            } else if (i % 3 == 1) {
                studentArrayList.add(new Student("Sobirov James Sadulla o'g'li", 20, true));
            } else if (i % 3 == 2) {
                studentArrayList.add(new Student("Sobirov Otabek Sadulla o'g'li", 23, true));
            } else {
                studentArrayList.add(new Student("Matchanova Dinora Sadulla qizi", 19, true));

            }
        }
    }
}