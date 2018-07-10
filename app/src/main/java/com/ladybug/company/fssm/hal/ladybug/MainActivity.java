package com.ladybug.company.fssm.hal.ladybug;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ladybug.company.fssm.hal.ladybug.Util;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity implements View.OnClickListener{

    Button  btn1, btn2, btn3, btn4, btn5, btn6 ;
    EditText callerNameEditText , callerNumberEditText ;

    private void initParams(){
        this.btn1 =  (Button) findViewById(R.id.btn1);
        this.btn2 =  (Button) findViewById(R.id.btn2);
        this.btn3 =  (Button) findViewById(R.id.btn3);
        this.btn4 =  (Button) findViewById(R.id.btn4);
        this.btn5 =  (Button) findViewById(R.id.btn5);
        this.btn6 =  (Button) findViewById(R.id.btn6);

        this.callerNameEditText = (EditText) findViewById(R.id.callerNameEditText);
        this.callerNumberEditText = (EditText) findViewById(R.id.callerNumberEditText);

        this.btn1.setOnClickListener(this);
        this.btn2.setOnClickListener(this);
        this.btn3.setOnClickListener(this);
        this.btn4.setOnClickListener(this);
        this.btn5.setOnClickListener(this);
        this.btn6.setOnClickListener(this);
    }

    private void showBannerAds(){
       AdView mAdView = findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
       mAdView.loadAd(adRequest);
    }

    private void showToastAfterASpecifiedTime(String time){
        Toast.makeText(MainActivity.this , this.callerNameEditText.getText().toString() + " will call you after " +  time , Toast.LENGTH_LONG).show();
    }

    public final void setAlarm(int seconds) {
        Intent intent = new Intent(MainActivity.this, CallActivity.class);
        intent.putExtra("callerName" , this.callerNameEditText.getText().toString());
        intent.putExtra("callerNumber" , this.callerNumberEditText.getText().toString());
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + seconds * 1000, pendingIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initParams();
        this.showBannerAds();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1 :
                this.showToastAfterASpecifiedTime(Util.TOAST_TIME_BTN_1);
                this.setAlarm(Util.TIME_IN_SECONDS_BTN_1);
                break;
            case R.id.btn2 :
                this.showToastAfterASpecifiedTime(Util.TOAST_TIME_BTN_2);
                this.setAlarm(Util.TIME_IN_SECONDS_BTN_2);
                break;
            case R.id.btn3 :
                this.showToastAfterASpecifiedTime(Util.TOAST_TIME_BTN_3);
                this.setAlarm(Util.TIME_IN_SECONDS_BTN_3);
                break;
            case R.id.btn4 :
                this.showToastAfterASpecifiedTime(Util.TOAST_TIME_BTN_4);
                this.setAlarm(Util.TIME_IN_SECONDS_BTN_4);
                break;
            case R.id.btn5 :
                this.showToastAfterASpecifiedTime(Util.TOAST_TIME_BTN_5);
                this.setAlarm(Util.TIME_IN_SECONDS_BTN_5);
                break;
            case R.id.btn6 :
                this.showToastAfterASpecifiedTime(Util.TOAST_TIME_BTN_6);
                this.setAlarm(Util.TIME_IN_SECONDS_BTN_6);
                break;
        }
    }
}
