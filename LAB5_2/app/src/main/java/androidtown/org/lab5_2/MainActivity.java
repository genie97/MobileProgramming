package androidtown.org.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidtown.org.lab5_2.R;

public class MainActivity extends AppCompatActivity {
    Button calBtn;
    TextView numberText;
    TextView resultText;
    EditText editText;

    String initValue = "";
    String numberStr = "";
    int initCount = 0;
    int result = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*initialize widget*/
        calBtn = (Button) findViewById(R.id.calBtn);
        resultText = (TextView) findViewById(R.id.resultText);
        numberText = (TextView) findViewById(R.id.numberText);
        editText = (EditText) findViewById(R.id.editText);

        /*button event*/
        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValue = editText.getText().toString();
                initCount = Integer.parseInt(initValue);
                new CalculateTask().execute();
            }
        });
    }

    /*calculate task*/
    class CalculateTask extends AsyncTask<Void, Integer, Void> {

        /*before execution setting*/
        @Override
        protected void onPreExecute() {
            numberText.setText("");
            resultText.setText("= ?");
        }

        /*calculate factorial*/
        protected Void doInBackground(Void... params) {
            for (int i = initCount; i > 0; i--) {
                try {
                    Thread.sleep(500);
                    publishProgress(i);
                    result = result * i;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /*set progress in TextView*/
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            numberText.append(values[0].toString() + " ");
        }

        /*set result in TextView*/
        protected void onPostExecute(Void aVoid) {
            resultText.setText("= " + Integer.toString(result));
        }
    }
}
