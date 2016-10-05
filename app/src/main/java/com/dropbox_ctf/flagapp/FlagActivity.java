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

        mFlagEntryView = (TextView) findViewById(R.id.flag_entry);
        mFlagResultView = (TextView) findViewById(R.id.flag_result);
    }

    public void onClickTest(View v) {
        if (mFlagEntryView.getText().toString().equals(getFlag())) {
            mFlagResultView.setText(R.string.flag_result_yes);
        } else {
            mFlagResultView.setText(R.string.flag_result_no);
        }
    }

    private String getFlag() {
        byte[] rawBytes = new byte[BYTES1.length];
        for (int i = 0; i < rawBytes.length; ++i) {
            rawBytes[i] = (byte)((int)BYTES1[i] ^ (int)BYTES2[i]);
        }
        int offset = rawBytes[0];
        int len = 0;
        while(rawBytes[offset+len] != 0) {
            ++len;
        }
        byte[] flagBytes = new byte[len];
        for (int i = 0; i < len; ++i) {
            flagBytes[i] = rawBytes[offset+i];
        }
        return new String(flagBytes);
    }

    private static final byte[] BYTES1 = {(byte) 0xc5, (byte) 0xd7, (byte) 0x14, (byte) 0x84, (byte) 0xf8, (byte) 0xcf, (byte) 0x9b, (byte) 0xf4, (byte) 0xb7, (byte) 0x6f, (byte) 0x47, (byte) 0x90, (byte) 0x47, (byte) 0x30, (byte) 0x80, (byte) 0x4b, (byte) 0x9e, (byte) 0x32, (byte) 0x25, (byte) 0xa9, (byte) 0xf1, (byte) 0x33, (byte) 0xb5, (byte) 0xde, (byte) 0xa1, (byte) 0x68, (byte) 0xf4, (byte) 0xe2, (byte) 0x85, (byte) 0x1f, (byte) 0x7, (byte) 0x2f, (byte) 0xcc, (byte) 0x0, (byte) 0xfc, (byte) 0xaa, (byte) 0x7c, (byte) 0xa6, (byte) 0x20, (byte) 0x61, (byte) 0x71, (byte) 0x7a, (byte) 0x48, (byte) 0xe5, (byte) 0x2e, (byte) 0x29, (byte) 0xa3, (byte) 0xfa, (byte) 0x37, (byte) 0x9a};
    private static final byte[] BYTES2 = {(byte) 0xd4, (byte) 0xe8, (byte) 0xbe, (byte) 0xec, (byte) 0x6b, (byte) 0x2c, (byte) 0xb5, (byte) 0x31, (byte) 0x15, (byte) 0x14, (byte) 0xd3, (byte) 0xce, (byte) 0x27, (byte) 0x6f, (byte) 0x90, (byte) 0xce, (byte) 0x6d, (byte) 0x5b, (byte) 0x4b, (byte) 0xda, (byte) 0x94, (byte) 0x41, (byte) 0xc1, (byte) 0x81, (byte) 0xc7, (byte) 0x4, (byte) 0x95, (byte) 0x85, (byte) 0xda, (byte) 0x77, (byte) 0x62, (byte) 0x5d, (byte) 0xa9, (byte) 0x0, (byte) 0xc7, (byte) 0x53, (byte) 0xd7, (byte) 0xc7, (byte) 0x5c, (byte) 0x69, (byte) 0xfb, (byte) 0x41, (byte) 0x38, (byte) 0x5b, (byte) 0x79, (byte) 0x83, (byte) 0x79, (byte) 0xe5, (byte) 0x4, (byte) 0xd0};
}