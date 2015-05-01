package com.josevargas.punto4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    int figura=0;
    EditText radio,altura,base,lado1,lado2;
    TextView area;
    Button bsiguiente, bcalcular;
    RadioButton rcirculo, rtriangulo, rcaudro, rrectagulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcirculo=(RadioButton) findViewById(R.id.rcirculo);
        rtriangulo=(RadioButton) findViewById(R.id.rtriangulo);
        rcaudro=(RadioButton) findViewById(R.id.rcuadro);
        rrectagulo=(RadioButton) findViewById(R.id.rrectangulo);

        bsiguiente=(Button) findViewById(R.id.bsiguiente);
        bcalcular=(Button) findViewById(R.id.bcalcular);

        area=(TextView) findViewById(R.id.tarea);

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("figura",figura);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        figura=savedInstanceState.getInt("figura");
    }

    public void radiobutton(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rcirculo:
                if (checked)
                    figura=1;
                break;
            case R.id.rtriangulo:
                if (checked)
                    figura=2;
                break;
            case R.id.rcuadro:
                if (checked)
                    figura=3;
                break;
            case R.id.rrectangulo:
                if (checked)
                    figura=4;
                break;
        }
    }

    public void siguiente(View view){

        if(figura==0){
            Toast.makeText(getBaseContext(), getResources().getString(R.string.toastfigura), Toast.LENGTH_SHORT).show();
        }else{
            switch (figura) {
                case 1:
                    setContentView(R.layout.circulo);
                    radio=(EditText) findViewById(R.id.eradio);
                    area=(TextView) findViewById(R.id.tarea);
                    break;
                case 2:
                    setContentView(R.layout.triangulo);
                    altura=(EditText) findViewById(R.id.ealtura);
                    base=(EditText) findViewById(R.id.ebase);
                    area=(TextView) findViewById(R.id.tarea);
                    break;
                case 3:
                    setContentView(R.layout.cuadro);
                    lado1=(EditText) findViewById(R.id.elado);
                    area=(TextView) findViewById(R.id.tarea);
                    break;
                case 4:
                    setContentView(R.layout.rectangulo);
                    lado1=(EditText) findViewById(R.id.elado1);
                    lado2=(EditText) findViewById(R.id.elado2);
                    area=(TextView) findViewById(R.id.tarea);
                    break;
                default:
                    break;
            }

        }
    }

    public void calcular(View view){

        double r,b,h,set,l1,l2;
        String s;
        DecimalFormat df = new DecimalFormat("0.00");

        switch (figura) {
            case 1:
                if(TextUtils.isEmpty(radio.getText())){
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
                }else{
                    r=Double.parseDouble(radio.getText().toString());
                    set=Math.PI*Math.pow(r,2);
                    s = df.format(set);
                    //s = String.valueOf(set);
                    area.setText(s);
                }
                break;
            case 2:
                if(TextUtils.isEmpty(altura.getText()) || TextUtils.isEmpty(base.getText())){
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
                }else{
                    b=Double.parseDouble(base.getText().toString());
                    h=Double.parseDouble(altura.getText().toString());
                    set=(b*h)/2;
                    s = df.format(set);
                    area.setText(s);
                }
                break;
            case 3:
                if(TextUtils.isEmpty(lado1.getText())){
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
                }else{
                    l1=Double.parseDouble(lado1.getText().toString());
                    set=l1*l1;
                    s = df.format(set);
                    area.setText(s);
                }
                break;
            case 4:
                if(TextUtils.isEmpty(lado1.getText()) || TextUtils.isEmpty(lado2.getText())){
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
                }else{
                    l1=Double.parseDouble(lado1.getText().toString());
                    l2=Double.parseDouble(lado2.getText().toString());
                    set=l1*l2;
                    s = df.format(set);
                    area.setText(s);
                }
                break;
            default:
                break;
        }
    }

    public void again (View view){
        setContentView(R.layout.activity_main);
        figura=0;
    }

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
