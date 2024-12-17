package com.example.menuoption;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menuoption.R;

public class MainActivity extends AppCompatActivity {

    EditText etn1, etn2;
    TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn1 = findViewById(R.id.etn1);
        etn2 = findViewById(R.id.etn2);
        result = findViewById(R.id.result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        try {
            double num1 = Double.parseDouble(etn1.getText().toString());
            double num2 = Double.parseDouble(etn2.getText().toString());
            double res;

            if (id == R.id.menu_plus) {
                res = num1 + num2;
                result.setText("תוצאה: " + res);
            } else if (id == R.id.menu_hisur) {
                res = num1 - num2;
                result.setText("תוצאה: " + res);
            } else if (id == R.id.menu_kefel) {
                res = num1 * num2;
                result.setText("תוצאה: " + res);
            } else if (id == R.id.menu_hiluk) {
                if (num2 != 0) {
                    res = num1 / num2;
                    result.setText("תוצאה: " + res);
                } else {
                    Toast.makeText(this, "אי אפשר לחלק ב-0", Toast.LENGTH_SHORT).show();
                }
            } else if (id == R.id.menu_C) {
                etn1.setText("");
                etn2.setText("");
                result.setText("תוצאה: ");
            }
            return true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "מספרים לא חוקיים", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}