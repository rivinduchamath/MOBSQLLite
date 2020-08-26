package lk.sliit.mad.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String val = getIntent().getStringExtra("Value1");
        textView = findViewById(R.id.tvgetVal);
        textView.setText(val);

    }
}