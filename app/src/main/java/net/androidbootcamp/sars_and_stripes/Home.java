package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    ImageButton btnLabs;
    ImageButton btnSymptoms;
    ImageButton btnBookAppointment;
    ImageButton btnLocations;
    ImageButton btnProfile;
    ImageButton btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLabs = (ImageButton) findViewById(R.id.btnLabs);
        btnLabs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Labs.class));


            }
        });
        btnSymptoms = (ImageButton) findViewById(R.id.btnSymptoms);
        btnSymptoms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Symptoms.class));


            }
        });
        btnBookAppointment = (ImageButton) findViewById(R.id.btnBookAppointment);
        btnBookAppointment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Book_Appointment.class));


            }
        });
        btnLocations = (ImageButton) findViewById(R.id.btnLocations);
        btnLocations.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Locations.class));


            }
        });
        btnProfile = (ImageButton) findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Profile.class));


            }
        });
        btnSettings = (ImageButton) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Settings.class));


            }
        });

    }
}