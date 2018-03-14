package com.imperials.osmp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Gavin Dmello on 04/09/2017.
 */

public class Optimal  extends Fragment {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    String disp = "Entered Values:";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fifo, container, false);
        tv1 = (TextView)rootView.findViewById(R.id.etenterframesize);
        tv2 = (TextView)rootView.findViewById(R.id.tvframesize);
        tv3 = (TextView)rootView.findViewById(R.id.etenterpagesize);
        tv4 = (TextView)rootView.findViewById(R.id.tvpagesize);
        tv5 = (TextView)rootView.findViewById(R.id.entPages);
        tv6 = (TextView)rootView.findViewById(R.id.tventerpages);
        tv7 = (TextView)rootView.findViewById(R.id.textView1);
        tv8 = (TextView)rootView.findViewById(R.id.textView2);

        SharedPreferences settings = getActivity().getSharedPreferences("OSMP_Settings", MODE_PRIVATE);

        String value1 = settings.getString("key1", "");
        String value2 = settings.getString("key2", "");
        String value3 = settings.getString("key3", "");
        Log.d(TAG, value1);
        Log.d(TAG, value2);
        Log.d(TAG, value3);



        tv2.setText(value1);
        tv4.setText(value2);
        tv6.setText(value3);


/*
        String[] splitStr = value3.split("\\s+");
        for(int i=0;i<=countWords(value3);i++) {
            disp = disp + "\n" + splitStr[i].toString();
        }

        tv7.setText(disp);


*/





        return rootView;





    }

    public static int countWords(String value3)
    {
        int count = 0;
        for (int i=0;i<=value3.length()-1;i++)
        {
            if (value3.charAt(i) == ' ' && value3.charAt(i+1)!=' ')
            {
                count++;
            }
        }
        return count;
    }






}
