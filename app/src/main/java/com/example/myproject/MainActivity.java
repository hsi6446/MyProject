package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myproject.BaseAdapter.ExerciseActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton01;
    private Button mBaseAdapterExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton01 = (Button)findViewById(R.id.btn_01);
        mBaseAdapterExercise = (Button)findViewById(R.id.btn_02);

        mButton01.setOnClickListener(this);
        mBaseAdapterExercise.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                Intent intent = new Intent(this, LoanCalculateActivity.class);

                startActivity(intent);

                break;
            case R.id.btn_02:
                Intent intent2 = new Intent(this, ExerciseActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
