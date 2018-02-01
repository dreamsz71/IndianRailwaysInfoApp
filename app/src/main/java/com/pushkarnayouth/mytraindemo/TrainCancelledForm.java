package com.pushkarnayouth.mytraindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TrainCancelledForm extends AppCompatActivity {

    String[] data = new String[]{"----Select Date----", "Yesterday", "Today", "Tomorrow"};
    Spinner s;
    Button bt;
    String spinner_Val = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_cancelledform);

        s = (Spinner) findViewById(R.id.spinner);
        bt = (Button) findViewById(R.id.button);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner_Val = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(TrainCancelledForm.this, TrainCancelledActivity.class);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                if (spinner_Val.equals("Today")) {
                    String formattedDate = df.format(c.getTime());
                    in.putExtra("formattedDate", formattedDate);
                    startActivity(in);
                } else if (spinner_Val.equals("Yesterday")) {
                    c.add(Calendar.DATE, -1);
                    String formattedDate = df.format(c.getTime());
                    in.putExtra("formattedDate", formattedDate);
                    startActivity(in);
                } else if (spinner_Val.equals("Tomorrow")) {
                    c.add(Calendar.DATE, +1);
                    String formattedDate = df.format(c.getTime());
                    in.putExtra("formattedDate", formattedDate);
                    startActivity(in);
                }
            }
        });
    }
}
