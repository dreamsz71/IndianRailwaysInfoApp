package com.pushkarnayouth.mytraindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        setSingleEvent(gridLayout);

        setUpToolbar();
        // setToggleEvent(gridLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent navIntent = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        navIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(navIntent);

                        Toast.makeText(MainActivity.this, "Home Screen", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about:

                        navIntent = new Intent(getApplicationContext(), AboutActivity.class);
                        startActivity(navIntent);

                        Toast.makeText(MainActivity.this, "About Screen", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_irctc:
                        Toast.makeText(MainActivity.this, "Irctc Screen", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });

    }

    private void setToggleEvent(GridLayout gridLayout) {
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            final CardView cardView = (CardView) gridLayout.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //cardView.setCardBackgroundColor(Color.parseColor("#008080"));
                    } else {
                        //cardView.setCardBackgroundColor(Color.parseColor("#ff9e9e9e"));
                    }
                }
            });
        }
    }


    private void setSingleEvent(GridLayout gridLayout) {
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(MainActivity.this, "You Clicked At Index: "+ finalI, Toast.LENGTH_SHORT).show();
                    Intent intent = null;
                    if (finalI == 0) {
                        intent = new Intent(getApplicationContext(), TrainPnrForm.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        intent = new Intent(getApplicationContext(), TrainRouteForm.class);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        intent = new Intent(getApplicationContext(), TrainArrivalsForm.class);
                        startActivity(intent);
                    } else if (finalI == 3) {
                        intent = new Intent(getApplicationContext(), TrainCancelledForm.class);
                        startActivity(intent);
                    } else if (finalI == 4) {
                        intent = new Intent(getApplicationContext(), LiveTrainForm.class);
                        startActivity(intent);
                    } else if (finalI == 5) {
                        intent = new Intent(getApplicationContext(), TrainBetweenStationForm.class);
                        startActivity(intent);
                    } else if (finalI == 6) {
                        intent = new Intent(getApplicationContext(), TrainRescheduleForm.class);
                        startActivity(intent);
                    } else if (finalI == 7) {
                        intent = new Intent(getApplicationContext(), SeatAvailabilityActivity.class);
                        startActivity(intent);
                    } else if (finalI == 8) {
                        intent = new Intent(getApplicationContext(), FareForm.class);
                        startActivity(intent);
                    } else if (finalI == 9) {
                        intent = new Intent(getApplicationContext(), TicketBooking.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Welcome to Indian Rail Enquiry", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setUpToolbar() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}

