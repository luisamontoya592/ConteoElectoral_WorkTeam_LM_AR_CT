package com.example.conteoelectoral_workteam_lm_ar_ct;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtCantElectores, txtEdad;
    private TextView lblGanador, lblCandidato1, lblCandidato2,lblCandidato3;
    private Button btnFinalizar, btnCandidato1, btnCandidato2, btnCandidato3;
    private int Total=0, candidato1=0, candidato2=0, candidato3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCantElectores = (EditText) findViewById(R.id.txtCantElectores);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        lblGanador = (TextView) findViewById(R.id.lblGanador);
        lblCandidato1 = (TextView) findViewById(R.id.lblCandidato1);
        lblCandidato2 = (TextView) findViewById(R.id.lblCandidato2);
        lblCandidato3 = (TextView) findViewById(R.id.lblCandidato3);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnCandidato1 = (Button) findViewById(R.id.btnCandidato1);
        btnCandidato2 = (Button) findViewById(R.id.btnCandidato2);
        btnCandidato3 = (Button) findViewById(R.id.btnCandidato3);

    }

    private boolean AptoVotar(){
        boolean voto=false;
        int Edad=Integer.parseInt(txtEdad.getText().toString());

        if(Edad>=18){
            voto=true;
            return voto;

        } else {
            AlertDialog.Builder Mensaje = new AlertDialog.Builder(this);
            Mensaje.setMessage("Debe ser mayor de edad para votar");
            Mensaje.setTitle("ALERTA");
            Mensaje.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog= Mensaje.create();
            dialog.show();
            voto =false;
            return voto;

        }


    }

    public void btnCandidato1(View view){

        int limite = Integer.parseInt(txtCantElectores.getText().toString());
        AptoVotar();
        if(AptoVotar()==true&&candidato1+candidato2+candidato3<limite){
            candidato1 += 1;
            lblCandidato1.setText(String.valueOf(candidato1));
        }

    }

    public void btnCandidato2(View view){
        int limite = Integer.parseInt(txtCantElectores.getText().toString());
        AptoVotar();
        if(AptoVotar()==true&&candidato1+candidato2+candidato3<limite){
            candidato2 += 1;
            lblCandidato2.setText(String.valueOf(candidato2));
        }
    }

    public void btnCandidato3(View view){
        int limite = Integer.parseInt(txtCantElectores.getText().toString());
        AptoVotar();
        if(AptoVotar()==true&&candidato1+candidato2+candidato3<limite){
            candidato3 += 1;
            lblCandidato3.setText(String.valueOf(candidato3));
        }
    }


    public void btnFinalizar(View view)
    {
        Total=candidato1+candidato2+candidato3;

        if(candidato1==candidato2 || candidato1==candidato3 || candidato2==candidato3)
        {
            lblGanador.setText("Empate");
        }

        if (candidato1>candidato2&&candidato1>candidato3)
        {
            lblGanador.setText("Candidato 1");
        }

        if (candidato2>candidato1&&candidato2>candidato3)
        {
            lblGanador.setText("Candidato 2");
        }

        if (candidato3>candidato1&&candidato3>candidato2)
        {
            lblGanador.setText("Candidato 3");
        }


    }



}
