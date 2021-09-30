package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    //VARIABLES
    TextView userNameProfile, firstNameProfile, lastNameProfile, emailProfile, phoneProfile, addressProfile;
    Button buttonChangePassword, buttonDelete;
    public static String mUserName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //REFERENCE ALL TEXTVIEWS ON THE PAGE THAT WILL BE UPDATED TO DISPLAY USER PROFILE INFO
        MyDBHandler myDBHandler = new MyDBHandler(Profile.this);
        userNameProfile = findViewById(R.id.userNameProfile);
        firstNameProfile = findViewById(R.id.firstNameProfile);
        lastNameProfile = findViewById(R.id.lastNameProfile);
        addressProfile = findViewById(R.id.addressProfile);
        phoneProfile = findViewById(R.id.phoneProfile);
        emailProfile = findViewById(R.id.emailProfile);


        //USING A TRY CATCH HERE TO VERIFY THE DISPLAY DATA UPDATES WITHOUT BREAKING THE APP
        try{
            userNameProfile.setText(mUserName);
            firstNameProfile.setText(myDBHandler.getFName(mUserName));
            lastNameProfile.setText(myDBHandler.getLName(mUserName));
            addressProfile.setText(myDBHandler.getAddress(mUserName));
            phoneProfile.setText(myDBHandler.getPhone(mUserName));
            emailProfile.setText(myDBHandler.getEmail(mUserName));
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "no results found", Toast.LENGTH_LONG).show();
        }

        //CREATE ON CLICK FOR CHANGE PASSWORD BUTTON
        buttonChangePassword = findViewById(R.id.buttonChangePassword);
        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //need to create the change password page
                startActivity(new Intent(Profile.this, changePassword.class));    //take user to sign-in page to re-create new account
            }
        }); //END OF CHANGE PASSWORD ONCLICK

        // --------------- DELETE PROFILE ---------------------------------------------------
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //POP-UP WITH DELETE PROFILE CONFIRMATION BOX
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);

                builder.setTitle("Confirm Account Deletion");
                builder.setMessage("Are you sure?");

                //IF USER SAYS 'YES' -- CLOSE THE DIALOGUE AND DELETE PROFILE FROM DATABASE
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog & delete profile
                        dialog.dismiss();   //close the dialogue box
                        myDBHandler.deleteProfile(mUserName);   //call query method to delete the user account
                        startActivity(new Intent(Profile.this, MainActivity.class));    //take user to sign-in page to re-create new account
                        Toast.makeText(getApplicationContext(), "Your account was successfully deleted", Toast.LENGTH_LONG).show(); //toast message notifying user account successfully deleted
                    }
                });
                //IF USER SAYS 'NO' -- DO NOTHING
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        }); //END OF DELETE BUTTON ONCLICK


    }//END ONCREATE

    // ---------------------- GET USERNAME & SET USERNAME --------------
    public String getUserName() {
        return mUserName;
    }

    public static void setUserName(String userName) {
        mUserName = userName;
    }

}//END PROFILE CLASS