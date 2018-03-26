package org.androidtown.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    /*public variable for each widget*/
    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    /*handler method for WM_CREATE message */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); //call init method
    }

    /*This is a method to initialize objects to be referenced*/
    public void init(){
        edit_name = (EditText)findViewById(R.id.editText);
        btn_clear= (Button)findViewById(R.id.button1);
        btn_print = (Button)findViewById(R.id.button2);
        view_print = (TextView)findViewById(R.id.contents);
    }

    /*This is a method for clear all text in "contents" TextView widget*/
    public void clearClicked(View v){
        edit_name.setText("");
        view_print.setText("contents");
    }

    /*This is a method for set all text in "editText" EditText widget*/
    public void printClicked(View v){
        String text="";
        text=edit_name.getText().toString();
        view_print.setText(text);
    }
}

