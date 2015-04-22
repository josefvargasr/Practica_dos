package com.josevargas.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText quices, expo, practicas,proyecto;
    TextView nota;
    Button bpromediar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quices=(EditText)findViewById(R.id.equices);
        expo=(EditText) findViewById(R.id.eexpo);
        practicas=(EditText) findViewById(R.id.epracticas);
        proyecto=(EditText) findViewById(R.id.eproyecto);

        nota=(TextView) findViewById(R.id.tnota);

        bpromediar=(Button) findViewById(R.id.bpromediar);

    }

    public void promedio (View view){
        float a,b,c,d,e;

        if(TextUtils.isEmpty(quices.getText()) || TextUtils.isEmpty(expo.getText()) || TextUtils.isEmpty(practicas.getText()) || TextUtils.isEmpty(proyecto.getText())){
            Toast.makeText(getBaseContext(), "Faltan campos por llenar!", Toast.LENGTH_SHORT).show();
        }else{
            a=Float.parseFloat(quices.getText().toString());
            b=Float.parseFloat(expo.getText().toString());
            c=Float.parseFloat(practicas.getText().toString());
            d=Float.parseFloat(proyecto.getText().toString());
            e = ((a * 15) + (10 * b) + (40 * c) + (35 * d)) / 100;
            String s = String.valueOf(e);
            nota.setText(s);
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
