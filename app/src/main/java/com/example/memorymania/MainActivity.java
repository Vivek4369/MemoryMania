package com.example.memorymania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView curView = null;
    private int countPair = 0;
    final int[] drawable = new int[]{R.drawable.animals_1,R.drawable.animals_2,R.drawable.animals_3,
            R.drawable.animals_4 ,R.drawable.animals_5,R.drawable.animals_6,R.drawable.animals_7,R.drawable.animals_8};

    //below 'pos' variable is assigning the position to images
    //we have to make it random
    //so how can we do that --->(Vinayak)?

    int[] pos = {0,0,2,3,4,5,6,7,1,1,2,3,4,5,6,7};
    int currentPos = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(currentPos<0)
                {
                    currentPos = position;
                    curView = (ImageView)view;
                    ((ImageView) view).setImageResource(drawable[pos[position]]);
                }

                else
                {
                    if(currentPos == position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.hidden);
                    }
                    else if(pos[currentPos]!=pos[position])
                    {
                        curView.setImageResource(R.drawable.hidden);
                        Toast.makeText(getApplicationContext(),"Not match", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;

                        if(countPair==0)
                        {
                            Toast.makeText(getApplicationContext(),"You Win", Toast.LENGTH_SHORT).show();
                        }
                    }

                    currentPos = -1;
                }
            }
        });

    }
}