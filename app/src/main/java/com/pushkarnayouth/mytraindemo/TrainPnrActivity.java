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
 * Created by Deepak on 12/28/2017.
 */
public class TrainPnrActivity extends AppCompatActivity {
    RecyclerView PnrStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainpnr);

        PnrStatus = (RecyclerView) findViewById(R.id.PnrStatus);
        PnrStatus.setLayoutManager(new LinearLayoutManager(this));
        //

        Intent getDataHere = getIntent();
        String pnrCode = getDataHere.getStringExtra("pnrCode");
        //calling the method to display the heroes
        getPnrStatus(pnrCode);
    }

    private void getPnrStatus(String pnrCode) {

        final Call<TrainPnr> trainPnr = IndianRailwayApi.getTrainPnrService().getPnrStatusDetails(pnrCode);

        // Set up progress before call
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(TrainPnrActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("PNR Status Data");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // show it
        progressDoalog.show();


        trainPnr.enqueue(new Callback<TrainPnr>() {
            @Override
            public void onResponse(Call<TrainPnr> call, Response<TrainPnr> response) {
                TrainPnr tPnrObject = response.body();
                //List<Passenger> passengerList = tPnrObject.getPassengers();
                PnrStatus.setAdapter(new TrainPnrAdapter(TrainPnrActivity.this, tPnrObject));
                progressDoalog.dismiss();
                if (tPnrObject.getResponseCode() > 200) {
                    Toast.makeText(TrainPnrActivity.this, "No PNR data found", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TrainPnrActivity.this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
                }


                //Toast.makeText(TrainPnrActivity.this, "Success Deepak: ", Toast.LENGTH_SHORT).show();

                //Creating an String array for the ListView deepak
                //String[] tRoutes = new String[tRouteList.getRoute().size()];

                /*//looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < tRouteList.getRoute().size(); i++) {
                    tRoutes[i] = tRouteList.getRoute().get(i).getStation().getName();
                }*/


                //displaying the string array into listview
                // listView.setAdapter(new ArrayAdapter<String>(TrainRouteActivity.this, android.R.layout.simple_list_item_1, tRoutes));
            }

            @Override
            public void onFailure(Call<TrainPnr> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(TrainPnrActivity.this, "Failure Deepak", Toast.LENGTH_SHORT).show();
            }
        });
    }
}