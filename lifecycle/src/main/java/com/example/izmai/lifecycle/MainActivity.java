package com.example.izmai.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private MyServer myServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myServer = new MyServer();
        getLifecycle().addObserver(myServer);
    }
}

class MyServer implements LifecycleObserver {
    private String TAG = MyServer.class.getSimpleName();
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connect() {
        Log.d(TAG,"connect");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disconnect() {
        Log.d(TAG,"disconnect");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        Log.d(TAG,"Pause");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        Log.d(TAG,"resume");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destr() {
        Log.d(TAG,"destroy");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void creatr() {
        Log.d(TAG,"create");
    }
}

