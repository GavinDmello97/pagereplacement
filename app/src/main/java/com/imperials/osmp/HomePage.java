package com.imperials.osmp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {


    ImageButton ib1,ib2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ib1= (ImageButton)findViewById(R.id.imageButton5);
        ib2= (ImageButton)findViewById(R.id.imageButton2);
    }

    public void learn(View v){

        Intent in = new Intent(HomePage.this,Learn.class);
        startActivity(in);




    }


    public void calculate(View v){


        Intent in = new Intent(HomePage.this,MainPage.class);
        startActivity(in);



    }
}
