package com.example.jiemian;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiemian.Fragment.fragment_RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context;
    private List<Integer> list;

    private RadioGroup radioGroup;
    /*FragmentManager要管理fragment（添加，替换以及其他的执行动作）
     *的一系列的事务变化，需要通过fragmentTransaction来操作执行
     */
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    View message;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        //用LayoutInflater加载布局
        LayoutInflater fragment_message = LayoutInflater.from(context);
        //获取message所在的View
        message = fragment_message.inflate(R.layout.fragment_radiobutton, null);
        //找到radioGroup
        radioGroup = message.findViewById(R.id.fra_RadioGroup);
        //初始化fragmentManager
        fragmentManager = getSupportFragmentManager();
        //初始化Recycler
        init_Recycler();
        init_first_fragment();
        //初始化RadioGroup 实现切换Fragment
//        init_RadioGroup();
    }

    void init_Recycler() {
        //赋值
        list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
        recyclerView = findViewById(R.id.Recycler);
        //设置线性布局
        LinearLayoutManager linearLayout = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayout);
        //设置适配器
        RecyclerApaterDemo recyclerApaterDemo = new RecyclerApaterDemo(context, list);
        recyclerView.setAdapter(recyclerApaterDemo);
    }

    void init_first_fragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment_RadioGroup fragmentRadioGroup = new fragment_RadioGroup();
        fragmentTransaction.add(R.id.fragment_radiogroup, fragmentRadioGroup);
        fragmentTransaction.commit();
    }
}
