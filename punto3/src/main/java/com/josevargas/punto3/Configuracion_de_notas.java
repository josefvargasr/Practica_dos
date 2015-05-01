package com.josevargas.punto3;

import android.content.Intent;
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


public class Configuracion_de_notas extends ActionBarActivity {

    EditText pquices, pexpo, ppracticas, pproyecto;

    Button bsetporcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_de_notas);

        pquices=(EditText)findViewById(R.id.epquices);
        pexpo=(EditText) findViewById(R.id.epexpo);
        ppracticas=(EditText) findViewById(R.id.eppracticas);
        pproyecto=(EditText) findViewById(R.id.epproyecto);
        bsetporcentaje=(Button) findViewById(R.id.bsetporcentaje);

        Bundle extras=getIntent().getExtras();

        pquices.setHint(String.valueOf(extras.getInt("pQuiz") + "%"));
        pexpo.setHint(String.valueOf(extras.getInt("pExpo") + "%"));
        ppracticas.setHint(String.valueOf(extras.getInt("pPrac") + "%"));
        pproyecto.setHint(String.valueOf(extras.getInt("pProy") + "%"));
    }



    public void porcentaje (View view){
        int a,b,c,d,e;
        if(TextUtils.isEmpty(pquices.getText()) || TextUtils.isEmpty(pexpo.getText()) || TextUtils.isEmpty(ppracticas.getText()) || TextUtils.isEmpty(pproyecto.getText())){
            Toast.makeText(getBaseContext(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
        }else{
            a=Integer.parseInt(pquices.getText().toString());
            b=Integer.parseInt(pexpo.getText().toString());
            c=Integer.parseInt(ppracticas.getText().toString());
            d=Integer.parseInt(pproyecto.getText().toString());
            e = a+b+c+d;
            if(e==100){
                Intent i = new Intent();
                i.putExtra("prQuiz", pquices.getText().toString());
                i.putExtra("prExpo", pexpo.getText().toString());
                i.putExtra("prPrac", ppracticas.getText().toString());
                i.putExtra("prProy", pproyecto.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }else{
                Toast.makeText(getBaseContext(), "Los porcentajes no coinciden!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_configuracion_de_notas, menu);
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
