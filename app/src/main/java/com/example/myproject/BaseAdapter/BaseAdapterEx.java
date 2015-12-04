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

    class ViewHolder{
        TextView mNameTextView;
        TextView mNumberTextView;
        TextView departmentTextView;

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


        //1. 어댑터뷰가 재사용할 뷰를 넘겨주지 않은 경우에만 새로운 뷰를 생성한다.
        View itemLayout = convertView;
        ViewHolder viewHolder = null;

        if (itemLayout == null) {
            itemLayout = mLayoutInflater.inflate(R.layout.list_view_item_layout, null);

            viewHolder = new ViewHolder();
            viewHolder.mNameTextView = (TextView)itemLayout.findViewById(R.id.tv_name);
            viewHolder.mNumberTextView = (TextView)itemLayout.findViewById(R.id.tv_number);
            viewHolder.departmentTextView = (TextView)itemLayout.findViewById(R.id.tv_department);

            itemLayout.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)itemLayout.getTag();
        }


        // 2. 이름, 학과, 번호 데이터를 참조하여 레이아웃을 갱신한다.
        viewHolder.mNameTextView.setText(mData.get(position).mName);
        viewHolder.mNumberTextView.setText(mData.get(position).mNumber);
        viewHolder.departmentTextView.setText(mData.get(position).mDepartment);


        return itemLayout;
    }
}
