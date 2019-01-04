package com.example.linyanheng.mynotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivit extends AppCompatActivity {
    TextView tvTitle,tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvContent = (TextView) findViewById(R.id.tv_content);
        Bundle bundle = getIntent().getExtras();
        Email email = (Email)bundle.getSerializable("email");
        tvTitle.setText(email.getTitle());
        tvContent.setText(email.getContent());
    }
}
