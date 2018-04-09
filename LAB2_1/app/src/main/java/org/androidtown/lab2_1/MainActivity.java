package org.androidtown.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button1;

    @Override
    /*handler method for WM_CREATE message */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Get a widget from a xml file to use a ID*/
        Name = (EditText) findViewById(R.id.editText1);
        Age = (EditText)findViewById(R.id.editText2);
        button1 = (Button)findViewById(R.id.button1);

        //This method is started when button clicked
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            /*handler method for event of button click */
            public void onClick(View view) {

                /*get a String from a xml*/
                String UserName = Name.getText().toString();
                String UserAge=Age.getText().toString();

                /*Call NewActivity.class and deliver information for name and age*/
                Intent intent = new Intent (getApplicationContext(), NewActivity.class);
                intent.putExtra("loginName", UserName);
                intent.putExtra("loginAge", UserAge);
                startActivity(intent);
            }
        });
    }
}

