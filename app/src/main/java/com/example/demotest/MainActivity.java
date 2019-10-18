package com.example.demotest;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.demotest.Entity.GroupEntity;
import com.example.demotest.dao.GroupDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button createGoalBtn;
    private GroupDao groupDao;
    private ListView groupListView;
    List<GroupEntity> groupList = new ArrayList<GroupEntity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groupDao = new GroupDao(this);
        groupList = groupDao.listGroup();
        //获取ListView,并通过Adapter把grouplist的信息显示到ListView
        //为ListView设置一个适配器,getCount()返回数据个数;getView()为每一行设置一个条目
        groupListView = findViewById(R.id.activity_group_listView);
        groupListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return groupList.size();
            }
            @Override
            public Object getItem(int position) {
                // TODO Auto-generated method stub
                return null;
            }
            @Override
            public long getItemId(int position) {
                // TODO Auto-generated method stub
                return 0;
            }
            //ListView的每一个条目都是一个view对象
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(18);
                //获取集合中的元素
                GroupEntity group = groupList.get(position);
                tv.setText(group.toString());

                return tv;
            }
        });

        createGoalBtn = (Button) findViewById(R.id.activity_new_goal_btn);
        createGoalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示方式声明Intent，直接启动SecondActivity
                Intent intent = new Intent(MainActivity.this, CreateGoalActivity.class);
                startActivity(intent);
            }
        });
    }
}
