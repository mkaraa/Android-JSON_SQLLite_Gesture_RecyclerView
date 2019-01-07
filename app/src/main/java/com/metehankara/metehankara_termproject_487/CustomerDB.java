package com.metehankara.metehankara_termproject_487;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class CustomerDB {

    public static final String TABLE_NAME="customers";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_SURNAME = "surname";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_CONFIRMPASSWORD = "confirmPassword";
    public static final String FIELD_AGE = "age";
    public static final String FIELD_CITY = "city";
    public static final String FIELD_PROFESSION = "profession";

    public static final String CREATE_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_NAME+" text, "+FIELD_SURNAME+" text, "+FIELD_EMAIL+" text, "
            +FIELD_PASSWORD+" text, "+FIELD_CONFIRMPASSWORD+" text, "+FIELD_AGE+" text, "+FIELD_CITY+" text, "+FIELD_PROFESSION+" text);";
    public static final String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;

    public static List<Customers> getAllContact(DatabaseHelper db){

        Cursor cursor = db.getAllRecords(TABLE_NAME, null);
        //Cursor cursor  db.getAllRecordsMethod2("SELECT * FROM "+TABLE_NAME, null)
        List<Customers> data=new ArrayList<>();
        Customers acontact = null;
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String surname = cursor.getString(1);
            String email = cursor.getString(2);
            String password = cursor.getString(3);
            String confirmpassword = cursor.getString(4);
            String age = cursor.getString(5);
            String city = cursor.getString(6);
            String profession = cursor.getString(7);
            acontact= new Customers(name,surname,email,password,confirmpassword,age,city,profession);
            data.add(acontact);
        }
        return data;
    }

    public static long insertContact(DatabaseHelper db,String name,String surname,String email,String password, String conf, String age, String city, String pro){

        ContentValues contentValues = new ContentValues( );

        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_SURNAME, surname);
        contentValues.put(FIELD_EMAIL, email);
        contentValues.put(FIELD_PASSWORD, password);
        contentValues.put(FIELD_CONFIRMPASSWORD, conf);
        contentValues.put(FIELD_AGE, age);
        contentValues.put(FIELD_CITY, city);
        contentValues.put(FIELD_PROFESSION, pro);


        long res = db.insert(TABLE_NAME,contentValues);
        return res;
    }



    /*
        public static List<Customers> findContact(DatabaseHelper db, String key){

        String where = FIELD_NAME+" like '%"+key+"%'";
        Cursor cursor = db.getSomeRecords(TABLE_NAME,null, where);
        List<Customers> data=new ArrayList<>();
        Customers acontact = null;
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String surname = cursor.getString(1);
            String email = cursor.getString(2);
            String password = cursor.getString(3);
            String confirmpassword = cursor.getString(4);
            String age = cursor.getString(5);
            String city = cursor.getString(6);
            String profession = cursor.getString(7);
            acontact= new Customers(name,surname,email,password,confirmpassword,age,city,profession);
            data.add(acontact);
        }
        return data;
    }

    public static boolean updateContact(DatabaseHelper db, String name,String surname,String email,String password, String conf, String age, String city, String pro){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_SURNAME, surname);
        contentValues.put(FIELD_PASSWORD, password);
        contentValues.put(FIELD_CONFIRMPASSWORD, conf);
        contentValues.put(FIELD_AGE, age);
        contentValues.put(FIELD_CITY, city);
        contentValues.put(FIELD_PROFESSION, pro);

        String where = FIELD_EMAIL +" = "+email;
        boolean res = db.update(TABLE_NAME,contentValues,where);

        return res;
    }
    public static boolean deleteContact(DatabaseHelper db, String email){
        String where = FIELD_EMAIL +" = "+ email;
        boolean res = db.delete(TABLE_NAME,where);
        return res;
    }
*/
}
