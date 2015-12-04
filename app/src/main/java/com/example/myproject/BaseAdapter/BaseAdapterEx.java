package com.example.myproject.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myproject.R;

import java.util.ArrayList;

/**
 * Created by student on 2015-12-03.
 */
public class BaseAdapterEx extends BaseAdapter {

    Context mContext;
    ArrayList<Student> mData;
    LayoutInflater mLayoutInflater;

    public BaseAdapterEx(Context context, ArrayList<Student> data) {

        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Student getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1. 리스트의 한 항목에 해당하는 레이아웃을 생성한다.

        View itemLayout = mLayoutInflater.inflate(R.layout.list_view_item_layout, null);
        TextView nameTextView = (TextView)itemLayout.findViewById(R.id.tv_name);
        TextView numberTextView = (TextView)itemLayout.findViewById(R.id.tv_number);
        TextView departmentTextView = (TextView)itemLayout.findViewById(R.id.tv_department);

        // 2. 이름, 학과, 번호 데이터를 참조하여 레이아웃을 갱신한다.

        nameTextView.setText(mData.get(position).mName);
        numberTextView.setText(mData.get(position).mNumber);
        departmentTextView.setText(mData.get(position).mDepartment);


        return itemLayout;
    }
}
