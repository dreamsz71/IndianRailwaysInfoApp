package com.pushkarnayouth.mytraindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Deepak on 12/19/2017.
 */
public class TrainRouteForm extends AppCompatActivity {

    EditText EditTextTrainName;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_routeform);

        EditTextTrainName = (EditText) findViewById(R.id.editTextTrainName);
        btnShow = (Button) findViewById(R.id.btnShow);


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TrainCode;
                TrainCode = EditTextTrainName.getText().toString();
                Intent getData = new Intent(getApplicationContext(), TrainRouteActivity.class);
                getData.putExtra("trainCode", TrainCode);
                startActivity(getData);
            }
        });
    }

}