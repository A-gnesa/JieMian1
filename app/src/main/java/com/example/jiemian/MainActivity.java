package com.example.jiemian;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.jiemian.Fragment.fragment_Message;
import com.example.jiemian.Fragment.fragment_Mine;
import com.example.jiemian.Fragment.fragment_Recycler;

public class MainActivity extends AppCompatActivity {
    //  控件
    private RadioGroup radioGroup;
    private Toolbar toolbar;
    private TextView Toolbar_title;
    //声明 Fragment
    private Fragment fragment_Message;
    private Fragment fragment_Recycler;
    private Fragment fragment_Mine;
    private Fragment now_fragment;          //现在使用的fragment


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_radiobutton);
        radioGroup = findViewById(R.id.fra_RadioGroup);
        toolbar = findViewById(R.id.Toolbar_top);
//        //加载toolbar布局文件
//        LayoutInflater layoutInflater = LayoutInflater.from(this);
//        View view = layoutInflater.inflate(R.layout.fragment_radiobutton,null);

        Toolbar_title = findViewById(R.id.Toolbar_title);
        fragment_Message = new fragment_Message();
        fragment_Mine = new fragment_Mine();
        init_first_fragment();
        setSupportActionBar(toolbar);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    /*FragmentManager要管理fragment（添加，替换以及其他的执行动作）
                     *的一系列的事务变化，需要通过fragmentTransaction来操作执行
                     */
                    case R.id.home_page:
                        Toolbar_title.setText("首页");
                        switchContent(now_fragment,fragment_Recycler);
                        break;
                    case R.id.home_message:
                        Toolbar_title.setText("信息");
                        switchContent(now_fragment,fragment_Message);
                        break;
                    case R.id.home_Mine:
                        Toolbar_title.setText("我的");
                        switchContent(now_fragment,fragment_Mine);
                        break;
                }
            }
        });
    }

    void init_first_fragment() {
        Toolbar_title.setText("首页");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment_Recycler = new fragment_Recycler();
        if (now_fragment==null){
            now_fragment = fragment_Recycler;
        }
        fragmentTransaction.add(R.id.switch_fragment, fragment_Recycler);
        fragmentTransaction.commit();
    }
//    切换fragment
    void switchContent(Fragment from, Fragment to){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(now_fragment!=to){
            now_fragment = to;
            if(!to.isAdded()){
                fragmentTransaction.hide(from).add(R.id.switch_fragment,to).commit();
            }else {
                fragmentTransaction.hide(from).show(to).commit();
            }
        }
    }
}
