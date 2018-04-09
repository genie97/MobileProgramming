package org.androidtown.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    /*handler method for WM_CREATE message */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Get a widget from a xml file to use a ID*/
        Url=(EditText)findViewById(R.id.editText);
        nextBtn=(Button)findViewById(R.id.nextBtn);

        //This method is started when button clicked
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myUrl=Url.getText().toString(); // get a String from a xml

                /*Call NewActivity.class and deliver information for url*/
                Intent intent= new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("Url",myUrl);
                startActivity(intent);
            }
        });
    }
}

