package com.josevargas.punto5;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    EditText nombre, correo, telefono;
    TextView name,mail,phone,sexo,ciudad,hobbie,fecha,efecha;
    Button boton,bfecha;
    RadioButton masculino, femenino;
    int sex=0;
    Spinner ciudades;
    DatePicker dpResult;
    int[] hob = new int[4];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText) findViewById(R.id.editNombre);
        correo=(EditText) findViewById(R.id.editCorreo);
        telefono=(EditText) findViewById(R.id.editTelefono);


        name=(TextView) findViewById(R.id.tNombre);
        mail=(TextView) findViewById(R.id.tCorreo);
        phone=(TextView) findViewById(R.id.tTelefono);
        sexo=(TextView) findViewById(R.id.tSexo);
        ciudad=(TextView) findViewById(R.id.tCiudad);
        hobbie=(TextView) findViewById(R.id.tHobbie);
        fecha=(TextView) findViewById(R.id.tFecha);

        boton=(Button) findViewById(R.id.boton);

        masculino=(RadioButton) findViewById(R.id.rmasculino);
        femenino=(RadioButton) findViewById(R.id.rfemenino);

        ciudades=(Spinner) findViewById(R.id.sciudades);

        dpResult = (DatePicker) findViewById(R.id.dpResult);

    }

    public void radiobutton(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rfemenino:
                if (checked)
                    sex=1;
                break;
            case R.id.rmasculino:
                if (checked)
                    sex=2;
                break;
            }
    }

    public void checkbox(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.chguitarra:
                if (checked) {
                    hob[0]=1;
                }else{
                    hob[0]=0;
                }
                break;
            case R.id.chpintar:
                if (checked) {
                    hob[1]=1;
                }else{
                    hob[1]=0;
                }
                break;
            case R.id.chprogramar:
                if (checked) {
                    hob[2]=1;
                }else{
                    hob[2]=0;
                }
                break;
            case R.id.chcantar:
                if (checked) {
                    hob[3]=1;
                }else{
                    hob[3]=0;
                }
                break;
        }
    }

    public void CargarDatos(View view){

        if(TextUtils.isEmpty(nombre.getText()) || TextUtils.isEmpty(telefono.getText()) || TextUtils.isEmpty(correo.getText())
                || sex==0 || (hob[0]==0 && hob[1]==0 && hob[2]==0 && hob[3]==0)){
            Toast.makeText(getBaseContext(), "Faltan campos por llenar!", Toast.LENGTH_SHORT).show();
        }else{
            name.setText(nombre.getText());
            phone.setText(telefono.getText());
            mail.setText(correo.getText());
            ciudad.setText(String.valueOf(ciudades.getSelectedItem()));
            fecha.setText(dpResult.getDayOfMonth()+"-"+dpResult.getMonth()+"-"+dpResult.getYear());
            switch (sex) {
                case 1:
                    sexo.setText("Femenino");
                    break;
                case 2:
                    sexo.setText("Masculino");
                    break;
                default:
                    break;
            }

            if      (hob[0]==0 && hob[1]==0 && hob[2]==0 && hob[3]==1) {
                hobbie.setText("Cantar");
            }else if(hob[0]==0 && hob[1]==0 && hob[2]==1 && hob[3]==0){
                hobbie.setText("Programar");
            }else if(hob[0]==0 && hob[1]==0 && hob[2]==1 && hob[3]==1){
                hobbie.setText("Programar\nCantar");
            }else if(hob[0]==0 && hob[1]==1 && hob[2]==0 && hob[3]==0){
                hobbie.setText("Pintar");
            }else if(hob[0]==0 && hob[1]==1 && hob[2]==0 && hob[3]==1){
                hobbie.setText("Pintar\nCantar");
            }else if(hob[0]==0 && hob[1]==1 && hob[2]==1 && hob[3]==0){
                hobbie.setText("Pintar\nProgramaar");
            }else if(hob[0]==0 && hob[1]==1 && hob[2]==1 && hob[3]==1){
                hobbie.setText("Pintar\nProgramar\nCantar");
            }else if(hob[0]==1 && hob[1]==0 && hob[2]==0 && hob[3]==0){
                hobbie.setText("Tocar guitarra");
            }else if(hob[0]==1 && hob[1]==0 && hob[2]==0 && hob[3]==1){
                hobbie.setText("Tocar guitarra\nCantar");
            }else if(hob[0]==1 && hob[1]==0 && hob[2]==1 && hob[3]==0){
                hobbie.setText("Tocar guitarra\nProgramar");
            }else if(hob[0]==1 && hob[1]==0 && hob[2]==1 && hob[3]==1){
                hobbie.setText("Tocar guitarra\nProgramar\nCantar");
            }else if(hob[0]==1 && hob[1]==1 && hob[2]==0 && hob[3]==0){
                hobbie.setText("Tocar guitarra\nPintar");
            }else if(hob[0]==1 && hob[1]==1 && hob[2]==0 && hob[3]==1){
                hobbie.setText("Tocar guitarra\nPintar\nProgramar");
            }else if(hob[0]==1 && hob[1]==1 && hob[2]==1 && hob[3]==1){
                hobbie.setText("Tocar guitarra\nPintar\nProgramar\nCantar");
            }
        }
    }


    /*
    private int year;
    private int month;
    private int day;


        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
      */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
