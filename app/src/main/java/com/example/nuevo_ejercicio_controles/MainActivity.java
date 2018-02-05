package com.example.nuevo_ejercicio_controles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView txt_seleccionspinner, txt_selecciongeneral,txt_final;
    CheckBox cbafavor,cbencontra,cbdentro,cbfuera;
    RadioGroup rgganado;
    Button btn_elementos,btn_sucesos,btn_recopilar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= (Spinner)findViewById(R.id.spinner);

        rgganado= (RadioGroup)findViewById(R.id.radiogroup);

        txt_selecciongeneral= (TextView)findViewById(R.id.txt_selecciongeneral);
        txt_seleccionspinner= (TextView)findViewById(R.id.txt_seleccionspinner);
        txt_final= (TextView)findViewById(R.id.txt_final);

        cbafavor=(CheckBox)findViewById(R.id.cb_favor);
        cbencontra=(CheckBox)findViewById(R.id.cb_contra);
        cbdentro=(CheckBox)findViewById(R.id.cb_dentro);
        cbfuera=(CheckBox)findViewById(R.id.cb_fuera);

        btn_elementos=(Button)findViewById(R.id.btn_elementos);
        btn_sucesos=(Button)findViewById(R.id.btn_sucesos);
        btn_recopilar=(Button)findViewById(R.id.btn_recopilar);





        String [] tipos={"Elige","Ruck","Mele","Touch","Golpe de castigo"};

        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,tipos);

        spinner.setAdapter(adaptador);










    }//Fin ONCREATE


    public void clicktipos (View view){


        String tipoelemento= spinner.getSelectedItem().toString()+" ";

        if(tipoelemento.equals("Elige")){

            Toast.makeText(this,"Elige una opción",Toast.LENGTH_LONG).show();

        }else{

            txt_seleccionspinner.setText(tipoelemento);
            btn_sucesos.setEnabled(true);



        }

    }


    public void  clicksucesos (View view){

        String sucesos="";

        if(cbafavor.isChecked()){
            sucesos+=cbafavor.getText().toString()+" ";
        }

        if(cbencontra.isChecked()){
            sucesos+=cbencontra.getText().toString()+" ";
        }

        if(cbdentro.isChecked()){
            sucesos+=cbdentro.getText().toString()+" ";
        }

        if(cbfuera.isChecked()){
            sucesos+=cbfuera.getText().toString()+" ";
        }

        txt_selecciongeneral.setText(sucesos);

        if(sucesos ==""){
            Toast.makeText(this,"Elige una opción",Toast.LENGTH_LONG).show();
        }

        int idradio=rgganado.getCheckedRadioButtonId();

        if(idradio== -1){ Toast.makeText(this,"¿Fue ganada?",Toast.LENGTH_LONG).show();

        }else{

            RadioButton radioganado= (RadioButton)findViewById(idradio);
            String txt_radioganado= radioganado.getText().toString();
            txt_selecciongeneral.setText(sucesos+ txt_radioganado);


        }

        if(sucesos != ""){

            if(idradio!=-1){
            btn_recopilar.setEnabled(true);
        }
        }else{
            btn_recopilar.setEnabled(false);
        }







    }

    public void clickrecopilacion (View view){

        String txtfinal_spinner= txt_seleccionspinner.getText().toString()+" ";
        String txtfinal_general= txt_selecciongeneral.getText().toString()+" ";
        txt_final.setText(txtfinal_spinner+ txtfinal_general);










    }


}//NO BORRAR
