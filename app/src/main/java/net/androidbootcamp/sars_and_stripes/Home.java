package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD

public class Home extends AppCompatActivity {
    Button btnLabs;
    Button btnSymptoms;
    Button btnBookAppointment;
    Button btnLocations;
    Button btnProfile;
    Button btnSettings;
=======
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    ImageButton btnLabs;
    ImageButton btnSymptoms;
    ImageButton btnBookAppointment;
    ImageButton btnLocations;
    ImageButton btnProfile;
    ImageButton btnSettings;
>>>>>>> 73afcc1bb4dfcb81ec2ae8c6c46fedbbcac92dc8

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
<<<<<<< HEAD
=======

        btnLabs = (ImageButton) findViewById(R.id.btnLabs);
>>>>>>> 73afcc1bb4dfcb81ec2ae8c6c46fedbbcac92dc8
        btnLabs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Labs.class));


            }
        });
<<<<<<< HEAD
=======
        btnSymptoms = (ImageButton) findViewById(R.id.btnSymptoms);
>>>>>>> 73afcc1bb4dfcb81ec2ae8c6c46fedbbcac92dc8
        btnSymptoms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Symptoms.class));


            }
        });
<<<<<<< HEAD
=======
        btnBookAppointment = (ImageButton) findViewById(R.id.btnBookAppointment);
>>>>>>> 73afcc1bb4dfcb81ec2ae8c6c46fedbbcac92dc8
        btnBookAppointment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Book_Appointment.class));


            }
        });
<<<<<<< HEAD
=======
        btnLocations = (ImageButton) findViewById(R.id.btnLocations);
>>>>>>> 73afcc1bb4dfcb81ec2ae8c6c46fedbbcac92dc8
        btnLocations.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Locations.class));


            }
        });
<<<<<<< HEAD
=======
        btnProfile = (ImageButton) findViewById(R.id.btnProfile);
>>>>>>> 73afcc1bb4dfcb81ec2ae8c6c46fedbbcac92dc8
        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Profile.class));


            }
        });
<<<<<<< HEAD
=======
        btnSettings = (ImageButton) findViewById(R.id.btnSettings);
>>>>>>> 73afcc1bb4dfcb81ec2ae8c6c46fedbbcac92dc8
        btnSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Settings.class));


            }
        });

    }
}