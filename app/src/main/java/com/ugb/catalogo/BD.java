package com.ugb.catalogo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {
    public static final String dbname="db_agenda";
    public static final int v=1;

    static final String sqlDbAgenda = "CREATE TABLE agenda(idAgenda integer primary key autoincrement, nombre text, direccion text, telefono text, email text, urlfoto text)";
    static final String sqlDbAdidas = "CREATE TABLE adidas(idAdidas integer primary key autoincrement, nombre text, descripcion text, talla text, precio real, urlfoto text)";

    public BD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, v);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlDbAgenda);
        sqLiteDatabase.execSQL(sqlDbAdidas);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public String administrar_agenda(String id, String nom, String dir, String tel, String em, String urlfoto,  String accion) {
        try{
            SQLiteDatabase db = getWritableDatabase();
            if(accion.equals("nuevo")){
                db.execSQL("INSERT INTO agenda(nombre,direccion,telefono,email, urlfoto) VALUES('"+nom+"','"+dir+"','"+tel+"','"+em+"','"+urlfoto+"')");
            } else if (accion.equals("modificar")) {
                db.execSQL("UPDATE agenda SET nombre='"+nom+"', direccion='"+dir+"', telefono='"+tel+"', email='"+em+"', urlfoto='"+urlfoto+"' WHERE idAgenda='"+id+"'");
            }else if(accion.equals("eliminar")){
                db.execSQL("DELETE FROM agenda WHERE idAgenda='"+id+"'");
            }



            return "ok";
        }catch (Exception e){
            return "Error: "+ e.getMessage();
        }
    }

    public Cursor consultar_agenda(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM agenda ORDER BY nombre";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    public String administrar_adidas(String id, String nom, String dir, String tel, String em, String urlfoto,  String accion) {
        try{
            SQLiteDatabase db = getWritableDatabase();
            if(accion.equals("nuevo")){
                db.execSQL("INSERT INTO agenda(nombre,direccion,telefono,email, urlfoto) VALUES('"+nom+"','"+dir+"','"+tel+"','"+em+"','"+urlfoto+"')");
            } else if (accion.equals("modificar")) {
                db.execSQL("UPDATE agenda SET nombre='"+nom+"', direccion='"+dir+"', telefono='"+tel+"', email='"+em+"', urlfoto='"+urlfoto+"' WHERE idAdidas='"+id+"'");
            }else if(accion.equals("eliminar")){
                db.execSQL("DELETE FROM adidas WHERE idAdidas='"+id+"'");
            }



            return "ok";
        }catch (Exception e){
            return "Error: "+ e.getMessage();
        }

    }
    public Cursor consultar_adidas(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM agenda ORDER BY nombre";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

}
