package com.example.jiemian;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiemian.Fragment.fragment_Message;
import com.example.jiemian.Fragment.fragment_RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;
    private List<Integer> list;
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        //初始化fragmentManager
        fragmentManager = getSupportFragmentManager();
        //初始化Recycler
        init_Recycler();

    }
    void init_Recycler(){
        //赋值
        list = new ArrayList<>();
        for (int i = 1; i<=20 ; i++){
            list.add(i);
        }
        recyclerView = findViewById(R.id.Recycler);
        //设置线性布局
        LinearLayoutManager linearLayout = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayout);
        //设置适配器
        RecyclerApaterDemo recyclerApaterDemo = new RecyclerApaterDemo(context,list);
        recyclerView.setAdapter(recyclerApaterDemo);
    }
    void init_first_fragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment_RadioGroup fragmentRadioGroup = new fragment_RadioGroup();
        fragmentTransaction.add(R.id.fragment_radiogroup,fragmentRadioGroup);
        fragmentTransaction.commit();


    }
    void init_RadioGroup(){
        //初始化RadioGroup 实现切换Fragment
        radioGroup = findViewById(R.id.RadioGroup);
        //定义点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.message :
                        /*FragmentManager要管理fragment（添加，替换以及其他的执行动作）
                         *的一系列的事务变化，需要通过fragmentTransaction来操作执行
                         */
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragment_Message message_fragment = new fragment_Message();

                        break;
                    case R.id.Mine:
                        break;
                }
            }
        });
    }
}
