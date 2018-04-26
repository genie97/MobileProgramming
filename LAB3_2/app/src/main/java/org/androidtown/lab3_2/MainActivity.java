package org.androidtown.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText name;
    RadioGroup Sex;
    RadioButton Male;
    RadioButton Female;
    CheckBox SMS;
    CheckBox Mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Get a widget from a xml file to use a ID*/
        name = (EditText) findViewById(R.id.name);
        Sex = (RadioGroup) findViewById(R.id.RadioGroup_gender);
        Male = (RadioButton) findViewById(R.id.male);
        Female = (RadioButton) findViewById(R.id.female);
        SMS = (CheckBox) findViewById(R.id.msg1);
        Mail = (CheckBox) findViewById(R.id.msg2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_name = name.getText().toString();
                String str_sex = "";
                String str_msg1 = "";
                String str_msg2 = "";

                /*Check if the option is "male" or not "female"*/
                if (Sex.getCheckedRadioButtonId() == R.id.male) {
                    str_sex = Male.getText().toString();
                }
                if (Sex.getCheckedRadioButtonId() == R.id.female) {
                    str_sex = Female.getText().toString();
                }

                /*Check the checkbox is selected*/
                if (SMS.isChecked()) {
                    str_msg1 = (String) SMS.getText();
                }

                if (Mail.isChecked()) {
                    str_msg2 = (String) Mail.getText();
                }

                /*Call RegisterActivity.class and deliver information for name and sex, SMS, Mail*/
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                intent.putExtra("name", str_name);
                intent.putExtra("sex", str_sex);
                intent.putExtra("SMS", str_msg1);
                intent.putExtra("Mail", str_msg2);
                startActivity(intent);
                finish();
            }
        });
    }
}
