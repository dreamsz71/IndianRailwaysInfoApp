package com.pushkarnayouth.mytraindemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;

public class SeatAvailabiliity_RCV extends AppCompatActivity {

    RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_availabiliity__rcv);

        rcv = (RecyclerView) findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        Intent getTrainDataHere = getIntent();
        String trainCode = getTrainDataHere.getStringExtra("trainCode");
        String sourceCode = getTrainDataHere.getStringExtra("sourceCode");
        String destCode = getTrainDataHere.getStringExtra("destCode");
        String classCode = getTrainDataHere.getStringExtra("classCode");
        String trainDate = getTrainDataHere.getStringExtra("trainDate");

        getSeatAvailability(trainCode, sourceCode, destCode, classCode, trainDate);

    }

    private void getSeatAvailability(String trainCode, String sourceCode, String destCode, String trainDate, String classCode) {

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(SeatAvailabiliity_RCV.this);
        progressDialog.setMax(100);

        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("Seat Availability ...");
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

        final retrofit2.Call<SeatAvailability> seatAvailabilityCall = IndianRailwayApi.getSeatAvailabilityService()
                .getAvailability(trainCode, sourceCode, destCode, classCode, trainDate);
        seatAvailabilityCall.enqueue(new Callback<SeatAvailability>() {
            @Override
            public void onResponse(retrofit2.Call<SeatAvailability> call, Response<SeatAvailability> response) {

                SeatAvailability seatAvailability = response.body();
                int availCount = seatAvailability.getAvailability().size();
                if (availCount == 0) {
                    Toast.makeText(SeatAvailabiliity_RCV.this, "please enter valid entries...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SeatAvailabiliity_RCV.this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
                }
                rcv.setAdapter(new SeatAvailabilityAdapter(SeatAvailabiliity_RCV.this, seatAvailability));
                progressDialog.dismiss();
                //seatAvailability.getAvailability() we need to pass complete reference object here later on

            }

            @Override
            public void onFailure(retrofit2.Call<SeatAvailability> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(SeatAvailabiliity_RCV.this, "Server is busy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}