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


public class MainActivity extends ActionBarActivity {

    EditText quices, practicas,proyecto, expo;
    TextView nota;
    Button bpromediar,babout;
    int p1=10,p2=15,p3=40,p4=35;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, getResources().getString(R.string.toastoncreate), Toast.LENGTH_SHORT).show();

        quices=(EditText)findViewById(R.id.equices);
        expo=(EditText) findViewById(R.id.eexpo);
        practicas=(EditText) findViewById(R.id.epracticas);
        proyecto=(EditText) findViewById(R.id.eproyecto);

        nota=(TextView) findViewById(R.id.tnota);

        bpromediar=(Button) findViewById(R.id.bpromediar);
        babout=(Button) findViewById(R.id.babout);
    }

    public void promedio (View view){
        float a,b,c,d,e;

        if(TextUtils.isEmpty(quices.getText()) || TextUtils.isEmpty(expo.getText()) || TextUtils.isEmpty(practicas.getText()) || TextUtils.isEmpty(proyecto.getText())){
            Toast.makeText(getBaseContext(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
        }else{
            a=Float.parseFloat(quices.getText().toString());
            b=Float.parseFloat(expo.getText().toString());
            c=Float.parseFloat(practicas.getText().toString());
            d=Float.parseFloat(proyecto.getText().toString());
            e = ((a * p1) + (p2 * b) + (p3 * c) + (p4 * d)) / 100;
            String s = String.valueOf(e);
            if(a>5 || b>5 || c>5 || d>5){
                Toast.makeText(getBaseContext(), getResources().getString(R.string.toastmayor5), Toast.LENGTH_SHORT).show();
            }else{
                nota.setText(s);
            }

        }
    }

    public void abrirAbout(View view){
        Intent i=new Intent(this,About.class);
        startActivity(i);
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

        if (id == R.id.menu_about) {
            Intent i=new Intent(this,About.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.menu_configNotas) {
            Intent i=new Intent(this,Configuracion_de_notas.class);
            i.putExtra("pQuiz",p1); //15 es puede ser una variable int
            i.putExtra("pExpo",p2);
            i.putExtra("pPrac",p3);
            i.putExtra("pProy",p4);
            startActivityForResult(i,1234);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("respuesta", nota.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        nota.setText(savedInstanceState.getString("respuesta"));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1234 && resultCode==RESULT_OK){

            p1=Integer.parseInt(data.getExtras().getString("prQuiz"));
            String quiz=data.getExtras().getString("prQuiz");
            p2=Integer.parseInt(data.getExtras().getString("prQuiz"));
            String expos=data.getExtras().getString("prExpo");
            p3=Integer.parseInt(data.getExtras().getString("prQuiz"));
            String prac=data.getExtras().getString("prPrac");
            p4=Integer.parseInt(data.getExtras().getString("prQuiz"));
            String proy=data.getExtras().getString("prProy");

            quices.setHint(data.getExtras().getString("prQuiz") + "%");
            expo.setHint(data.getExtras().getString("prExpo") + "%");
            practicas.setHint(data.getExtras().getString("prPrac") + "%");
            proyecto.setHint(data.getExtras().getString("prProy") + "%");


            //Toast.makeText(this, "Quiz: "+quiz+" Expo: "+expos+" Pract: "+prac+" Proy: "+proy, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onStart() {
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}
