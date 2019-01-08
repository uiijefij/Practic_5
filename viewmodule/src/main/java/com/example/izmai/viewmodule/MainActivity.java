package com.example.izmai.viewmodule;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.arch.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        final MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getProgressState().observe(this, new
                Observer<Boolean>() {
                    @Override
                    public void onChanged(@Nullable Boolean
                                                  isVisibleProgressBar) {
                        if (isVisibleProgressBar) {
                            progressBar.setVisibility(View.VISIBLE);
                        } else {
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
        viewModel.doSomeThing();
    }
}

class MyViewModel extends ViewModel {
    private MutableLiveData<Boolean> showProgress = new
            MutableLiveData<>();
    void doSomeThing() {
        showProgress.postValue(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showProgress.postValue(false);
            }
        }, 10000);
    }
    MutableLiveData<Boolean> getProgressState() {
        return showProgress;
    }
}
