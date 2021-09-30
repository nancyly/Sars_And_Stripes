package net.androidbootcamp.sars_and_stripes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    ImageButton btnLabs;
    ImageButton btnSymptoms;
    ImageButton btnBookAppointment;
    ImageButton btnLocations;
    ImageButton btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLabs = findViewById(R.id.btnLabs);
        btnLabs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Labs.class));

            }
        });
        btnSymptoms = findViewById(R.id.btnSymptoms);
        btnSymptoms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Symptoms.class));

            }
        });
        btnBookAppointment = findViewById(R.id.btnBookAppointment);
        btnBookAppointment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Book_Appointment.class));

            }
        });
        btnLocations = findViewById(R.id.btnLocations);
        btnLocations.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Locations.class));

            }
        });
        btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Profile.class));

            }
        });
    }
}