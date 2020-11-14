package com.example.clase_01_es;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;
    private Spinner combo;
    private String[] operaciones;
    private ArrayAdapter<String>  adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.num1 = findViewById(R.id.numero1);
        this.num2 = findViewById(R.id.numero2);
        this.result = findViewById(R.id.resultado);
        this.combo = findViewById(R.id.operaciones);

        this.operaciones = getResources().getStringArray(R.array.operaciones);

        this.adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, operaciones);
        this.combo.setAdapter(this.adapter);
    }

    public void calcular(View v){

        if( validar() ){

            double  n1, n2, rt=0;
            int op;

            n1 = Double.parseDouble(this.num1.getText().toString());
            n2 = Double.parseDouble(this.num2.getText().toString());
            op = this.combo.getSelectedItemPosition();

            switch (op){
                case 0:
                    rt = n1+n2;
                    break;
                case 1:
                    rt = n1-n2;
                    break;
                case 2:
                    rt = n1*n2;
                    break;
                case 3:
                    rt = n1/n2;
                    break;
            }

            this.result.setText( String.format("%.2f", rt) );
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

        int op = this.combo.getSelectedItemPosition();
        double n2 = Double.parseDouble(this.num2.getText().toString());

        if(op==3 && n2==0){
            this.num2.setError(getString(R.string.error_division));
            this.num2.requestFocus();
            return false;
        }

        return true;
    }

}
