package org.androidtown.lab3_3;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button btn_frag1;
    public Button btn_frag2;
    public FirstFragment firstFragment;
    public SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }

    /*Get a widget from a xml file to use a ID*/
    public void init() {
        btn_frag1 = (Button) findViewById(R.id.btn_frag1);
        btn_frag2 = (Button) findViewById(R.id.btn_frag2);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

    }

    /*Button action*/
    public void setListener(){
        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change to first fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment,firstFragment).commit();
            }
        });

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change to second fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment,secondFragment).commit();
            }
        });
    }
}

