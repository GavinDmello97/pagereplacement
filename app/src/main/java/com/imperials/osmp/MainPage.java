package com.imperials.osmp;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MainPage extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4, tv5;
    EditText ed1, ed2, ed3;
    Button btn;

    String str1,str2,str3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        tv1 = (TextView) findViewById(R.id.name);
        tv2 = (TextView) findViewById(R.id.tvframesize);
        tv3 = (TextView) findViewById(R.id.tvpagesize);
        tv4 = (TextView) findViewById(R.id.tventerpages);
        tv5 = (TextView) findViewById(R.id.reference);
        ed1 = (EditText) findViewById(R.id.etenterframesize);
        ed2 = (EditText) findViewById(R.id.etenterpagesize);
        ed3 = (EditText) findViewById(R.id.etenterpages);
        ed3.setFilters(new InputFilter[] {
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start,
                                               int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if(cs.equals(" ")){ // for backspace
                            return cs;
                        }
                        if(cs.toString().matches("[0-9]+")){
                            return cs;
                        }
                        return "";
                    }
                }
        });
        btn = (Button) findViewById(R.id.calculate);



    }







        public void move(View v) {



            str1 = ed1.getText().toString();
            str2 = ed2.getText().toString();
            str3 = ed3.getText().toString();


            Intent i = new Intent(MainPage.this,MainActivity.class);
            Bundle b = new Bundle();

            b.putString("keyframesize",str1);
            b.putString("keypagesize",str2);
            b.putString("keypages",str3);

            i.putExtras(b);

            startActivity(i);





        }


        /*if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || (str1.isEmpty() && str2.isEmpty()) || (str1.isEmpty() && str3.isEmpty()) || (str2.isEmpty() && str3.isEmpty()) ||(str2.isEmpty() && str3.isEmpty() && str3.isEmpty()))
        {

            Toast.makeText(MainPage.this,"Something is missing.\nCheck!!",Toast.LENGTH_SHORT).show();


        }

        else {
            if (val1 == cal1) {

                    Intent in = new Intent(MainPage.this, MainActivity.class);

                    startActivity(in);

            }
            else
            {
                Toast.makeText(MainPage.this,"Page no and Pages dont match!",Toast.LENGTH_SHORT).show();

            }
        }*/

        /*if(val1 == cal1)
        {
            if (!str1.isEmpty()) {
                Intent in = new Intent(MainPage.this, MainActivity.class);
                startActivity(in);
            }
            else
            {
                Toast.makeText(MainPage.this,"Enter the frame size!",Toast.LENGTH_SHORT).show();
            }
        }


        else if(val1 != cal1){

            Toast.makeText(MainPage.this,"Err",Toast.LENGTH_SHORT).show();

        }
      else if(ed1.getText().toString().isEmpty())
        {
            Toast.makeText(MainPage.this,"Enter the frame size!",Toast.LENGTH_SHORT).show();

        }
        else if(ed2.getText().toString().isEmpty())
        {
            Toast.makeText(MainPage.this,"Enter the number of pages!",Toast.LENGTH_SHORT).show();

        }
        else if(ed3.getText().toString().isEmpty())
        {
            Toast.makeText(MainPage.this,"Enter the pages!",Toast.LENGTH_SHORT).show();

        }
       else if(cal2 == 0)
        {

          Toast.makeText(MainPage.this,"Recheck Your no. of pages.Extra space added!",Toast.LENGTH_LONG).show();

       }
        else
        {


            Toast.makeText(MainPage.this,"No. of pages DONOT MATCH the entered page size!!!",Toast.LENGTH_SHORT).show();

        }*/



    public static int countWords(String str3)
    {
        int count = 0;
        for (int i=0;i<=str3.length()-1;i++)
        {
            if (str3.charAt(i) == ' ' && str3.charAt(i+1)!=' ')
            {
                count++;
            }
        }
        return count;
    }


    public static int checkspaces(String str) {
       int check = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) == ' ')
                check = 0;
            else
                check= 1;

        }
        return check ;
    }






}