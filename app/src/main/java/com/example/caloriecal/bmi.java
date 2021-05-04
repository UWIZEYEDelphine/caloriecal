package com.example.caloriecal;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        //get TextViews
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        status = (TextView) findViewById(R.id.status);

        //get Buttons
        calculateBmiButton = (Button) findViewById(R.id.calculateBmiButton);
        calculateBmiButton.setOnClickListener(calculateBmiButtonListener);

    }

    private TextView bmiTextView;//show the calculated BMR
    private TextView status;

    private Button calculateBmiButton;

    private void calculate() {
        double heightM = (double)profile.height/100;
        double bmi = (double)profile.weight /(heightM * heightM) ;
        Log.d("MI","bmi=" + bmi);
        bmiTextView.setText(String.format("%.02f", bmi));
        if (bmi < 18.5){ status.setText(" Your BMI indicates that you are Underweight, you need to increase your weight. Go to 'Find daily caloric intake' for details.");}
        else if (bmi > 24.9){ status.setText("Your BMI indicates that you are Overweight, you need to decrease your weight. Go to 'Find daily caloric intake' for details.");}
        else {status.setText("Your BMI indicates that you have Normal weight, keep taking care of your health.");}
    }

    private View.OnClickListener calculateBmiButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calculate();


        }
    };

}
