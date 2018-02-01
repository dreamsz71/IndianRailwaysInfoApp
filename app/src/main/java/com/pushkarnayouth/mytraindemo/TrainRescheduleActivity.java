package com.pushkarnayouth.mytraindemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainRescheduleActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_reschedule);

        rv = (RecyclerView) findViewById(R.id.rcv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Intent in = getIntent();
        String resdate = in.getStringExtra("formattedDate");
        getTrainReschedule(resdate);
    }

    private void getTrainReschedule(String resdate) {
        final Call<TrainReschedule> trainreschedule = IndianRailwayApi.getTrainRescheduleService().getTrains(resdate);

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(TrainRescheduleActivity.this);
        progressDialog.setMax(100);

        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("Train Reschedule Data...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        // show it
        progressDialog.show();
        final int totalProgressTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while (jumpTime < totalProgressTime) {
                    try {
                        sleep(200);
                        jumpTime += 5;
                        progressDialog.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();


        trainreschedule.enqueue(new Callback<TrainReschedule>() {
            @Override
            public void onResponse(Call<TrainReschedule> call, Response<TrainReschedule> response) {
                TrainReschedule tschedulelist = response.body();
                rv.setAdapter(new TrainRescheduleAdapter(TrainRescheduleActivity.this, tschedulelist.getTrains()));
                progressDialog.dismiss();
                if (tschedulelist.getResponseCode() > 200) {
                    Toast.makeText(TrainRescheduleActivity.this, "No trains are found", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TrainRescheduleActivity.this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
                }

                // Toast.makeText(TrainRescheduleActivity.this,"Data Loaded Sussccessfully",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TrainReschedule> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(TrainRescheduleActivity.this, "Server is busy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
