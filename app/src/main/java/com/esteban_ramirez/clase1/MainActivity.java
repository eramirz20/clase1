package com.esteban_ramirez.clase1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.icu.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private String Nombre, Apellido,Correo,Loggin,password="",password2="", Numero,Sexo,Hobbie=" ",Ciudad1;
    private EditText eNombre, eApellido, ecorreo, enumero,eLoggin,ePassword,ePassword2;
    private Button bBoton,bFecha;
    private TextView eInfo,tFecha;
    private RadioButton Masculino,Femenino;
    private CheckBox Dormir,Comer,Peliculas,Deporte;
    private Spinner sCiudades;
    private DatePicker date;
    private int year_x,month_x,day_x;
    static  final int DILOG_ID=0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        date=(DatePicker) findViewById(R.id.date);
        eNombre = (EditText) findViewById(R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        eLoggin=(EditText) findViewById((R.id.eLoggin));
        ePassword=(EditText) findViewById(R.id.ePassword);
        ePassword2=(EditText) findViewById(R.id.ePassword2);

        bBoton = (Button) findViewById(R.id.eBoton);
        eInfo = (TextView) findViewById(R.id.einfo);
        ecorreo=(EditText) findViewById(R.id.ecorreo);
        enumero=(EditText)  findViewById(R.id.enumero);
        Masculino=(RadioButton)  findViewById(R.id.rMasculino);
        Femenino=(RadioButton)  findViewById(R.id.rFemenino);
        Dormir=(CheckBox) findViewById(R.id.cDormir);
        Comer=(CheckBox) findViewById(R.id.cComer);
        Peliculas=(CheckBox) findViewById(R.id.cPeliculas);
        Deporte=(CheckBox) findViewById(R.id.cDeporte);
        sCiudades=(Spinner) findViewById(R.id.sCiudades);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sCiudades, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sCiudades.setAdapter(adapter);

        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Ciudad1 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nombre=eNombre.getText().toString();
                Apellido=eApellido.getText().toString();
                Correo=ecorreo.getText().toString();
                Numero=enumero.getText().toString();
                Loggin=eLoggin.getText().toString();


                password=ePassword.getText().toString();
                password2=ePassword2.getText().toString();

                year_x = date.getYear();
                month_x = date.getMonth()+1;
                day_x = date.getDayOfMonth();


                if (Nombre.equals("") || Apellido.equals("") ||Loggin.equals("")||Correo.equals("")
                        ||Numero.equals("")||Hobbie.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Faltan espacios por llenar",Toast.LENGTH_SHORT).show();
                }

                if(password.equals(password2)){ }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Password incorrecto",Toast.LENGTH_SHORT).show();

                }


                if(Masculino.isChecked()){
                    Sexo="Masculino";
                }
                else{
                    Sexo="Femenino";
                }
                if(Dormir.isChecked()){
                    Hobbie+="Dormir,";
                }
                if(Comer.isChecked()){
                    Hobbie+="Comer,";
                }
                if(Peliculas.isChecked()){
                    Hobbie+="Peliculas,";
                }
                if(Deporte.isChecked()){
                    Hobbie+="Deporte,";
                }

                if (password.equals(password2)) {
                    eInfo.setText("Nombre:" + Nombre + "\nApellido:" + Apellido + "\nLoggin:" + Loggin + "\nCorreo:"
                            + Correo + "\nNumero:" + Numero + "\nSexo:" + Sexo + "\nHobbies:" + Hobbie +
                            "\nCiudades:" + Ciudad1 + "Fecha de nacimiento" + year_x + "/" + month_x + "/" + day_x);
                    Hobbie = "";
                }
                else {
                    eInfo.setText("");
                }
            }
        });


    }
}
