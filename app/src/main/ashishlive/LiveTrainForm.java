package com.pushkarnayouth.mytraindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LiveTrainForm extends AppCompatActivity {

    EditText trainText,date;
    Button statusButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_livestatusform);

        trainText=(EditText)findViewById(R.id.editText);
        statusButton=(Button)findViewById(R.id.button);
        date=(EditText)findViewById(R.id.date);

        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TrainCode;
                String TrainDate;
                TrainDate = date.getText().toString();
                TrainCode = trainText.getText().toString();
                Intent getData = new Intent(getApplicationContext(),LiveTrainActivity.class);
                getData.putExtra("trainCode",TrainCode);
                getData.putExtra("trainDate",TrainDate);
                startActivity(getData);
            }
        });
    }
}