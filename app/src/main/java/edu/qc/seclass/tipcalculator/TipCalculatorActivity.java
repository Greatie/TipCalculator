package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tipcalculator.R;

public class TipCalculatorActivity extends AppCompatActivity {
    EditText checkAmountValue, partySizeValue;
    EditText fifteenPercentTipValue,twentyPercentTipValue, twentyfivePercentTipValue;
    EditText fifteenPercentTotalValue,twentyPercentTotalValue, twentyfivePercentTotalValue;
    Button buttonCompute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        buttonCompute = findViewById(R.id.buttonCompute);

        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = checkAmountValue.getText().toString().trim();
                String b = partySizeValue.getText().toString().trim();
                if (a.equals("") || b.equals("")) {
                    Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!", Toast.LENGTH_LONG).show();
                }
                else {
                    int amt = Integer.valueOf(checkAmountValue.getText().toString().trim());
                    int partySize = Integer.valueOf(partySizeValue.getText().toString().trim());
                    if (amt < 0 || partySize < 0) {
                        Toast.makeText(getApplicationContext(), "Invalid for negative values!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double val = ((double) amt / partySize);
                        long fifteenTip = Math.round(val * (.15));
                        long twentyTip = Math.round(val * (.20));
                        long twentyfiveTip = Math.round(val * (.25));

                        double fifteenTotal = val + fifteenTip;
                        double twentyTotal = val + twentyTip;
                        double twentyfiveTotal = val + twentyfiveTip;

                        fifteenPercentTipValue.setText(String.valueOf(fifteenTip));
                        twentyPercentTipValue.setText(String.valueOf(twentyTip));
                        twentyfivePercentTipValue.setText(String.valueOf(twentyfiveTip));
                        fifteenPercentTotalValue.setText(String.valueOf((int) fifteenTotal));
                        twentyPercentTotalValue.setText(String.valueOf((int) twentyTotal));
                        twentyfivePercentTotalValue.setText(String.valueOf((int) twentyfiveTotal));
                    }
                }
            }
        });
    }
}