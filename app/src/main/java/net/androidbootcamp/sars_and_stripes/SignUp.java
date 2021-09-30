package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {
    // References to all the buttons on SIGNUP page
    Button btnAcctCreate;
    EditText textUserName, textPassword, textRePassword, textEmail, textFirstName, textLastName, textAddress, textPhone;
    // define the userAccount
    UserInfo userInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // point the referenced buttons to each field
        textUserName = findViewById(R.id.textUserName);
        textPassword = findViewById(R.id.textPassword);
        textRePassword = findViewById(R.id.textRePassword);
        textEmail = findViewById(R.id.textEmail);
        textFirstName = findViewById(R.id.textFirstName);    //new
        textLastName = findViewById(R.id.textLastName);  //new
        textAddress = findViewById(R.id.textAddress);    //new
        textPhone = findViewById(R.id.textPhone);    //new


        btnAcctCreate = findViewById(R.id.btnAcctCreate);

        // click listener implemented
        btnAcctCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=textUserName.getText().toString().toLowerCase();
                String password=textPassword.getText().toString();
                String confirmPassword=textRePassword.getText().toString();
                String eMail=textEmail.getText().toString().toLowerCase();
                String firstName=textFirstName.getText().toString(); //new
                String lastName=textLastName.getText().toString();  //new
                String address=textAddress.getText().toString();    //new
                String phoneNumber=textPhone.getText().toString();    //new

                // check if username field is vacant - NOT CASE SENSITIVE
                if(userName.equals("")) {
                    Toast.makeText(getApplicationContext(), "Username field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if initial password is vacant
                else if(password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Password field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                else if(!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                //CHECK FIRST NAME
                else if(firstName.equals("")) {
                    Toast.makeText(getApplicationContext(), "Firstname field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                //CHECK LAST NAME
                else if(lastName.equals("")) {
                    Toast.makeText(getApplicationContext(), "Lastname field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                //CHECK ADDRESS NUMBER
                else if(address.equals("")) {
                    Toast.makeText(getApplicationContext(), "Address field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                //CHECK PHONE NUMBER
                else if(phoneNumber.equals("")) {
                    Toast.makeText(getApplicationContext(), "Phone Number field vacant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if email field is vacant
                else if(eMail.equals("")) {
                    Toast.makeText(getApplicationContext(), "Email field vacant", Toast.LENGTH_LONG).show();
                    return;
                }

                // ============= need to go back and fix the checks below =======================
                // verify user email has @something.com - NOT CASE SENSITIVE - due to time i did basic check
                else if(!eMail.contains("@")) {
                    Toast.makeText(getApplicationContext(), "Email not valid", Toast.LENGTH_LONG).show();
                    return;
                }
                // =================================================================================

                // reference database to these users' value from SignUp page
                MyDBHandler myDBHandler = new MyDBHandler(SignUp.this);

                // ADD A TRY CATCH BELOW TO VERIFY IF USER EXISTS PRIOR TO CREATING
                try{
                    if(myDBHandler.doesUsernameExist(userName)){
                        Toast.makeText(getApplicationContext(), "Username taken", Toast.LENGTH_LONG).show();
                    }
                    else{
                        // Attempt to pass the new user values to a new UserInfo class
                        try {
                            userInfo = new UserInfo(-1, userName, password, firstName, lastName, address, phoneNumber, eMail);
                            Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                            Profile.setUserName(userName); //pass the username to the new profile display
                            startActivity(new Intent(SignUp.this, Home.class));     //take user to homeUI
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "User Account could not be created", Toast.LENGTH_LONG).show();
                            userInfo = new UserInfo(-1, "error-username", "error-password", "error-firstname", "error-lastname", "error-address", "error-phonenumber","error-email");
                        }
                        // call the database method addRow() and add new user
                        myDBHandler.addRow(userInfo);
                    }
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Username taken", Toast.LENGTH_LONG).show();
                }

            }
        }); //end of buttonAccountCreate-onClick
    } //end of onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyDBHandler myDBHandler = new MyDBHandler(SignUp.this);
        myDBHandler.close();
    }

}