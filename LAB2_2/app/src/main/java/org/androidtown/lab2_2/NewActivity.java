package org.androidtown.lab2_2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    /*handler method for WM_CREATE message */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        /*Get a widget from a xml file to use a ID*/
        textView=(TextView)findViewById(R.id.textView);
        goBtn=(Button)findViewById(R.id.goBtn);
        backBtn=(Button)findViewById(R.id.backBtn);

        final Intent passedIntent=getIntent();
        final String passedUrl=(passedIntent.getStringExtra("Url")); //Get a String from Intent
        textView.setText(passedUrl); //Set url at TextView widget

        goBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //No text on TextView
                if(!passedUrl.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + passedUrl));
                    startActivity(intent);
                }

                else{
                    /*Show a message*/
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요.",Toast.LENGTH_LONG).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                /*Show a message*/
                Toast.makeText(getApplicationContext(), "뒤로가기버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}

