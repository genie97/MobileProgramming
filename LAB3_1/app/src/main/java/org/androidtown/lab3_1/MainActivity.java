package org.androidtown.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.androidtown.lab3_1.R;

public class MainActivity extends AppCompatActivity {
    Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Get a widget from a xml file to use a ID*/
        mBtn=(Button)findViewById(R.id.mBtn);
        /*Register the View to which the context menu should be associated*/
        registerForContextMenu(mBtn); //
    }

    /****************************************************
    * When the registered view receives a long-click event
    * the system calls this method
    * ***************************************************/
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("Button Menu"); //set menu title
        menu.add(0,1,1,"Red"); //add menu
        menu.add(0,2,2,"Green"); //add menu
        menu.add(0,3,3,"Blue"); //add menu
    }

    /****************************************************
     * When the user selects a menu item,
     * the system calls this method
     * ***************************************************/
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                mBtn.setTextColor(Color.RED); // change color to red
                return true;
            case 2:
                mBtn.setTextColor(Color.GREEN); //change color to green
                return true;
            case 3:
                mBtn.setTextColor(Color.BLUE); //change color to blue
                return true;
        }
        return true;
    }
}
