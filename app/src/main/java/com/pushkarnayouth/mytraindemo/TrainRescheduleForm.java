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

public class TrainRescheduleForm extends AppCompatActivity {

    String[] resdate = new String[]{"----Select Date----", "Yesterday", "Today", "Tomorrow"};
    Spinner s;
    Button bt;
    String spinner_val = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_rescheduleform);

        s = (Spinner) findViewById(R.id.spinner);
        bt = (Button) findViewById(R.id.button);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resdate);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner_val = resdate[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), TrainRescheduleActivity.class);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                if (spinner_val.equals("Today")) {
                    String formattedDate = df.format(c.getTime());
                    in.putExtra("formattedDate", formattedDate);
                    startActivity(in);
                } else if (spinner_val.equals("Yesterday")) {
                    c.add(Calendar.DATE, -1);
                    String formattedDate = df.format(c.getTime());
                    in.putExtra("formattedDate", formattedDate);
                    startActivity(in);
                } else if (spinner_val.equals("Tomorrow")) {
                    c.add(Calendar.DATE, +1);
                    String formattedDate = df.format(c.getTime());
                    in.putExtra("formattedDate", formattedDate);
                    startActivity(in);
                }
            }
        });
    }
}

