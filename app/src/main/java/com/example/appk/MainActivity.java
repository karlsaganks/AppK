package com.example.appk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.appk.beans.Empleado;
import com.example.appk.beans.Empresa;
import com.example.appk.beans.Fichaje;
import com.example.appk.controlador.DB;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private DB bdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdd = new DB(this);

        //   bdd.open();
        Empresa em = new Empresa("B123456","XYZYZ SA","T T","xyz@xyz.com");
        //boolean v = DB.empresaDao.nuevo(em);
        ArrayList<Empresa> ae = (ArrayList<Empresa>) DB.empresaDao.getEmpresas();
        //em = DB.empresaDao.ultimo();

        Log.i("APPK", "u: "+ em);

        Empleado tr = new Empleado("JUAN YONG 2","JYON3","12345","B", false, em);
        //boolean t = DB.empleadoDao.nuevo(tr);
        ArrayList<Empleado> at = (ArrayList<Empleado>) DB.empleadoDao.getEmpleados();

        tr = DB.empleadoDao.ultimo();
        Log.i("APPK", "E: "+tr);
        for(Empleado es : at){
            Log.i("APPK", "= "+es);
        }
         at = (ArrayList<Empleado>) DB.empleadoDao.getEmpleados();

        Timestamp de = new Timestamp(new Date().getTime());
        Timestamp hasta = new Timestamp(new Date().getTime());

        Fichaje fe = new Fichaje(tr, de, hasta, "Mensaje");
        Log.i("APPK", "F: "+fe);
        boolean d = DB.fichajeDao.nuevo(fe);
        ArrayList<Fichaje> af = (ArrayList<Fichaje>) DB.fichajeDao.getFicheje(tr.getId_empleado());

        for(Fichaje es : af){
            Log.i("APPK", "= "+es);
        }

//        ArrayList<String> rol = (ArrayList<String>) DB.empleadoDao.getRoles();
 //       for(String es : rol){
  //          Log.i("APPK", "R:: "+es);
  //      }
  //      bdd.close();
    }
}
