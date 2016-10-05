package com.dropbox_ctf.flagapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FlagActivity extends AppCompatActivity {
    private static String TAG = "com.dropbox_ctf.flagapp.FlagActivity";
    private TextView mFlagEntryView;
    private TextView mFlagResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        mFlagEntryView = (TextView)findViewById(R.id.flag_entry);
        mFlagResultView = (TextView)findViewById(R.id.flag_result);
    }

    public void onClickTest(View v) {
        if (mFlagEntryView.getText().toString().equals("insert_flag_here")) {
            mFlagResultView.setText(R.string.flag_result_yes);
        } else {
            mFlagResultView.setText(R.string.flag_result_no);
        }
    }
}
