package com.pushkarnayouth.mytraindemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepak on 12/27/2017.
 */
public class TrainArrivalsForm extends AppCompatActivity {

    //EditText editTextStationCode;
    AutoCompleteTextView editTextStationCode;
    Spinner spinnerHours;
    Button btnAShow;

    ArrayAdapter<String> adapter;
    List<String> responseList = new ArrayList<String>();
    String data = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_arrivalsform);

        // editTextStationCode =(EditText) findViewById(R.id.editTextStationCode);
        editTextStationCode = (AutoCompleteTextView) findViewById(R.id.editTextStationCode);
        spinnerHours = (Spinner) findViewById(R.id.spinnerHours);

        //Code For AutoComplete TextView.
        new HttpGetTask().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, responseList);
        editTextStationCode.setAdapter(adapter);

        // Spinner Drop down elements
        List<String> hourValues = new ArrayList<String>();
        hourValues.add("2");
        hourValues.add("4");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hourValues);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerHours.setAdapter(dataAdapter);


        btnAShow = (Button) findViewById(R.id.btnAShow);

        btnAShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(TrainArrivalsForm.this, "Reached here : ", Toast.LENGTH_SHORT).show();
                String StationCode, Hours;
                //StationCode = editTextStationCode.getText().toString();
                Hours = spinnerHours.getSelectedItem().toString();

                String str1 = "(";
                String trainsourcecodes = editTextStationCode.getText().toString();
                int m = str1.length();
                int n = trainsourcecodes.length();
                String trainsourcecode = "";
                boolean res = issubstring(str1, trainsourcecodes, m, n);
                if (res) {
                    StationCode = trainsourcecodes.substring(trainsourcecodes.indexOf("(") + 1, trainsourcecodes.indexOf(")"));
                } else {
                    StationCode = trainsourcecodes;
                }


                Intent getArrivalsData = new Intent(TrainArrivalsForm.this, TrainArrivalsActivity.class);
                getArrivalsData.putExtra("stationCode", StationCode);
                getArrivalsData.putExtra("hours", Hours);
                startActivity(getArrivalsData);
            }
        });

    }

    private boolean issubstring(String str1, String trainsourcecodes, int m, int n) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        if (str1.charAt(m - 1) == trainsourcecodes.charAt(n - 1))
            return issubstring(str1, trainsourcecodes, m - 1, n - 1);
        return issubstring(str1, trainsourcecodes, m, n - 1);
    }

    //Code to get data from Api.
    private class HttpGetTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                //URL url = new URL("http://192.168.43.127:3000/nametocode"); //Api when server is on in laptop.
                URL url = new URL("https://api.myjson.com/bins/163dj9");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                JSONArray JA = new JSONArray(data);
                for (int i = 0; i <= JA.length(); i++) {
                    final JSONObject e = JA.getJSONObject(i);
                    String name = e.getString("trainname");
                    responseList.add(name);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
