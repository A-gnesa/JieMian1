package com.example.jiemian;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;
    private List<Integer> list;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        list = new ArrayList<>();
        for (int i = 1; i<=20 ; i++){
            list.add(i);
        }
        recyclerView = findViewById(R.id.Recycler);
        LinearLayoutManager linearLayout = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayout);
        RecyclerApaterDemo recyclerApaterDemo = new RecyclerApaterDemo(context,list);
        recyclerView.setAdapter(recyclerApaterDemo);
    }
}
