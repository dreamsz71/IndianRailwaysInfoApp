package com.pushkarnayouth.mytraindemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Deepak on 12/27/2017.
 */
public class TrainArrivalsActivity extends AppCompatActivity {
    RecyclerView ArrivalsList;
    String stationCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainarrivals);

        ArrivalsList = (RecyclerView) findViewById(R.id.ArrivalsList);
        ArrivalsList.setLayoutManager(new LinearLayoutManager(this));

        Intent getDataHere = getIntent();
        String stationCode = getDataHere.getStringExtra("stationCode");
        String hours = getDataHere.getStringExtra("hours");

        //calling the method to display the heroes
        getTrainArrivals(stationCode, hours);
    }

    private void getTrainArrivals(String trainCode, String hours) {
        final Call<TrainArrivals> trainArrivals = IndianRailwayApi.getTrainArrivalsService().getArrivals(trainCode, hours);

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(TrainArrivalsActivity.this);
        progressDialog.setMax(100);

        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("Train Arrivals Data");
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

        trainArrivals.enqueue(new Callback<TrainArrivals>() {
            @Override
            public void onResponse(Call<TrainArrivals> call, Response<TrainArrivals> response) {
                TrainArrivals tArrivalsList = response.body();
                ArrivalsList.setAdapter(new TrainArrivalsAdapter(TrainArrivalsActivity.this, tArrivalsList, stationCode));
                progressDialog.dismiss();
                if (tArrivalsList.getResponseCode() > 200) {
                    Toast.makeText(TrainArrivalsActivity.this, "No trains are found", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TrainArrivalsActivity.this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<TrainArrivals> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(TrainArrivalsActivity.this, "Server is busy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}