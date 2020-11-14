package com.example.clase_01_es;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.num1 = findViewById(R.id.numero1);
        this.num2 = findViewById(R.id.numero2);
        this.result = findViewById(R.id.resultado);
    }

    public void calcular(View v){

        if( this.num1.getText().toString() != null  && this.num2.getText().toString() != null  ){

            double  n1, n2, rt;

            n1 = Double.parseDouble(this.num1.getText().toString());
            n2 = Double.parseDouble(this.num2.getText().toString());
            rt = n1 + n2;
            this.result.setText( rt+"" );
        }

    }

}
