package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Enter_Symptoms extends AppCompatActivity {
    
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    Button Check_Results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_symptoms);

        cb1 = findViewById(R.id.checkbox_two);
        cb2 = findViewById(R.id.checkbox_three);
        cb3 = findViewById(R.id.checkbox_four);
        cb4 = findViewById(R.id.checkbox_five);
        cb5 = findViewById(R.id.checkbox_six);
        cb6 = findViewById(R.id.checkbox_eight);
        cb7 = findViewById(R.id.checkbox_nine);
        Check_Results = findViewById(R.id.check_Results);

        

            Check_Results.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked()) {
                        startActivity(new Intent(Enter_Symptoms.this, Book_Appointment.class));
                    } else if (cb3.isChecked() && cb4.isChecked() && cb5.isChecked()) {
                        startActivity(new Intent(Enter_Symptoms.this, Book_Appointment.class));
                    } else if (cb5.isChecked() && cb6.isChecked() && cb7.isChecked()) {
                        startActivity(new Intent(Enter_Symptoms.this, Book_Appointment.class));
                    } else if (cb1.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                        startActivity(new Intent(Enter_Symptoms.this, Book_Appointment.class));
                    } else if (cb1.isChecked() && cb5.isChecked() && cb6.isChecked()) {
                        startActivity(new Intent(Enter_Symptoms.this, Book_Appointment.class));
                    } else if (cb2.isChecked() && cb5.isChecked() && cb6.isChecked()) {
                        startActivity(new Intent(Enter_Symptoms.this, Book_Appointment.class));
                    } else if (cb2.isChecked() && cb1.isChecked() && cb7.isChecked()) {
                        startActivity(new Intent(Enter_Symptoms.this, Book_Appointment.class));
                    } else if (cb3.isChecked() && cb5.isChecked() && cb7.isChecked()) {
                        startActivity(new Intent(Enter_Symptoms.this, Book_Appointment.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "You should be ok. Please consult with your physician if symptoms worsen.", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Enter_Symptoms.this, Home.class));
                    }
                }
            });
    }
}









