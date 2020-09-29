package com.example.jiemian;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiemian.Fragment.fragment_Message;
import com.example.jiemian.Fragment.fragment_Recycler;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context;
    private List<Integer> list;
    private RadioGroup radioGroup;


    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    View message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_radiobutton);
        fragmentManager = getSupportFragmentManager();
        context = this;
        radioGroup = findViewById(R.id.fra_RadioGroup);
        init_first_fragment();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    /*FragmentManager要管理fragment（添加，替换以及其他的执行动作）
                     *的一系列的事务变化，需要通过fragmentTransaction来操作执行
                     */
                    case R.id.home_message:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragment_Message fragment_message = new fragment_Message();
                        fragmentTransaction.replace(R.id.fragment_Recycler, fragment_message);
                        fragmentTransaction.commit();
                        break;
                    case R.id.home_page:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragment_Recycler fragment_recycler = new fragment_Recycler();
                        fragmentTransaction.replace(R.id.fragment_Recycler, fragment_recycler);
                        fragmentTransaction.commit();
                        break;


                }
            }
        });

    }

    void init_first_fragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment_Recycler fragment_recycler = new fragment_Recycler();
        fragmentTransaction.add(R.id.fragment_Recycler, fragment_recycler);
        fragmentTransaction.commit();
    }
}
