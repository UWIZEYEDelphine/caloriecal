package com.example.caloriecal;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class bmr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        //get TextViews
        bmrTextView = (TextView) findViewById(R.id.bmrTextView);
        caloricTextView = (TextView) findViewById(R.id.caloricTextView);
        gainWeightTextView = (TextView) findViewById(R.id.gainWeightTextView);
        loseWeightTextView = (TextView) findViewById(R.id.loseWeightTextView);

        //get Buttons
        calculateBmrButton = (Button) findViewById(R.id.calculateBmrButton);
        calculateBmrButton.setOnClickListener(calculateBmrButtonListener);

        bmrTextView.setText(0 + " Calories");//set original bmr value
        caloricTextView.setText(0 + " Cal daily");//set original daily caloric intake value
        gainWeightTextView.setText(0 + " Cal daily");//set original bmr value
        loseWeightTextView.setText(0 + " Cal daily");//set original daily caloric intake value

    }

    private TextView bmrTextView;//show the calculated BMR
    private TextView caloricTextView;//show the calculated recommended daily caloric intake
    private TextView gainWeightTextView;
    private TextView loseWeightTextView;
    private Button calculateBmrButton;


    private void calculate() {

        //double heightCm = profile.height*2.54;
        //double weightKg = profile.weight/2.2;
        double bmr = 0.0;
        double dailyCaloricIntake = 0.0;

        if (profile.genderSwitch.isChecked()==false) { //if the selection is female
            //Mifflin-St.Jeor equation for females
            bmr = (profile.height * 6.25) + (profile.weight * 9.99) - (profile.age * 4.92) - 161;
        } else {//if the selection is male
            //Mifflin-St.Jeor equation for males
            bmr = (profile.height* 6.25) + (profile.weight * 9.99) - (profile.age * 4.92) + 5;
        }
        bmrTextView.setText((int)bmr + " Calories");

        //setting caloricTextView
        if (profile.zero.isChecked()) {
            dailyCaloricIntake = bmr * 1.2;
        } else if (profile.oneToTwo.isChecked()) {
            dailyCaloricIntake = bmr * 1.375;
        } else if (profile.threeToFive.isChecked()) {
            dailyCaloricIntake = bmr * 1.55;
        } else if (profile.sixToSeven.isChecked()) {
            dailyCaloricIntake = bmr * 1.725;
        }

        caloricTextView.setText((int)dailyCaloricIntake + " Cal daily");
        loseWeightTextView.setText(((int)dailyCaloricIntake - 1000) + " Cal daily");
        gainWeightTextView.setText(((int)dailyCaloricIntake + 1000) + " Cal daily");
    }

    private View.OnClickListener calculateBmrButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calculate();
        }
    };

}
