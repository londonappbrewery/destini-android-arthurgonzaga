package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button btnTop, btnBottom;
    int mStoryIndex;
    int[] mStringStories, mStringEnds;
    int[][] mAnswers;

    final int BUTTON_TOP = 0;
    final int BUTTON_BOTTOM = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = findViewById(R.id.storyTextView);
        btnTop = findViewById(R.id.buttonTop);
        btnBottom = findViewById(R.id.buttonBottom);

        mStringStories = new int[] {R.string.T1_Story,
                                R.string.T2_Story,
                                R.string.T3_Story};

        mStringEnds = new int[] {R.string.T4_End,
                            R.string.T5_End,
                            R.string.T6_End};

        mAnswers = new int[][]{{R.string.T1_Ans1,R.string.T1_Ans2},
                            {R.string.T2_Ans1,R.string.T2_Ans2},
                            {R.string.T3_Ans1,R.string.T3_Ans2}};

        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("IndexKey");
            storyTextView.setText(mStringStories[mStoryIndex]);
            btnTop.setText(mAnswers[mStoryIndex][0]);
            btnBottom.setText(mAnswers[mStoryIndex][1]);
        }else {
            mStoryIndex  = 0;
        }
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion(BUTTON_TOP);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        btnBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion(BUTTON_BOTTOM);
            }
        });

    }

    private void updateQuestion(int answer){

        // Button Top answers
        if(answer == BUTTON_TOP && mStoryIndex == 0){
            mStoryIndex += 2;
            storyTextView.setText(mStringStories[mStoryIndex]);
            btnTop.setText(mAnswers[mStoryIndex][0]);
            btnBottom.setText(mAnswers[mStoryIndex][1]);
        }
        else if(answer == BUTTON_TOP && mStoryIndex == 1){
            mStoryIndex ++;
            storyTextView.setText(mStringStories[mStoryIndex]);
            btnTop.setText(mAnswers[mStoryIndex][0]);
            btnBottom.setText(mAnswers[mStoryIndex][1]);
        }
        else if(answer == BUTTON_TOP && mStoryIndex == 2){
            storyTextView.setText(mStringEnds[2]);
            btnTop.setVisibility(View.GONE);
            btnBottom.setVisibility(View.GONE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder alt = new AlertDialog.Builder(MainActivity.this);
                    alt.setTitle("Finished");
                    alt.setMessage("Do you want to play over?");
                    alt.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    alt.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    alt.show();
                }
            },10000);
        }

        // Button Bottom answers
        if(answer == BUTTON_BOTTOM && mStoryIndex == 0){
            mStoryIndex ++;
            storyTextView.setText(mStringStories[mStoryIndex]);
            btnTop.setText(mAnswers[mStoryIndex][0]);
            btnBottom.setText(mAnswers[mStoryIndex][1]);
        }else if(answer == BUTTON_BOTTOM && mStoryIndex == 1){
            storyTextView.setText(mStringEnds[0]);
            btnTop.setVisibility(View.GONE);
            btnBottom.setVisibility(View.GONE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder alt = new AlertDialog.Builder(MainActivity.this);
                    alt.setTitle("Finished");
                    alt.setMessage("Do you want to play over?");
                    alt.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    alt.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    alt.show();
                }
            },10000);
        }else if(answer == BUTTON_BOTTOM && mStoryIndex == 2){
            storyTextView.setText(mStringEnds[1]);
            btnTop.setVisibility(View.GONE);
            btnBottom.setVisibility(View.GONE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder alt = new AlertDialog.Builder(MainActivity.this);
                    alt.setTitle("Finished");
                    alt.setMessage("Do you want to play over?");
                    alt.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    alt.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    alt.show();
                }
            },10000);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey", mStoryIndex);
    }
}
