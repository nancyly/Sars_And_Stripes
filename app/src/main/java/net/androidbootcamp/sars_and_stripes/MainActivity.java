package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //references to all fields in the sign-in page
    Button btnCreate;
    Button BtnLogin;
    EditText userNameText;
    EditText passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameText = (EditText) findViewById(R.id.userNameText);
        passwordText = (EditText) findViewById(R.id.passwordText);

        // CREATE ACCOUNT
        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentSignUP = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intentSignUP);

            }
        }); //end of sign up button

        // LOG-IN WITH EXISTING ACCOUNT
        BtnLogin = findViewById(R.id.BtnLogin);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userName=userNameText.getText().toString().toLowerCase();
                String password=passwordText.getText().toString();
                MyDBHandler myDBHandler = new MyDBHandler(MainActivity.this);

                // TRY CATCH to verify username & password isn't blank and is valid
                try {
                    // Calls the database function to see if user is in Users' database
                    if(myDBHandler.doesUserExist(userName, password)){
                        Toast.makeText(getApplicationContext(), "Login Successful ", Toast.LENGTH_LONG).show();
                        Profile.setUserName(userName); //pass the username to the new profile display
                        startActivity(new Intent(MainActivity.this, Home.class));
                    }
                    else{
                        // lazy way to check if user has fields blank
                        Toast.makeText(getApplicationContext(), "Login Failed - Check Username & Password", Toast.LENGTH_LONG).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Login Failed - Check Username & Password", Toast.LENGTH_LONG).show();
                }
            }
        }); //end of login button

    }   //end of onCreate

    // ON DESTROY
    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyDBHandler myDBHandler = new MyDBHandler(MainActivity.this);
        myDBHandler.close();
    }
}