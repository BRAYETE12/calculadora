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

        if( validar()  ){

            double  n1, n2, rt;

            n1 = Double.parseDouble(this.num1.getText().toString());
            n2 = Double.parseDouble(this.num2.getText().toString());
            rt = n1 + n2;
            this.result.setText( rt+"" );
        }

    }

    public void limpiar(View v){
        this.num1.setText( "" );
        this.num2.setText( "" );
        this.result.setText( "" );
        this.num1.requestFocus();
    }

    public boolean validar(){

        if(this.num1.getText().toString().isEmpty()){
            this.num1.setError( getString(R.string.error_numero) );
            this.num1.requestFocus();
            return false;
        }

        if(this.num2.getText().toString().isEmpty()){
            this.num2.setError(getString(R.string.error_numero));
            this.num2.requestFocus();
            return false;
        }

        return true;
    }

}
