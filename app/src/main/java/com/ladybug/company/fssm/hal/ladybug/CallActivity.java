package com.ladybug.company.fssm.hal.ladybug;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CallActivity extends Activity implements View.OnClickListener {


    MediaPlayer mySong;
    Button btnResponse, btnCancel;
    TextView callerNameTextView, callerNumberTextView;

    private void initParams() {
        this.btnResponse = (Button) findViewById(R.id.btnResponse);
        this.btnCancel = (Button) findViewById(R.id.btnCancel);

        this.callerNameTextView =(TextView) findViewById(R.id.callerNameTextView);
        this.callerNumberTextView =(TextView) findViewById(R.id.callerNumbertextView);

        this.btnResponse.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
    }

    private void getExtras(){
        Intent  intent =  getIntent();
        this.callerNameTextView.setText(intent.getStringExtra("callerName"));
        this.callerNumberTextView.setText(intent.getStringExtra("callerNumber"));
    }

    private void playRingtone(){
        this.mySong = MediaPlayer.create(CallActivity.this, R.raw.ringtone);
        this.mySong.start();
    }

    private void cancelCall() {
        this.mySong.stop();
        Intent intent = new Intent(CallActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void responseCall() {
        this.mySong.stop();
        Intent intent = new Intent(CallActivity.this, ResponseActivity.class);
        intent.putExtra("callerName" , this.callerNameTextView.getText().toString());
        intent.putExtra("callerNumber" , this.callerNumberTextView.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        this.initParams();
        this.getExtras();
        this.playRingtone();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel:
                 this.cancelCall();
                break;
            case R.id.btnResponse :
                this.responseCall();
                break ;
        }
    }
}
