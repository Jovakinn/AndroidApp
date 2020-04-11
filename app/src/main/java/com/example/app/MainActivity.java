package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText password;
    private Button button, button_alert, button2;
    private RatingBar rating;
    private TextView text_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton () {
        password = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button_alert = (Button) findViewById(R.id.alert);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button.setText("Done");
                button.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                Toast.makeText(
                        MainActivity.this, password.getText(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button2.setText("oops)");
                button2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
        });


        rating = (RatingBar) findViewById(R.id.ratingBar);
        text_show = (TextView) findViewById(R.id.textView);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                text_show.setText("Value" + String.valueOf(rating));
            }
        });


        button_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                button_alert.setText("Cool");
//                button.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
//                button_alert.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
//
//                Toast.makeText(
//                        MainActivity.this, "Прога воркает!",
//                        Toast.LENGTH_LONG
//                ).show();

                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("Do you want to close this app?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Closing app.");
                alert.show();
            }
        });
    }
}
