package com.example.myproject;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class LoanCalculateActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox mPrincipal;
    private CheckBox mPrincipalInterest;
    private CheckBox mGetJob;
    private CheckBox mNormal;
    private CheckBox mCountry;
    private TextView mDatePick;
    private EditText mAmount;

    private String mInformation;
    private Button mAddition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculate);

        mPrincipal = (CheckBox)findViewById(R.id.cb_principal);
        mPrincipalInterest = (CheckBox)findViewById(R.id.cb_principal_interest);

        mGetJob = (CheckBox)findViewById(R.id.cb_get_job);
        mNormal = (CheckBox)findViewById(R.id.cb_normal);
        mCountry = (CheckBox)findViewById(R.id.cb_country);

        mDatePick = (TextView)findViewById(R.id.tv_year_pick);
        mAmount = (EditText)findViewById(R.id.et_amount);



        mAddition = (Button)findViewById(R.id.btn_addition);

        mDatePick.setOnClickListener(this);
        mAddition.setOnClickListener(this);

    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mInformation = year + "년" + (monthOfYear + 1) + "월" + dayOfMonth + "일";
            mDatePick.setText(mInformation);
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_year_pick:
                DatePickerDialog datePickerDialog = new DatePickerDialog(LoanCalculateActivity.this, listener, 2010, 1, 1);
                datePickerDialog.show();

                break;
            case R.id.btn_addition:
                calculate();

                break;

        }
    }

    public int calculate() {
        int result = 0;





        return result;
    }
}
