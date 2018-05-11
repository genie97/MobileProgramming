package org.androidtown.lab4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = new MyView(this); //Declares a MyView object.
        setContentView(myView); // Inflate a MyView object
    }
}
