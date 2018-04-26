package org.androidtown.lab3_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.O;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /*Get a Intent*/
        Intent intent = getIntent();

        /*Get a String from Intent*/
        String str_name= intent.getStringExtra("name");
        String str_sex= intent.getStringExtra("sex");
        String str_msg1= intent.getStringExtra("SMS");
        String str_msg2= intent.getStringExtra("Mail");

        /*Get a widget from a xml file to use a ID*/
        TextView nameInfo=(TextView)findViewById(R.id.name2);
        TextView genderInfo=(TextView)findViewById(R.id.gender2);
        TextView msgInfo=(TextView)findViewById(R.id.msg2);

        /*Append text*/
        nameInfo.append(": " + str_name);
        genderInfo.append(": " + str_sex);
        msgInfo.append(": " + str_msg1 + " " + str_msg2);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /*Call MainActivity.class*/
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}
