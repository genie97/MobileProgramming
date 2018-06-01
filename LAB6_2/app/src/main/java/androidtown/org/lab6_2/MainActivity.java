package androidtown.org.lab6_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText sn, name;
    private Button readBtn, saveBtn, clearBtn;
    String userSN,userName;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*initialize*/
        sn = (EditText)findViewById(R.id.sn);
        name = (EditText)findViewById(R.id.name);
        readBtn = (Button)findViewById(R.id.readBtn);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        clearBtn = (Button)findViewById(R.id.clearBtn);

        /*To be stored in a file*/
        sh_Pref = getSharedPreferences("UserPref", Context.MODE_PRIVATE);
        editor = sh_Pref.edit();

        /*read data*/
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sn.setText(sh_Pref.getString("sn",""));
                name.setText(sh_Pref.getString("name",""));
                //Toast.makeText(getApplicationContext(),"불러오기 성공했습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        /*store data*/
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Editor*/
                editor.putString("sn",sn.getText().toString());
                editor.putString("name",name.getText().toString());
                //Toast.makeText(getApplicationContext(),"저장하기 성공했습니다.",Toast.LENGTH_SHORT).show();
                editor.commit();
            }
        });

        /*initial data*/
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sn.setText("");
                name.setText("");
                //Toast.makeText(getApplicationContext(),"초기화 성공했습니다.",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
