package com.test.shift;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String TAG = "KeyInfo";
    private TextView mKeyInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
    }
    
    private void init() {
        mKeyInfo = (TextView)findViewById(R.id.key_info);
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "" + event);
        showKeyInfo(keyCode, event);
        return super.onKeyDown(keyCode, event);
    }
    
    private void showKeyInfo(int keyCode, KeyEvent event) {
        String info = String.format(
                "keyCode = %d\n" +
                "scanCode = 0x%x\n" +
                "deviceId = %d\n" +
        		"isSystem = %b\n" +
        		"downTime = %d\n" +
        		"eventTime = %d\n" +
        		"source = 0x%x\n" +
        		"repeatCount = %d\n" +
        		"action = %s", keyCode, event.getScanCode(),
        		event.getDeviceId(),  event.isSystem(),
        		event.getDownTime(), event.getEventTime(),
        		event.getSource(), event.getRepeatCount(),
        		KeyEvent.actionToString(event.getAction()));
        
        mKeyInfo.setText(info);
    }

}
