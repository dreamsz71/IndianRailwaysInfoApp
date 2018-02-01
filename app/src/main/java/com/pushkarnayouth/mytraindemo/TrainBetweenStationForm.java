package com.pushkarnayouth.mytraindemo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

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
import java.util.Calendar;
import java.util.List;


public class TrainBetweenStationForm extends AppCompatActivity {

    //EditText sourcecode,destinationcode,journeydate;
    //Button searchtrain;

    EditText journeydate;
    AutoCompleteTextView sourcecode, destinationcode;
    Button searchtrain;
    ArrayAdapter<String> adapter;
    List<String> responseList = new ArrayList<String>();
    String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_betweenstationform);
        sourcecode = (AutoCompleteTextView) findViewById(R.id.editText);
        destinationcode = (AutoCompleteTextView) findViewById(R.id.editText2);
        journeydate = (EditText) findViewById(R.id.editText3);
        searchtrain = (Button) findViewById(R.id.button);

        //Code For AutoComplete TextView.
        new HttpGetTask().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, responseList);
        sourcecode.setAdapter(adapter);
        destinationcode.setAdapter(adapter);


        /*Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        journeydate.setText(formattedDate);*/

        //Code For DatePicker and hide Keyboard.
        journeydate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(journeydate.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                final Calendar c = Calendar.getInstance();
                int myear = c.get(Calendar.YEAR);
                int mmonth = c.get(Calendar.MONTH);
                int mdate = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(TrainBetweenStationForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        journeydate.setText(i2 + "-0" + (i1 + 1) + "-" + i);
                    }
                }, mdate, mmonth, myear);
                datePickerDialog.show();
            }
        });


        //Code to go to next intent.
        searchtrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = "(";
                String trainsourcecodes = sourcecode.getText().toString();
                int m = str1.length();
                int n = trainsourcecodes.length();
                String trainsourcecode = "";
                boolean res = issubstring(str1, trainsourcecodes, m, n);
                if (res) {
                    trainsourcecode = trainsourcecodes.substring(trainsourcecodes.indexOf("(") + 1, trainsourcecodes.indexOf(")"));
                } else {
                    trainsourcecode = trainsourcecodes;
                }
                String traindestinationcodes = destinationcode.getText().toString();
                int o = traindestinationcodes.length();
                String traindestinationcode = "";
                boolean res1 = issubstring(str1, traindestinationcodes, m, o);
                if (res1) {
                    traindestinationcode = traindestinationcodes.substring(traindestinationcodes.indexOf("(") + 1, traindestinationcodes.indexOf(")"));
                } else {
                    traindestinationcode = traindestinationcodes;
                }
                String trainjourneydate = journeydate.getText().toString();

                Intent gettrainbetweenstation = new Intent(TrainBetweenStationForm.this, TrainBetweenStationActivity.class);
                gettrainbetweenstation.putExtra("sourceCode", trainsourcecode);
                gettrainbetweenstation.putExtra("destinationCode", traindestinationcode);
                gettrainbetweenstation.putExtra("journeyDate", trainjourneydate);
                startActivity(gettrainbetweenstation);
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
                URL url = new URL("http://192.168.43.127:3000/nametocode"); //Api when server is on in laptop.
                //URL url = new URL("https://api.myjson.com/bins/163dj9");
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
