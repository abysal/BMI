package com.example.bmi1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView text_weight1, text_Result1, textheight1;
private Button btnCalculate2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        setbutton();
    }
    private void initiate(){
text_weight1 =findViewById(R.id.txt_weight2);
textheight1 =findViewById(R.id.txt_height2);
text_Result1 = findViewById(R.id.txt_result2);
btnCalculate2 = findViewById(R.id.btnCalculate2);


    }
    private void setbutton(){
        btnCalculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateBMI();
            }
        });
    }

    private void CalculateBMI(){
    float weight=Float.parseFloat(text_weight1.getText().toString());
    float height=Float.parseFloat(textheight1.getText().toString())/100;
    WeightModel wm=new WeightModel(weight,height);
    float result=wm.getWeight1()/(wm.getHeight1()*wm.getHeight1());
    text_Result1.setText(""+result);
        if (result<18.5){
            Toast.makeText(MainActivity.this,"Underweight",Toast.LENGTH_LONG).show();
        }
        else if (result>=18.5 && result<=24.9){
            Toast.makeText(MainActivity.this,"Normal Weight",Toast.LENGTH_LONG).show();
        }
        else if (result>=25 && result<=29.9){
            Toast.makeText(MainActivity.this,"Overweight",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Obesity",Toast.LENGTH_LONG).show();
        }


    }
}
