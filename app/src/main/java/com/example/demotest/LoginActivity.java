package com.example.demotest;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.demotest.MainActivity;
import com.example.demotest.R;
import com.example.demotest.dao.LoginDao;

public class LoginActivity extends AppCompatActivity {

    //定义控件
    private EditText username , pwd ;
    private Button loginbtn;
    private LoginDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dao = new LoginDao(this);

        // Get control
        username = (EditText) findViewById(R.id.activity_login_et_username);
        pwd = (EditText) findViewById(R.id.activity_login_et_pwd);
        loginbtn = (Button) findViewById(R.id.activity_login_btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //判断登陆成功与否
                if(dao.login(username.getText().toString(),pwd.getText().toString())){
                    // login success, page jump
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    // login fail, show prompt
                    Toast.makeText(LoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
