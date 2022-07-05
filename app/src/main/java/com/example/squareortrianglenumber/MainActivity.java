package com.example.squareortrianglenumber;

import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public boolean CheckSq(int n){
        double sq = sqrt(n);
        return ((sq - Math.floor(sq)) == 0);
    }

    public void CheckNum(View v) {
        EditText inputNum = (EditText) findViewById(R.id.NumEditText);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView outputTextView = (TextView) findViewById(R.id.outputTextView);

        int flag = 0, input;

        // Checks if number is entered
        if (inputNum.getText().toString().isEmpty())
            Toast.makeText(MainActivity.this, "Enter the number!!!", Toast.LENGTH_SHORT).show();

        else {
            //flag == 0 -> Neither sq nor tr number
            //flag == 1 -> Square number only
            //flag == 2 -> Triangle number only
            //flag == 3 ->  Both sq and tr number

            input = Integer.parseInt(inputNum.getText().toString());

            if (CheckSq(input))
                flag = 1;

            else if (CheckSq(8 * input + 1))
                flag = 2;

            else if (CheckSq(input) && CheckSq(8 * input + 1))
                flag = 3;

            if (flag == 0) {
                outputTextView.setText("Not Sq not Triangle number");
                imageView.setImageResource(R.drawable.em);
            } else if (flag == 1) {
                outputTextView.setText("Sq. Number");
                imageView.setImageResource(R.drawable.sq);
            } else if (flag == 2) {
                outputTextView.setText("Triangle Number");
                imageView.setImageResource(R.drawable.tr);
            } else {
                outputTextView.setText("Both Sq. and Triangle Number");
                imageView.setImageResource(R.drawable.sqtr);
            }

            Toast.makeText(MainActivity.this, "Thanks for using", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}