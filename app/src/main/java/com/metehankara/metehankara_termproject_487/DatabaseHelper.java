package com.metehankara.metehankara_termproject_487;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME="CustomerDB";
    private static int  DATABASE_VERSION = 1;

    SQLiteDatabase db;

    public DatabaseHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        db= getWritableDatabase();//Wirtable and Readable mode

        Log.d("DATABASE OPERATIONS","Connection Provided");
    }

    public void close(){
        if(db != null)
            db.close();//Wirtable and Readable mode
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //onCreate called if database doesn't exist
        try {
            sqLiteDatabase.execSQL(CustomerDB.CREATE_TABLE_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        Log.d("DATABASE OPERATIONS","OnCreate, table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //onUpgrade called ven DATABASE_VERSION is changed
        //SQLiteDatabase object used to execute SQL statements
        try {
            sqLiteDatabase.execSQL(CustomerDB.DROP_TABLE_SQL);

        }catch (SQLException e){
            e.printStackTrace();
        }
        onCreate(sqLiteDatabase);
        Log.d("DATABASE OPERATIONS","onUpgrade,  table dropped, old version "+oldVersion+" new version "+newVersion);
    }
    public Cursor getAllRecords(String tableName, String[] columns   ){

        Cursor cursor = db.query(tableName, columns, null, null, null, null, null );

        Log.d("DATABASE OPERATIONS", "GET THE RECORDS");
        return cursor;
    }
    public Cursor getAllRecordsMethod2(String sql , String...where){
        Cursor cursor = db.rawQuery("select * from "+CustomerDB.TABLE_NAME,where);
        Log.d("DATABASE OPERATIONS", "GET THE RECORDS");

        return cursor;
    }

    public Cursor getSomeRecords( String tableName, String[] columns,String where ){
        Cursor cursor = db.query(tableName, columns, where, null, null, null, null);
        Log.d("DATABASE OPERATIONS", "GET ALL RECORDS WITH WHERE CLAUSE");

        return cursor;
    }
    public long insert( String tableName, ContentValues contentValues){
        //ContentValues  allows to define key value pairs.
        //The key represents the table column identifier and the value represents the content for the table record in this column.
        //ContentVales can be used for insert and update operations over table
        Log.d("DATABASE OPERATIONS", "INSERT DONE");

        return db.insert(tableName, null, contentValues);
    }
    public boolean update( String tableName, ContentValues contentValues, String whereCondition){
        //ContentValues  allows to define key value pairs.
        //The key represents the table column identifier and the value represents the content for the table record in this column.
        //ContentVales can be used for insert and update operations over table
        Log.d("DATABASE OPERATIONS", "UPDATE DONE");

        return db.update(tableName,contentValues,whereCondition,null)>0;
    }
    public boolean delete(  String tableName, String whereCondition){
        Log.d("DATABASE OPERATIONS", "DELETE DONE");
        return db.delete(tableName, whereCondition, null)>0;
    }
}
