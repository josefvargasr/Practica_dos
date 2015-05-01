package com.josevargas.punto2;

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

    EditText op1, op2;
    TextView respuesta;
    Button bmostrar;
    RadioButton suma, resta, mult, div;
    String s;
    int operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1=(EditText) findViewById(R.id.eop1);
        op2=(EditText) findViewById(R.id.eop2);

        respuesta=(TextView) findViewById(R.id.trespuesta);

        bmostrar=(Button) findViewById(R.id.bmostrar);

        suma=(RadioButton) findViewById(R.id.suma);
        resta=(RadioButton) findViewById(R.id.resta);
        mult=(RadioButton) findViewById(R.id.mult);
        div=(RadioButton) findViewById(R.id.div);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("respuesta", respuesta.getText().toString());
        outState.putInt("operacion",operacion);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        respuesta.setText(savedInstanceState.getString("respuesta"));
        operacion=savedInstanceState.getInt("operacion");
    }

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.suma:
                if (checked)
                    operacion=1;
                    break;
            case R.id.resta:
                if (checked)
                    operacion=2;
                    break;
            case R.id.mult:
                if (checked)
                    operacion=3;
                    break;
            case R.id.div:
                if (checked)
                    operacion=4;
                    break;
        }
    }

    public void mostrar(View view){
        float a=0,b,c;
        DecimalFormat df = new DecimalFormat("0.00");

        if(TextUtils.isEmpty(op1.getText()) || TextUtils.isEmpty(op2.getText())){
            Toast.makeText(getBaseContext(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
        }else{
            a=Float.parseFloat(op1.getText().toString());
            b=Float.parseFloat(op2.getText().toString());

            switch (operacion){
                case 1:
                        c = (a + b);
                        //s = String.valueOf(c);
                        s = df.format(c);
                        respuesta.setText(s);
                        break;
                case 2:
                        c = (a - b);
                       // s = String.valueOf(c);
                        s = df.format(c);
                        respuesta.setText(s);
                        break;
                case 3:
                        c = (a * b);
                       // s = String.valueOf(c);
                        s = df.format(c);
                        respuesta.setText(s);
                        break;
                case 4:
                        c = (a / b);
                        //s = String.valueOf(c);
                        s = df.format(c);
                        respuesta.setText(s);
                        break;
                default:
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.toastoperacion), Toast.LENGTH_SHORT).show();
                        break;
            }
        }
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
