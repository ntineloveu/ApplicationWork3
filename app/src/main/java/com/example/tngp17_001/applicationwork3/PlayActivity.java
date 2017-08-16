package com.example.tngp17_001.applicationwork3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayActivity extends Activity implements View.OnClickListener {

    private TextView txtShow;
    private ImageButton btnStar;
    private int inputTotal;
    private int check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        initInstances();
        getExtraString();
    }

    private void getExtraString() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String value1 = extras.getString("inputTotal");
        try {
            if (value1 != null) inputTotal = Integer.parseInt(value1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void initInstances() {
        check = 0;
        inputTotal = 0;
        txtShow = (TextView) findViewById(R.id.txtShow);
        btnStar = (ImageButton) findViewById(R.id.btnStar);
        btnStar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            check = Integer.parseInt(txtShow.getText().toString());
            if (check == inputTotal) backMain();
            else txtShow.setText(String.valueOf(++check));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void backMain() {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
}
