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

public class TrainBetweenStationActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainbetweenstation);

        rv = (RecyclerView) findViewById(R.id.rcv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Intent getTrainbtstation = getIntent();
        String trainsrccode = getTrainbtstation.getStringExtra("sourceCode");
        String traindestcode = getTrainbtstation.getStringExtra("destinationCode");
        String trainjourneydate = getTrainbtstation.getStringExtra("journeyDate");
        getTrainbetweenstation(trainsrccode, traindestcode, trainjourneydate);
    }

    private void getTrainbetweenstation(String trainsrccode, String traindestcode, String trainjourneydate) {
        final Call<TrainBetweenStation> trainbetweenStation = IndianRailwayApi.getBetweenStationService().getTrains(trainsrccode, traindestcode, trainjourneydate);

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(TrainBetweenStationActivity.this);
        progressDialog.setMax(100);

        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("Trains Between Stations Data");
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


        trainbetweenStation.enqueue(new Callback<TrainBetweenStation>() {
            @Override
            public void onResponse(Call<TrainBetweenStation> call, Response<TrainBetweenStation> response) {
                TrainBetweenStation tbetweenstationlist = response.body();
                rv.setAdapter(new TrainbetweenstationAdapter(TrainBetweenStationActivity.this, tbetweenstationlist.getTrains()));
                progressDialog.dismiss();
                if (tbetweenstationlist.getResponseCode() > 200) {
                    Toast.makeText(TrainBetweenStationActivity.this, "No Data found", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TrainBetweenStationActivity.this, "Data loaded Successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TrainBetweenStation> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(TrainBetweenStationActivity.this, "Server is Busy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
