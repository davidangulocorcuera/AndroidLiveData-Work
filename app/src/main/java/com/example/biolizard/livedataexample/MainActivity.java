package com.example.biolizard.livedataexample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Switch first_switch;
    private TextView tv_firstText;
    public Switch second_switch;
    private TextView tv_secondtext;
    private EditText et_age;
    private TextView tv_showAge;
    MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<Boolean>();
    MutableLiveData<Boolean> secondMutableLiveData = new MutableLiveData<Boolean>();
    MutableLiveData<String> thirdMutableLiveData = new MutableLiveData<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first_switch = findViewById(R.id.switch_firstSwitch);
        tv_firstText = findViewById(R.id.textView_firstText);
        second_switch = findViewById(R.id.switch_secondSwitch);
        tv_secondtext = findViewById(R.id.textView_secondText);
        et_age = findViewById(R.id.editText_age);
        tv_showAge = findViewById(R.id.textView_showAge);


        mutableLiveData.observe(this, observer);
        secondMutableLiveData.observe(this, secondObserver);
        thirdMutableLiveData.observe(this, thirdObserver);


        first_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mutableLiveData.postValue(true);

                } else {
                    mutableLiveData.postValue(false);
                }
            }
        });

        second_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    secondMutableLiveData.postValue(true);

                } else {
                    secondMutableLiveData.postValue(false);
                }
            }
        });
        et_age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                thirdMutableLiveData.postValue(et_age.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                thirdMutableLiveData.postValue(et_age.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                thirdMutableLiveData.postValue(et_age.getText().toString());
            }
        });

    }

    final Observer<Boolean> observer = new Observer<Boolean>() {
        @Override
        public void onChanged(@Nullable final Boolean bl_ok) {
            if (bl_ok) tv_firstText.setText("si");
            else tv_firstText.setText("no");

        }
    };


    final Observer<Boolean> secondObserver = new Observer<Boolean>() {
        @Override
        public void onChanged(@Nullable final Boolean bl_ok2) {
            if (bl_ok2) tv_secondtext.setText("si");
            else tv_secondtext.setText("no");

        }
    };
    final Observer<String> thirdObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable final String num) {
            tv_showAge.setText("tu edad es " + num);

        }
    };

}
