package com.example.jiemian.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiemian.Activity_FirstFun;
import com.example.jiemian.MainActivity;
import com.example.jiemian.R;
import com.example.jiemian.RecyclerApaterDemo;

import java.util.ArrayList;
import java.util.List;

public class fragment_Recycler extends Fragment {
    View view;
    List<Integer> list;
    RecyclerView recyclerView;
    private Button first_fun;
    private Button  second_fun;
    private Button  third_fun;
    private Button  fourth_fun;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //赋值
        list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        first_fun = view.findViewById(R.id.first_fun);
        first_fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_FirstFun.class);
                System.out.println("123");
                Toast.makeText(getActivity(),"asd",Toast.LENGTH_LONG);
                startActivity(intent);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_main,container,false);
        recyclerView = view.findViewById(R.id.Recycler);
        //设置线性布局
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        //设置适配器
        RecyclerApaterDemo recyclerApaterDemo = new RecyclerApaterDemo(getActivity(), list);
        recyclerView.setAdapter(recyclerApaterDemo);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
