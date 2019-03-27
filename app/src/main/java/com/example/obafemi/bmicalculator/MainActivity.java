package com.example.obafemi.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Height = findViewById(R.id.height);
                float height = Float.parseFloat(Height.getText().toString());

                EditText Weight = findViewById(R.id.weight);
                int weight = Integer.parseInt(Weight.getText().toString());

               double a = calculator(height,weight);
               String b = String.valueOf(a);


                TextView BMI = findViewById(R.id.BMI);
               BMI.setText(b);

               TextView category = findViewById(R.id.category);
               if (a < 18.5)
                   category.setText(R.string.unW);
               else if(a>18.5 && a<24.9)
                   category.setText(R.string.norm);
               else if(a>25 && a<30)
                   category.setText(R.string.ovW);
               else
                   category.setText(R.string.Obese);

            }
        });
    }

    private double calculator(float height, int weight) {
        double B = (height/100)*(height/100);
        float i = Float.parseFloat (String.valueOf(weight/B));
        return Math.round(i);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.main_menu,menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.male:
                setTheme(R.style.Male);
                return true;
            case R.id.female:
                setTheme(R.style.AppTheme);
                return true;

            default:
                return super.onOptionsItemSelected(item);


    }
}

    private void female() {
    }

    private void male() {
        setTheme(R.style.Male);

    }}
