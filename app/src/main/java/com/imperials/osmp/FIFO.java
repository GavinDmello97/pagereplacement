package com.imperials.osmp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
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

public class FIFO extends Fragment  {
TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    String disp = "Entered Values:";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_fifo, container, false);
        tv1 = (TextView) rootView.findViewById(R.id.etenterframesize);
        tv2 = (TextView) rootView.findViewById(R.id.tvframesize);
        tv3 = (TextView) rootView.findViewById(R.id.etenterpagesize);
        tv4 = (TextView) rootView.findViewById(R.id.tvpagesize);
        tv5 = (TextView) rootView.findViewById(R.id.entPages);
        tv6 = (TextView) rootView.findViewById(R.id.tventerpages);
        tv7 = (TextView) rootView.findViewById(R.id.textView1);
        tv8 = (TextView) rootView.findViewById(R.id.textView2);

      //  tv8 = (TextView) rootView.findViewById(R.id.textView2);

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

       // tv7.setText(cal);






       /* String[] splitStr = value3.split("\\s+");
        for(int i=0;i<=countWords(value3);i++) {
            disp = disp + "\n" + splitStr[i].toString();
        }
        tv7.setText(disp);
        */

        int f_size, p_size;
        String frame[];
            String page;
            boolean flag;                                                            //flag for page fault
            int ctr = 0, pg_miss = 0, pg_hit = 0;

            f_size = Integer.parseInt(value1);
        p_size = Integer.parseInt(value2);
        String[] pages = value3.split("\\s+");
        frame = new String[f_size];                                                    //string array frame[] of f_size
        for (int i = 0; i < f_size; i++) {                                                    //initializes frame array with " " which indicates an empty frame array
            frame[i] = "_";
        }

                                                               //frame ctr; page fault counter
		/* while there are pages */
            for (int pg = 0; pg < p_size; pg++) {
                page = pages[pg];
                flag = true;                                                                //initially, flag is true because it has not yet found a page hit
                for (int j = 0; j < frame.length; j++) {                                        //checks if page hit
                    if (frame[j].equals(page)) {
                        flag = false;                                                        //if page hit, no fault occurs
                        break;
                    }
                }
                if (flag) {                                                                    //If there is page fault,
                    frame[ctr] = page;                                                        //replace the page in frame[ctr].
                    ctr++;
                    if (ctr == frame.length)
                        ctr = 0;                                                                                //set ctr back to 0 if ctr is equal to length of frame

                   tv7.setText(tv7.getText() + "frame:-->     ");
                   // System.out.print("frame: ");

				/* display the frame buffer array */
                    for (int j = 0; j < frame.length; j++)
                        tv7.setText(tv7.getText() + frame[j] + "   ");//System.out.print(frame[j] + "   ");
                    tv7.setText(tv7.getText() + " Miss!!\n");//System.out.print(" --> page miss!");
                    pg_miss++;               //add 1 to the page faults
                    //tv7.setText(tv7.getText() + "\nHits:" + pg_hit + "\tMiss:" + pg_miss );//System.out.println();

                } else {
                    tv7.setText(tv7.getText() + "frame:-->     ");//System.out.print("frame: ");                                            //If page hit, no replacement
				/* diaplay the frame buffer array */
                    for (int j = 0; j < frame.length; j++)
                        tv7.setText(tv7.getText() + frame[j] + "   "); //  System.out.print(frame[j] + "   ");
                   // tv1.append(Html.fromHtml("<font color='#FFFEF'>Hit</font>"));
                   tv7.setText(tv7.getText() + "  Hit!!\n");// System.out.print(" --> page hit!");
                    pg_hit++;
                   // tv7.setText(tv7.getText() + "\nHits:" + pg_hit +"\t"+"Miss:" + pg_miss ); //System.out.println();


                }
            }

            tv8.setText("Hits:" + pg_hit + "\nMisses:" + pg_miss + "\n");
          //  tv7.setText(tv7.getText() );
            //System.out.println("\nHits:" + pg_hit + "Faults:" + pg_miss + "\n");        //Display Total Page Fault



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
