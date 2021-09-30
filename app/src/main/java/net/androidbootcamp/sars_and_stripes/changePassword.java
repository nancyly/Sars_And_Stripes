package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class changePassword extends AppCompatActivity {
    //reference editTexts fields and changePasswordButton
    EditText textPassword2, textRePassword2;
    Button buttonChangePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        textPassword2 = findViewById(R.id.textPassword2);
        textRePassword2 = findViewById(R.id.textRePassword2);

        //REFERENCE MYDBHANDLER CLASS
        MyDBHandler myDBHandler = new MyDBHandler(changePassword.this);

        //verify password and re-entered password is valid when user presses change password button
        buttonChangePassword = findViewById(R.id.buttonChangePassword);
        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //verify the password isn't blank and that both password and confirm password matches
                try{
                    String password=textPassword2.getText().toString();
                    String passwordConfirm=textRePassword2.getText().toString();

                    //password cannot be blank
                    if(password.equals("")){
                        Toast.makeText(getApplicationContext(), "Password field is blank!", Toast.LENGTH_LONG).show();
                    }
                    //re-typed password cannot be blank
                    else if(passwordConfirm.equals("")){
                        Toast.makeText(getApplicationContext(), "Please confirm password!", Toast.LENGTH_LONG).show();
                    }
                    //password and re-typed password must match
                    else if(!passwordConfirm.equals(password)){
                        Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_LONG).show();
                    }
                    //IF ALL CHECKS ABOVE WORKS WE CALL THE UPDATE METHOD FROM MYDBHANDLER
                    else {
                        myDBHandler.updatePassword(Profile.mUserName, password);
                        Toast.makeText(getApplicationContext(), "Your password has been changed", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(changePassword.this, Home.class));
                    }
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error - Password has not been changed", Toast.LENGTH_LONG).show();
                }
            }
        }); //END OF CHANGE PASSWORD ONCLICK

    }

}