package com.pushkarnayouth.mytraindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Deepak on 12/28/2017.
 */
public class TrainPnrForm extends AppCompatActivity {
    EditText editTextPNR;
    Button btnShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_pnrform);

        editTextPNR = (EditText) findViewById(R.id.editTextPNR);
        btnShow = (Button) findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PnrCode;
                PnrCode = editTextPNR.getText().toString();
                Intent getData = new Intent(getApplicationContext(), TrainPnrActivity.class);
                getData.putExtra("pnrCode", PnrCode);
                startActivity(getData);
            }
        });
    }
}
