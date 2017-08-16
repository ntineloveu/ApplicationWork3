package com.example.tngp17_001.applicationwork3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText editTextInput;
    ImageButton btnPlay;
    int inputTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        editTextInput = (EditText) findViewById(R.id.editTxtInput);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            inputTotal = Integer.parseInt(editTextInput.getText().toString());
            nextPage(inputTotal);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(this, "Please enter integer number",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void nextPage(int inputTotal) {
        Intent i = new Intent(this, PlayActivity.class);
        i.putExtra("inputTotal", String.valueOf(inputTotal));
        startActivity(i);
    }
}
