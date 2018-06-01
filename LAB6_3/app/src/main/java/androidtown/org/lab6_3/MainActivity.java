package androidtown.org.lab6_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name, sn;
    private Button addBtn, deleteBtn;
    private ListView studentList;
    private String studentInfo[];

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    String nameStr, snStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*initialize*/
        name = (EditText) findViewById(R.id.name);
        sn = (EditText) findViewById(R.id.sn);
        studentList = (ListView) findViewById(R.id.userList);
        addBtn = (Button) findViewById(R.id.addBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);

        /*add data*/
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameStr = name.getText().toString();
                snStr = sn.getText().toString();

                if (!(nameStr.equals(""))&&!(snStr.equals(""))) {
                    insert(nameStr, snStr);
                    invalidate();
                    name.getText().clear();
                    sn.getText().clear();
                } else {
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*delete data*/
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameStr = name.getText().toString();
                snStr = sn.getText().toString();

                if (!(nameStr.equals(""))) {
                    delete(nameStr);
                    invalidate();
                    name.getText().clear();
                    sn.getText().clear();
                } else {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /*insert name and student number into database*/
    public void insert(String name, String sn) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("sn", sn);
        db.insert("student", null, values);
        //Toast.makeText(getApplicationContext(), "정상적으로 추가 되었습니다.", Toast.LENGTH_SHORT).show();
    }

    /*delete from database*/
    public void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
        //Toast.makeText(getApplicationContext(), "정상적으로 삭제 되었습니다.", Toast.LENGTH_SHORT).show();
    }

    /*search all data*/
    public void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);

        studentInfo = new String[c.getCount()];
        int count = 0;
        while (c.moveToNext()) {
            studentInfo[count] = c.getString(c.getColumnIndex("name")) + " " + c.getString(c.getColumnIndex("sn"));
            count++;
        }
        c.close();
    }

    /*update ad show data in list view*/
    private void invalidate() {
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentInfo);
        studentList.setAdapter(adapter);
    }

    /*SQLite class*/
    class MySQLiteOpenHelper extends SQLiteOpenHelper {
        public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        /*Query: create database*/
        public void onCreate(SQLiteDatabase db) {
            String sql = "create table student (" + "name text, " + "sn text);";
            db.execSQL(sql);
        }

        /*Query: drop table from database*/
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "drop table if exists student";
            db.execSQL(sql);
            onCreate(db);
        }
    }
}
