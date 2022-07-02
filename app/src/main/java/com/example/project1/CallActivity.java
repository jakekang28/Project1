package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallActivity extends Activity implements View.OnClickListener {

    private Button mCall;
    private Button mDialogCall;
    private EditText mEditNumber;
    private String mNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callactivity);
        mDialogCall = (Button) findViewById(R.id.btnDialog);
        mEditNumber = (EditText) findViewById(R.id.edtNumber);

        mDialogCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        mNum = mEditNumber.getText().toString();
        String tel = "tel:" + mNum;
        switch (v.getId()){
            case R.id.btnDialog:
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
                break;
        }
    }
}