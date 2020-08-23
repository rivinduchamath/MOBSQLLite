package lk.sliit.mad.sqllite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import lk.sliit.mad.sqllite.database.DBHandler;

public class EditProfile extends AppCompatActivity {

    Button btnEdit, btnDelete, btnSearch;
    EditText rtDob, etUserName, etPassword, etSearch;
    RadioButton male, female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnSearch = findViewById(R.id.btnSearch);
        etSearch = findViewById(R.id.etSearch);

        rtDob = findViewById(R.id.etDOB);
        etUserName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPasswordEdit);

        female = findViewById(R.id.radioMaleEdit);
        male = findViewById(R.id.radioFemaleEdit);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHelper = new DBHandler(getApplicationContext());
                List user = dbHelper.getInfo(etUserName.getText().toString());

                if (user == null) {
                    Toast.makeText(EditProfile.this, "No Such User", Toast.LENGTH_SHORT).show();
                    etUserName.setText(null);
                }else {

                }
            }
        });
    }
}