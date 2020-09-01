package lk.sliit.mad.sqllite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.btnTestAdd);
        text = findViewById(R.id.etgetVal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = text.getText().toString();
                sendVal(val);
            }
        });
    }

    private void sendVal(String val) {

//        Explicit Intent

//        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
//        intent.putExtra("Value1", val);
//        startActivity(intent);

//        Implicit Intent

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(""));


    }
}