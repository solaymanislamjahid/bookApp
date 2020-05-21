package com.zahid.himurhatekokhektihandsanitizer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn=findViewById(R.id.rfs);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNetworkConnectionAvailable();
            }
        });
    }




    public void checkNetworkConnection(){

        Toast toast=Toast.makeText(Main2Activity.this,"Try again.",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,200);
        toast.show();

    }

    public boolean isNetworkConnectionAvailable(){
        ConnectivityManager cm =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();
        if(isConnected) {
            Log.d("Network", "Connected");
            finish();

            Intent i=new Intent(Main2Activity.this,MainActivity.class);
            startActivity(i);
            return true;
        }
        else{
            checkNetworkConnection();
            Log.d("Network","Not Connected");
            return false;
        }
    }

    //back on press..
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }

//back on press end..
}
