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

/**
 * Created by Deepak on 12/19/2017.
 */
public class TrainRouteActivity extends AppCompatActivity {
    RecyclerView RouteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainroute);

        RouteList = (RecyclerView) findViewById(R.id.RouteList);
        RouteList.setLayoutManager(new LinearLayoutManager(this));
        //

        Intent getDataHere = getIntent();
        String trainCode = getDataHere.getStringExtra("trainCode");


        //calling the method to display the heroes
        getTrainRoutes(trainCode);
    }

    private void getTrainRoutes(String trainCode) {

        final Call<TrainRoute> trainRoute = IndianRailwayApi.getTrainRouteService().getRoute(trainCode);

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(TrainRouteActivity.this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("Train Route Data");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
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

        trainRoute.enqueue(new Callback<TrainRoute>() {
            @Override
            public void onResponse(Call<TrainRoute> call, Response<TrainRoute> response) {
                TrainRoute tRouteList = response.body();
                RouteList.setAdapter(new TrainRouteAdapter(TrainRouteActivity.this, tRouteList)); //.getRoute()
                progressDialog.dismiss();

                if (tRouteList.getResponseCode() > 200) {
                    Toast.makeText(TrainRouteActivity.this, "No trains are found", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TrainRouteActivity.this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
                }


                //Creating an String array for the ListView
                //String[] tRoutes = new String[tRouteList.getRoute().size()];

                /*//looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < tRouteList.getRoute().size(); i++) {
                    tRoutes[i] = tRouteList.getRoute().get(i).getStation().getName();
                }*/


                //displaying the string array into listview
                // listView.setAdapter(new ArrayAdapter<String>(TrainRouteActivity.this, android.R.layout.simple_list_item_1, tRoutes));
            }

            @Override
            public void onFailure(Call<TrainRoute> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(TrainRouteActivity.this, "Server Is Busy", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
