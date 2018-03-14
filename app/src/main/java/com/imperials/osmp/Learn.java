package com.imperials.osmp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Learn extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        bt1 = (Button)findViewById(R.id.button);
        bt2 = (Button)findViewById(R.id.button3);
        bt3 = (Button)findViewById(R.id.button5);
        bt4 = (Button)findViewById(R.id.button7);

    }

    public void fifo(View v) {

        Intent in = new Intent(Learn.this,First.class);
        startActivity(in);


    }
    public void lru(View v) {

        Intent in = new Intent(Learn.this,Resently.class);
        startActivity(in);


    }
    public void lfu(View v) {

        Intent in = new Intent(Learn.this,Frequently.class);
        startActivity(in);


    }
    public void optimal(View v) {

        Intent in = new Intent(Learn.this,OptimalPR.class);
        startActivity(in);


    }
}
