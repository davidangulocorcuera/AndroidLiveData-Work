package com.example.biolizard.livedataexample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    private Button btn_add;
    private Integer count = 0;
    public Switch first_switch;
    private TextView tv_option;
    MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<Boolean>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn_add = findViewById(R.id.button_add);
       first_switch = findViewById(R.id.switch_workHouse);
       tv_option = findViewById(R.id.textView_workHouse);

        mutableLiveData.observe(this, observer);


        first_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mutableLiveData.postValue(true);

                }
                else {
                    mutableLiveData.postValue(false);
                }
            }
        });
    }

    final Observer<Boolean> observer = new Observer<Boolean>() {
        @Override
        public void onChanged(@Nullable final Boolean bl_ok) {
            if(bl_ok)tv_option.setText("si");
            else tv_option.setText("no");

        }
    };




}
