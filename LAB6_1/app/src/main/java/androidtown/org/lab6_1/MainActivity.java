package androidtown.org.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txtData;
    private Button btnWriteSDFile;
    private Button btnReadSDFile;
    private Button btnClearScreen;
    private Button btnFinish;
    private String mySdPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*initialize*/
        btnWriteSDFile = (Button) findViewById(R.id.btnWriteSDFile);
        btnReadSDFile = (Button) findViewById(R.id.btnReadSDFile);
        btnClearScreen = (Button) findViewById(R.id.btnClearScreen);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        txtData = (EditText) findViewById(R.id.txtData);

        /*Write & get a proper path*/
        mySdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File directory = new File (mySdPath+"/");
        directory.mkdirs();

        txtData.setHint("Enter some lines of data here...");

        /*Button for writing*/
        btnWriteSDFile.setOnClickListener(new View.OnClickListener() {
            /*file output stream*/
            @Override
            public void onClick(View v) {
                try {
                    File myFile = new File(directory, "mysdfile.txt");
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(new FileOutputStream(myFile));
                    myOutWriter.append(txtData.getText());
                    myOutWriter.close();
                    Toast.makeText(getApplicationContext(), "Done writing SD 'mysdfile.txt'", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*Button for reading*/
        btnReadSDFile.setOnClickListener(new View.OnClickListener() {
            @Override
            /*file input stream*/
            public void onClick(View v) {
                try {
                    BufferedReader myReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(directory,"mysdfile.txt"))));
                    String aDataRow = "";
                    String aBuffer = "";
                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";
                    }
                    txtData.setText(aBuffer);
                    myReader.close();
                    Toast.makeText(getApplicationContext(),"Done reading SD 'mysdfile.txt'", Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*Button for clearing screen*/
        btnClearScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtData.setText("");
            }
        });

        /*Button for finishing*/
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
