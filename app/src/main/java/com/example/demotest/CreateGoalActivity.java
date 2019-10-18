package com.example.demotest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.demotest.Entity.GroupEntity;
import com.example.demotest.dao.GroupDao;

import java.util.ArrayList;
import java.util.List;

public class CreateGoalActivity extends AppCompatActivity {

    private EditText groupName, groupTarget;
    private Button addGroupBtn;
    private GroupDao groupDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_goal);
        groupDao = new GroupDao(this);

        groupName = (EditText) findViewById(R.id.activity_create_goal_goalName);
        groupTarget = (EditText) findViewById(R.id.activity_create_goal_targetAmount);
        addGroupBtn = (Button) findViewById(R.id.activity_create_goal_btn);

        addGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (groupDao.addGroup(groupName.getText().toString(), Integer.parseInt(groupTarget.getText().toString()))) {
                    // add group success, page jump
                    Intent intent = new Intent(CreateGoalActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // fail to add group, show prompt
                    Toast.makeText(CreateGoalActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
