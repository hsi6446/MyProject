package com.example.myproject.BaseAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myproject.R;

import java.util.ArrayList;

/**
 * Created by student on 2015-12-03.
 */
public class ExerciseActivity extends AppCompatActivity {

    ArrayList<Student> mData = null;
    private BaseAdapterEx mAdapter = null;
    private ListView mListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_activity);

        mData = new ArrayList<Student>();

        for (int i = 0; i < 100; i++){
            Student student = new Student();
            student.mName = "슈퍼혜람쥐" +i;
            student.mNumber = "1004" +i;
            student.mDepartment = "학자금대출은 혜람쥐론으로" +i;

            mData.add(student);

        }

        // 2. 어뎁터를 생성하고 데이터 설정
        mAdapter = new BaseAdapterEx(this, mData);

        // 3. 리스트뷰에 어뎁터 설정
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);

    }
}
