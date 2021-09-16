package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCreate;
    Button BtnLogin;

    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentSignUP = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intentSignUP);

            }
        });
        BtnLogin = findViewById(R.id.BtnLogin);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Home.class));


            }
        });

    }
}
  /*
   public void signIn(View V)
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_main);
        dialog.setTitle("UserInfo");

// get the References of views
        final EditText userNameText=(EditText)dialog.findViewById(R.id.userNameText);
        final EditText passwordText=(EditText)dialog.findViewById(R.id.passwordText);

        Button BtnLogin=(Button)dialog.findViewById(R.id.BtnLogin);

// Set On ClickListener
        BtnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
// get The User name and Password
                String userName=userNameText.getText().toString();
                String password=passwordText.getText().toString();

// fetch the Password form database for respective user name
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

// check if the Stored password matches with Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(MainActivity.this, "Congrats: Login Successful", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    BtnLogin.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
// >>>> add check password later before submission!!!!!!
                            startActivity(new Intent(MainActivity.this, Home.class));



                        }
                    });
                }
                else
                {
                    Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
// Close The Database
        loginDataBaseAdapter.close();
    }
}


   */