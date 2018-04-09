package org.androidtown.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent=getIntent();
        if(passedIntent!=null) {

            /*Get a String from Intent*/
            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge");

            /*Show a message*/
            Toast.makeText(getApplicationContext(), "Student info : " + loginName + ", " + loginAge,Toast.LENGTH_LONG).show();
        }

        Button button0 = (Button) findViewById(R.id.button2);
        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish(); //Finish this activity when click a button
            }
        });
    }
}
