package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView btnDBS, btnOCBC, btnUOB;
    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.textViewDBS);
        btnOCBC = findViewById(R.id.textViewOCBC);
        btnUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

    }

    // For the hamburger icon, which contains language options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // For Context Menu, which includes the website and contact details of the bank
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if(v.getId() == R.id.textViewDBS) {
            mode = 1;
        } else if(v.getId() == R.id.textViewOCBC) {
            mode = 2;
        } else if(v.getId() == R.id.textViewUOB) {
            mode = 3;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(mode == 1) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentLink);

                return true; //menu item successfully handled
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 1111111));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        } else if(mode == 2) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentLink);

                return true; //menu item successfully handled
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 3633333));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        } else if(mode == 3) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentLink);

                return true; //menu item successfully handled
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 2222121));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

}
