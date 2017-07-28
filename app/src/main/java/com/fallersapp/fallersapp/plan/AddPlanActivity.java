package com.fallersapp.fallersapp.plan;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.fallersapp.fallersapp.home.MainActivity;
import com.fallersapp.fallersapp.plan.PickLocation;
import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sleepbot.datetimepicker.time.RadialPickerLayout;
import com.sleepbot.datetimepicker.time.TimePickerDialog;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hamda on 13/07/2017.
 */

public class AddPlanActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";

    @BindView(R.id.btn_add)
    Button buttonAdd;

    @BindView(R.id.et_location)
    EditText textLocation;

    @BindView(R.id.rv_list_plan)
    RecyclerView recyclerViewPlan;

    @BindView(R.id.et_dep_time)
    EditText editTextDepTime;

    @BindView(R.id.et_arr_time)
    EditText editTextArrTime;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    int yearDept, yearArr, mYear = 1985;
    int monthDept, monthArr;
    int dayDept, dayArr;
    boolean dateDeptOn = false;
    boolean dateArrOn = false;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_add_plan);
        ButterKnife.bind(this);
        setToolbar(true);

        //date picker
        final Calendar calendar = Calendar.getInstance();

        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), isVibrate());
        final TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(this, calendar.get(Calendar.HOUR_OF_DAY) ,calendar.get(Calendar.MINUTE), false, false);

        editTextDepTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dateDeptOn = true;
                datePickerDialog.setVibrate(isVibrate());
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.setCloseOnSingleTapDay(isCloseOnSingleTapDay());
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
            }
        });

        editTextArrTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dateArrOn = true;
                datePickerDialog.setVibrate(isVibrate());
                datePickerDialog.setYearRange(mYear, 2028);
                datePickerDialog.setCloseOnSingleTapDay(isCloseOnSingleTapDay());
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
                datePickerDialog.onYearSelected(mYear);
            }
        });

//        findViewById(R.id.timeButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timePickerDialog.setVibrate(isVibrate());
//                timePickerDialog.setCloseOnSingleTapMinute(isCloseOnSingleTapMinute());
//                timePickerDialog.show(getSupportFragmentManager(), TIMEPICKER_TAG);
//            }
//        });

        if (saveInstanceState != null) {
            DatePickerDialog dpd = (DatePickerDialog) getSupportFragmentManager().findFragmentByTag(DATEPICKER_TAG);
            if (dpd != null) {
                dpd.setOnDateSetListener(this);
            }

            TimePickerDialog tpd = (TimePickerDialog) getSupportFragmentManager().findFragmentByTag(TIMEPICKER_TAG);
            if (tpd != null) {
                tpd.setOnTimeSetListener(this);
            }
        }

        //recycle view
        recyclerViewPlan.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPlan.setLayoutManager(mLinearLayoutManager);

        mAdapter = new PlanAdapter();
        recyclerViewPlan.setAdapter(mAdapter);

//        editTextDepTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatePickerBuilder dpb = new DatePickerBuilder()
//                        .setFragmentManager(getSupportFragmentManager())
//                        .setStyleResId(R.style.BetterPickersDialogFragment)
//                        .setYearOptional(true);
//                dpb.show();
//            }
//        });

        textLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPlanActivity.this, PickLocation.class);
                startActivity(intent);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPlanActivity.this, PickLocation.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.finish();
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_add_plan;
    }

    private boolean isVibrate() {
//        return ((CheckBox) findViewById(R.id.checkBoxVibrate)).isChecked();
        return false;
    }


    private boolean isCloseOnSingleTapDay() {
//        return ((CheckBox) findViewById(R.id.checkBoxCloseOnSingleTapDay)).isChecked();
        return false;
    }

    private boolean isCloseOnSingleTapMinute() {
//        return ((CheckBox) findViewById(R.id.checkBoxCloseOnSingleTapMinute)).isChecked();
        return false;
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        Toast.makeText(AddPlanActivity.this, "new date:" + year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();

        if(dateDeptOn == true){
            this.yearDept = year;
            this.monthDept = month;
            this.dayDept = day;

            editTextDepTime.setText(String.valueOf(this.yearDept) +"-"+ String.valueOf(this.monthDept) +"-"+ String.valueOf(this.dayDept));
            mYear = year;
            editTextArrTime.setVisibility(View.VISIBLE);
            dateDeptOn = false;
        }

        if(dateArrOn == true){
            this.yearArr = year;
            this.monthArr = month;
            this.dayArr = day;

            editTextArrTime.setText(String.valueOf(this.yearArr) +"-"+ String.valueOf(this.monthArr) +"-"+ String.valueOf(this.dayArr));
            dateArrOn = false;
        }
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        Toast.makeText(AddPlanActivity.this, "new time:" + hourOfDay + "-" + minute, Toast.LENGTH_LONG).show();
    }
}
