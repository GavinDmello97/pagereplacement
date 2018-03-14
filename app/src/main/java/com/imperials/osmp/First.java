package com.imperials.osmp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class First extends AppCompatActivity {
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        tv2 = (TextView)findViewById(R.id.tv2);
    }



    public void program(View v){

        Intent in = new Intent(First.this,WebView_fifo_program.class);
        startActivity(in);

    }


}
