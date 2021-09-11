package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button btnLabs;
    Button btnSymptoms;
    Button btnBookAppointment;
    Button btnLocations;
    Button btnProfile;
    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLabs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Labs.class));


            }
        });
        btnSymptoms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Symptoms.class));


            }
        });
        btnBookAppointment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Book_Appointment.class));


            }
        });
        btnLocations.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Locations.class));


            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Profile.class));


            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Settings.class));


            }
        });

    }
}