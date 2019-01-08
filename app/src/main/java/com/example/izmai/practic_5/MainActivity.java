package com.example.izmai.practic_5;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

        EditText etText;
        Button btnSave, btnLoad;
        SharedPreferences sPref;
final String SAVED_TEXT = "saved_text";
/**
 * Called when the activity is first created.
 */
@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = (EditText) findViewById(R.id.etText);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
        }
@Override
public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btnSave:
        saveText();
        break;

        case R.id.btnLoad:
        loadText();
        break;
        default:
        break;
        }
        }
        void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();

        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

        }
        void loadText() {
            sPref = getPreferences(MODE_PRIVATE);
            String outpat = sPref.getString(SAVED_TEXT,"Default");
            Toast.makeText(this,outpat,Toast.LENGTH_SHORT).show();
        }}