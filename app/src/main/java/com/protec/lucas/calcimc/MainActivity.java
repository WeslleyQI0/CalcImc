package com.protec.lucas.calcimc;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        btn = (Button) findViewById(R.id.btn_calc);

        editText1 = (EditText) findViewById(R.id.input_peso);
        editText2 = (EditText) findViewById(R.id.input_altura);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                double peso = Double.parseDouble(editText1.getText().toString());
                double altura = Double.parseDouble(editText2.getText().toString());

                double resultado = (peso /(Math.pow(altura, 2)));

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);


                dialogo.setTitle("Resultado:");

                if(resultado <18.5){
                    dialogo.setMessage("Imc: "+resultado + "\nAbaixo da do peso ideal");
                }

                else if(resultado >=18.6 && resultado<24.9){
                    dialogo.setMessage("Imc: "+resultado + "\nPeso ideal");
                }

                else if(resultado >=25 && resultado<29.0){
                    dialogo.setMessage("Imc: "+resultado + "\nLevemente acima do peso");
                }

                else if(resultado >=30 && resultado<34.9){
                    dialogo.setMessage("Imc: "+resultado + "\nObesidade grau I");
                }

                else if(resultado >=35 && resultado<39.9) {
                    dialogo.setMessage("Imc: " + resultado + "\nObesidade grau II (Severa)");
                }

                else if(resultado >40){
                    dialogo.setMessage("Imc: "+resultado + "\nObesiade grau III (Morbida)");
                }

                dialogo.setNeutralButton("OK", null);

                dialogo.show();

            }
        });
    }
}
