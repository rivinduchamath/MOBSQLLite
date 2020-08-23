package lk.sliit.mad.sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import lk.sliit.mad.sqllite.database.DBHandler;

public class ProfileManagement extends AppCompatActivity {

    Button btnAdd, btnUpdateProfile;
    EditText rtDob, etUserName, etPassword;
    RadioButton male, female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        rtDob = findViewById(R.id.etUserName);
        etUserName = findViewById(R.id.etBirth);
        etPassword = findViewById(R.id.etPassword);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdateProfile = findViewById(R.id.btnUpdateProfile);
        female = findViewById(R.id.radioFemale);
        male = findViewById(R.id.radioMale);

        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(i);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (male.isChecked()) {
                    gender = "male";
                } else {
                    gender = "female";
                }
                DBHandler dbHelper = new DBHandler(getApplicationContext());
              long  newId =   dbHelper.addInfo(etUserName.getText().toString(), rtDob.getText().toString(),
                        etPassword.getText().toString(), gender);
                Toast.makeText(ProfileManagement.this, "User"+newId+"  Added User Id ", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(i);
            }
        });
    }
}