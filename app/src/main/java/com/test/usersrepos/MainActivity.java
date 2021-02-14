package com.test.usersrepos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public EditText txtUsersName;

    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsersName=findViewById(R.id.txtUsersName);

        btnStart=findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> {
            action();
        });
    }

    public void action(){
        Intent intent= new Intent(this,ReposList.class);
        startActivity(intent);
    }

}