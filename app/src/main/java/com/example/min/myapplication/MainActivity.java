package com.example.min.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements OnClickListener {
    static final private String TAG = "Umpire Buddy";
    private int scount = 0;
    private int bcount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// The following will print to LogCat.
        Log.i(TAG, "Starting onCreate...");
        setContentView(R.layout.activity_main);
        View strikeButton = findViewById(R.id.strike_button);
// This class implements the onClickListener interface.
// Passing &#39;this&#39; to setOnClickListener means the
// onClick method in this class will get called
// when the button is clicked.
        strikeButton.setOnClickListener(this);
        View ballButton = findViewById(R.id.ball_button);
        ballButton.setOnClickListener(this);
        updateCount();
    }
    private void updateCount() {
        TextView strikes = (TextView)findViewById(R.id.strike_count);
        strikes.setText(Integer.toString(scount));
        TextView balls = (TextView)findViewById(R.id.ball_count);
        balls.setText(Integer.toString(bcount));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.strike_button:
// Start count over if user tries to increment
// beyond 3.
                if (scount == 2) {
                    scount++;
// Builder is an inner class so we have to qualify it
// with its outer class: AlertDialog

                    //2;

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Three strikes - Batter out.");
                    builder.setCancelable(false);
                    builder.setPositiveButton("RESET", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            scount = 0;
                            bcount = 0;
// Note, you have to call update count here because.
// the call builder.show() below is non blocking.
                            updateCount();
                        }
                    });
                    builder.show();
                }
                else {
                    scount++;
                }
                break;
            case R.id.ball_button:
// Start count over if user tries to increment
// beyond 4.
                if (bcount == 3) {
                    bcount++;
// Builder is an inner class so we have to qualify it
// with its outer class: AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Four balls - Batter walked.");
                    builder.setCancelable(false);
                    builder.setPositiveButton("RESET", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            scount = 0;
                            bcount = 0;
// Note, you have to call update count here because.
// the call builder.show() below is non blocking.
                            updateCount();
                        }
                    });
                    builder.show();
                }
                else {
                    bcount++;
                }
                break;
        }
        updateCount();
    }
}



