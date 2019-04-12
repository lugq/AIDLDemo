package com.lugq.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import demo.lugq.serverdemo.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private IMyAidlInterface iMyAidlInterface;
    private TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_data = findViewById(R.id.tv_data);

        findViewById(R.id.btn_get_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 输出数据
                try {
                    String name = iMyAidlInterface.getName();
                    tv_data.setText(String.valueOf(name));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        Intent intent = new Intent();
        intent.setAction("demo.lugq.serverdemo.action");
        intent.setPackage("demo.lugq.serverdemo");

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
    }

}
