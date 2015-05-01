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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name.getText().toString());
        outState.putString("mail", mail.getText().toString());
        outState.putString("phone", phone.getText().toString());
        outState.putString("sexo", sexo.getText().toString());
        outState.putString("ciudad", ciudad.getText().toString());
        outState.putString("hobbie", hobbie.getText().toString());
        outState.putString("fecha", fecha.getText().toString());
        outState.putInt("sex",sex);
        outState.putIntArray("hob",hob);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        name.setText(savedInstanceState.getString("name"));
        mail.setText(savedInstanceState.getString("mail"));
        phone.setText(savedInstanceState.getString("phone"));
        sexo.setText(savedInstanceState.getString("sexo"));
        ciudad.setText(savedInstanceState.getString("ciudad"));
        hobbie.setText(savedInstanceState.getString("hobbie"));
        fecha.setText(savedInstanceState.getString("fecha"));
        sex=savedInstanceState.getInt("operacion");
        hob=savedInstanceState.getIntArray("hob");
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
            Toast.makeText(getBaseContext(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
        }else{
            name.setText(nombre.getText());
            phone.setText(telefono.getText());
            mail.setText(correo.getText());
            ciudad.setText(String.valueOf(ciudades.getSelectedItem()));
            fecha.setText(dpResult.getDayOfMonth()+"-"+(dpResult.getMonth()+1)+"-"+dpResult.getYear());
            switch (sex) {
                case 1:
                    sexo.setText(getResources().getString(R.string.femenino));
                    break;
                case 2:
                    sexo.setText(getResources().getString(R.string.masculino));
                    break;
                default:
                    break;
            }

            if      (hob[0]==0 && hob[1]==0 && hob[2]==0 && hob[3]==1) {
                hobbie.setText(getResources().getString(R.string.cantar));
            }else if(hob[0]==0 && hob[1]==0 && hob[2]==1 && hob[3]==0){
                hobbie.setText(getResources().getString(R.string.programar));
            }else if(hob[0]==0 && hob[1]==0 && hob[2]==1 && hob[3]==1){
                hobbie.setText(getResources().getString(R.string.programar)+"\n"+getResources().getString(R.string.cantar));
            }else if(hob[0]==0 && hob[1]==1 && hob[2]==0 && hob[3]==0){
                hobbie.setText(getResources().getString(R.string.pintar));
            }else if(hob[0]==0 && hob[1]==1 && hob[2]==0 && hob[3]==1){
                hobbie.setText(getResources().getString(R.string.pintar)+"\n"+getResources().getString(R.string.cantar));
            }else if(hob[0]==0 && hob[1]==1 && hob[2]==1 && hob[3]==0){
                hobbie.setText(getResources().getString(R.string.pintar)+"\n"+getResources().getString(R.string.programar));
            }else if(hob[0]==0 && hob[1]==1 && hob[2]==1 && hob[3]==1){
                hobbie.setText(getResources().getString(R.string.pintar)+"\n"+getResources().getString(R.string.programar)+"\n"+getResources().getString(R.string.cantar));
            }else if(hob[0]==1 && hob[1]==0 && hob[2]==0 && hob[3]==0){
                hobbie.setText(getResources().getString(R.string.guitara));
            }else if(hob[0]==1 && hob[1]==0 && hob[2]==0 && hob[3]==1){
                hobbie.setText(getResources().getString(R.string.guitara)+"\n"+getResources().getString(R.string.cantar));
            }else if(hob[0]==1 && hob[1]==0 && hob[2]==1 && hob[3]==0){
                hobbie.setText(getResources().getString(R.string.guitara)+"\n"+getResources().getString(R.string.programar));
            }else if(hob[0]==1 && hob[1]==0 && hob[2]==1 && hob[3]==1){
                hobbie.setText(getResources().getString(R.string.guitara)+"\n"+getResources().getString(R.string.programar)+"\n"+getResources().getString(R.string.cantar));
            }else if(hob[0]==1 && hob[1]==1 && hob[2]==0 && hob[3]==0){
                hobbie.setText(getResources().getString(R.string.guitara)+"\n"+getResources().getString(R.string.pintar));
            }else if(hob[0]==1 && hob[1]==1 && hob[2]==0 && hob[3]==1){
                hobbie.setText(getResources().getString(R.string.guitara)+"\n"+getResources().getString(R.string.pintar)+"\n"+getResources().getString(R.string.cantar));
            }else if(hob[0]==1 && hob[1]==1 && hob[2]==1 && hob[3]==0){
                hobbie.setText(getResources().getString(R.string.guitara)+"\n"+getResources().getString(R.string.pintar)+"\n"+getResources().getString(R.string.programar));
            }else if(hob[0]==1 && hob[1]==1 && hob[2]==1 && hob[3]==1){
                hobbie.setText(getResources().getString(R.string.guitara)+"\n"+getResources().getString(R.string.pintar)+"\n"+getResources().getString(R.string.programar)+"\n"+getResources().getString(R.string.cantar));
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
