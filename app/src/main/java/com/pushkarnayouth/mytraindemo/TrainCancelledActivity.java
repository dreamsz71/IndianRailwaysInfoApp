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

public class TrainCancelledActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traincancelled);

        rv = (RecyclerView) findViewById(R.id.rcv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        Intent in = getIntent();
        String requiredDate = in.getStringExtra("formattedDate");
        getTrainCancelled(requiredDate);
    }

    private void getTrainCancelled(String requiredDate) {
        Call<TrainCancelled> trainCancelled = IndianRailwayApi.getTrainCancelledService().getCancelledTrains(requiredDate);

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(TrainCancelledActivity.this);
        progressDialog.setMax(100);

        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("Trains Cancelled Data");
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


        trainCancelled.enqueue(new Callback<TrainCancelled>() {
            @Override
            public void onResponse(Call<TrainCancelled> call, Response<TrainCancelled> response) {
                TrainCancelled tcancelledlist = response.body();
                rv.setAdapter(new TrainCancelledAdapter(TrainCancelledActivity.this, tcancelledlist.getTrains()));
                progressDialog.dismiss();

                if (tcancelledlist.getResponseCode() > 200) {
                    Toast.makeText(TrainCancelledActivity.this, "No trains are found", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TrainCancelledActivity.this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
                }


                //Toast.makeText(TrainCancelledActivity.this,"Data Loaded Successfully",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TrainCancelled> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(TrainCancelledActivity.this, "Server Is Busy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
