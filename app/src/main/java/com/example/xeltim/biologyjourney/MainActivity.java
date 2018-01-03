package com.example.xeltim.biologyjourney;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button button;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button2);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Settings();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isNetworkConnected();
                boolean Status = isNetworkConnected();
                if(Status == true)
                Start();
                else
                    Toast.makeText(MainActivity.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void Start(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    protected void Settings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

}
