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

public class LRU extends Fragment {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    String disp;

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
        disp = "Entered Values:" + splitStr[0].toString() ;
        for(int i=0;i<=countWords(value3);i++) {
            disp = disp + "," + splitStr[i+1].toString();
        }

        tv6.setText(disp);
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

        																	//flag for page fault
        int k = 0;														//index k (if page fault occurs); page fault counter
        String a[] = new String[f_size];												/* 2 temporary arrays to keep track of LRU page, sorted from most recent to least recent */
        String b[] = new String[f_size];												/* first element of a[] is most recent and the last element is the LRU */
        for(int i=0 ; i<f_size ; i++){													//initialize array elements to " "
            a[i] = " ";
            b[i] = " ";
        }

        for(int pg=0 ; pg < p_size ; pg++){
            page = pages[pg];
            flag = true;																//initially, flag is true because it has not yet found a page hit
            for(int j=0 ; j < f_size ; j++){											//checks if page hit
                if(frame[j].equals(page)){
                    flag = false; 														//If page hit, no page fault occurs
                    break;
                }
            }

            for(int j=0 ; j < f_size && flag ; j++){									//While page fault occurs and find the least recently used page,
                if(frame[j].equals(a[f_size-1])){										//If least recently used
                    k = j;																//set index to be replaced
                    break;
                }
            }

            if(flag == true){																	//If page fault,
                frame[k]=page;															//replace frame[k] with the page.
                k++;
                if (k == frame.length)
                    k = 0;
                tv7.setText(tv7.getText() + "frame:-->     ");// System.out.print("frame: " );
				/* display frame buffer array */
                for(int j=0 ; j < f_size ; j++)
                    tv7.setText(tv7.getText() + frame[j] + "   ");    //System.out.print(frame[j] + "  ");
                tv7.setText(tv7.getText() + " Miss!!\n");
                //System.out.println(" --> page fault!" );
                pg_miss++;																//add 1 to page fault counter
            }
            else{																		//If page hit, no replacement
				/* display frame buffer array */
                tv7.setText(tv7.getText() + "frame:-->     ");//System.out.print("frame: " );
                for(int j=0 ; j < f_size ; j++)
                    tv7.setText(tv7.getText() + frame[j] + "   ");
                    // System.out.print(frame[j]+"  ");
                tv7.setText(tv7.getText() + "  Hit!!\n");
                //System.out.println(" --> page hit!" );
                pg_hit++;
            }

            int p=1;																	//counter
            b[0]=page;																	//first element of b[] is the page (b is most recent)
			/* update MRU-LRU array */
            for(int j=0 ; j < a.length ; j++){											//while j < size of frames
                if(!page.equals(a[j]) && p < f_size){									//the elements in a[] that are not equal to referenced page or is not the most recently used are copied to b[j] from left
                    b[p]=a[j];
                    p++;
                }
            }
            for(int j=0 ; j < f_size ; j++){											//set LRU a[] to the updated LRU b[]
                a[j]=b[j];
            }
        }
        tv8.setText("Hits:" + pg_hit + "\nMisses:" + pg_miss + "\n");










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
