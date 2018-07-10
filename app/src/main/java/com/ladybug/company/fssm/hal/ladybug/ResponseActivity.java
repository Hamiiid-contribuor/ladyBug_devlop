package com.ladybug.company.fssm.hal.ladybug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class ResponseActivity extends Activity implements View.OnClickListener{

    TextView callerNameTextView, callerNumberTextView , timeCounterTextView ;
    Button endCallBtn ;

    private void initParams(){
        this.callerNameTextView = (TextView) findViewById(R.id.callerNameTextView2);
        this.callerNumberTextView = (TextView) findViewById(R.id.callerNumbertextView2);
        this.timeCounterTextView = (TextView) findViewById(R.id.timeCounterTextView);

        this.endCallBtn = (Button) findViewById(R.id.endCallBtn);

        this.endCallBtn.setOnClickListener(this);
    }

    private void getExtras(){
        Intent intent =  getIntent();
        this.callerNameTextView.setText(intent.getStringExtra("callerName"));
        this.callerNumberTextView.setText(intent.getStringExtra("callerNumber"));
    }

    private void endCall(){
        Intent intent =  new Intent(ResponseActivity.this , MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        this.initParams();
        this.getExtras();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.endCallBtn) {
            this.endCall();
        }
    }


}
