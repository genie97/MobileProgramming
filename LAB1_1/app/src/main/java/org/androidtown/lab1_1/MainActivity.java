package org.androidtown.lab1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    int imageIndex=0;

    @Override
    /*handler method for WM_CREATE message */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView); //Refer to the first image view object
        imageView2=findViewById(R.id.imageView2); //Refer to the changed image view object
    }

    /*handler method for event of button click */
    public void onButton1Clicked(View v){

        changeImage(); //call changeImage method

    }

    /*Method about changing image */
    public void changeImage(){
        if(imageIndex==0){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex=1;
        }
        else if(imageIndex==1){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex=0;
        }
    }
}
