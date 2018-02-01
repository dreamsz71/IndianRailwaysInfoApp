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

public class LiveTrainActivity extends AppCompatActivity {

    RecyclerView RouteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_livestatus);

        RouteList  = (RecyclerView)findViewById(R.id.rcv);
        RouteList.setLayoutManager(new LinearLayoutManager(this));
        //
        Intent getDataHere = getIntent();
        String trainCode = getDataHere.getStringExtra( "trainCode");
        String trainDate = getDataHere.getStringExtra("trainDate");

        //calling the method to display live train
        getTrainStatus(trainCode,trainDate);

    }
    public void getTrainStatus(String trainCode, String trainDate)
    {
        final Call<LiveTrain> liveTrainCall = IndianRailwayApi.getLiveTrainService().getRoute(trainCode,trainDate);
        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(LiveTrainActivity.this);
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

                while(jumpTime < totalProgressTime) {
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

        liveTrainCall.enqueue(new Callback<LiveTrain>() {
            @Override
            public void onResponse(Call<LiveTrain> call, Response<LiveTrain> response) {
                LiveTrain liveTrain = response.body();
                RouteList.setAdapter(new LiveTrainAdapter(LiveTrainActivity.this, liveTrain.getRoute()));
                progressDialog.dismiss();
                if(liveTrain.getResponseCode() > 200)
                {
                    Toast.makeText(LiveTrainActivity.this, "No Live data found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LiveTrainActivity.this, "Data loaded Successfully: ", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<LiveTrain> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LiveTrainActivity.this, "Server is busy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}