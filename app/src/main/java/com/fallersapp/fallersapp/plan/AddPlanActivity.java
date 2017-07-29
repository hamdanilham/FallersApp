package com.fallersapp.fallersapp.plan;

import android.content.ClipData;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.fallersapp.fallersapp.home.MainActivity;
import com.fallersapp.fallersapp.home.mMenu;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;

/**
 * Created by hamda on 13/07/2017.
 */

public class AddPlanActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener,AdapterView.OnItemSelectedListener, ListItemAdapter.OnClickInAdapter{

    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";

    private Integer THRESHOLD = 2;
    private DelayAutoCompleteTextView geo_autocomplete;
//    private ImageView geo_autocomplete_clear;

    @BindView(R.id.btn_add)
    Button buttonAdd;

    @BindView(R.id.et_location)
    EditText textLocation;

    @BindView(R.id.rv_list_plan)
    RecyclerView recyclerViewPlan;

    @BindView(R.id.et_list_item)
    EditText editTextListItem;

    @BindView(R.id.et_dep_time)
    EditText editTextDepTime;

    @BindView(R.id.et_arr_time)
    EditText editTextArrTime;

    @BindView(R.id.enter)
    ImageView imageViewEnter;

    @BindView(R.id.spinner_family)
    Spinner spinnerFamily;

    int yearDept, yearArr, mYear = 1985;
    int monthDept, monthArr;
    int dayDept, dayArr;
    boolean dateDeptOn = false;
    boolean dateArrOn = false;
    String item;

    List<ListItem> itemArrayList = new ArrayList<>();
    List<ListItem> ItemList;
    List<String> itemFamily;
    ListItemAdapter listItemAdapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_add_plan);
        ButterKnife.bind(this);
        setToolbar(true);

//        geo_autocomplete_clear = (ImageView) findViewById(R.id.geo_autocomplete_clear);

//        geo_autocomplete = (DelayAutoCompleteTextView) findViewById(R.id.geo_autocomplete);
//        geo_autocomplete.setThreshold(THRESHOLD);
//        geo_autocomplete.setAdapter(new GeoAutoCompleteAdapter(this)); // 'this' is Activity instance
//        geo_autocomplete.setLoadingIndicator(
//                (android.widget.ProgressBar) findViewById(R.id.pb_loading_indicator));
//
//        geo_autocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                GeoSearchResult result = (GeoSearchResult) adapterView.getItemAtPosition(position);
//                geo_autocomplete.setText(result.getAddress());
//            }
//        });
//        geo_autocomplete.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (s.length() > 0) {
//                    .setVisibility(View.VISIBLE);
//                } else {
//                    geo_autocomplete_clear.setVisibility(View.GONE);
//                }
//            }
//        });

//        geo_autocomplete_clear.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                geo_autocomplete.setText("");
//            }
//        });

        spinnerFamily.setOnItemSelectedListener(this);
        itemFamily = new ArrayList<String>();
        itemFamily.add("A Family's");
        itemFamily.add("B Family's");
        itemFamily.add("C Family's");
        itemFamily.add("D Family's");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_style, itemFamily);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFamily.setAdapter(dataAdapter);


        //recycle view
        listItemAdapter = new ListItemAdapter(this, itemArrayList);
        recyclerViewPlan.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPlan.setAdapter(listItemAdapter);

//        recyclerViewPlan.setHasFixedSize(true);
//        recyclerViewPlan.setItemAnimator(new DefaultItemAnimator());

        ItemList = new ArrayList<>();

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

        imageViewEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = editTextListItem.getText().toString();

                ItemList.add(new ListItem(item));

                itemArrayList.addAll(ItemList);
                listItemAdapter.notifyDataSetChanged();

                ItemList.clear();
                editTextListItem.setText(null);
            }
        });

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClickInAdapter(int content) {
        itemArrayList.remove(content);
        listItemAdapter.notifyDataSetChanged();
    }
}
