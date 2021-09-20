package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SignUp extends AppCompatActivity {
    // References to all the buttons on SIGNUP page
    Button btnAcctCreate;
    EditText textUserName, textPassword, textRePassword, textEmail;
    LoginDataBaseAdapter loginDataBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // point the referenced buttons to each field
        textUserName = (EditText) findViewById(R.id.textUserName);
        textPassword = (EditText) findViewById(R.id.textPassword);
        textRePassword = (EditText) findViewById(R.id.textRePassword);
        textEmail = (EditText) findViewById(R.id.textEmail);
        btnAcctCreate = (Button) findViewById(R.id.btnAcctCreate);

        // click listener implemented
        btnAcctCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=textUserName.getText().toString().toLowerCase();
                String password=textPassword.getText().toString();
                String confirmPassword=textRePassword.getText().toString();
                String eMail=textEmail.getText().toString().toLowerCase();

        // use TRY CATCH instead for each section. go back to this later
        // check if username field is vacant - NOT CASE SENSITIVE
                if(userName.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Username field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
        // check if initial password is vacant
                else if(password.equals("")){
                    Toast.makeText(getApplicationContext(), "Password field vacant", Toast.LENGTH_LONG).show();
                    return;
                    //||confirmPassword.equals("")
                }
        // check if both password matches
                else if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
        // check if email field is vacant
                else if(eMail.equals("")){
                    Toast.makeText(getApplicationContext(), "Email field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
        // verify user email has @something.com - NOT CASE SENSITIVE
        // need to go back and fix this part

                else if(eMail.contains("@") == false){
                    Toast.makeText(getApplicationContext(), "Email not valid", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
        // Save the Data in Database
                    // Create a new instance of the userInfo class
                    UserInfo userInfo = new UserInfo(-1, userName, password, eMail);
                    //loginDataBaseAdapter.insertEntry(userName, password, eMail);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    // go to homeUI
                    setContentView(R.layout.activity_home);
                }
            }
        });
    } //end of onCreate

    @Override
    protected void onDestroy() {
    // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }

}



