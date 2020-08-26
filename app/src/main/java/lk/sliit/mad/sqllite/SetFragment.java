package lk.sliit.mad.sqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class SetFragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void setFragment(View view){
        Fragment fragment;
        if(view == findViewById(R.id.button1)){
            fragment =new Fragment1();
            FragmentManager f1 = getSupportFragmentManager();
            FragmentTransaction ft = f1.beginTransaction();
            ft.replace(R.id.fragment,fragment);
            ft.commit();
        }
        if(view == findViewById(R.id.button2)){
            fragment =new Fragment2();
            FragmentManager f1 = getSupportFragmentManager();
            FragmentTransaction ft = f1.beginTransaction();
            ft.replace(R.id.fragment,fragment);
            ft.commit();
        }
    }
}