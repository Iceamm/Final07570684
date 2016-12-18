package com.example.afinal;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Login";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Login";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "c_name_th";
    public static final String COL_UNAME = "c_uname_en";
    public static final String COL_PASSWORD= "c_password_en";

    private static final String SQL_CRATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_UNAME + " TEXT, "
                    + COL_PASSWORD + " TEXT"
                    + ")";


    public DataBaseHelper(Context context, String databaseName, Object o, int databaseVersion) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRATE_TABLE);

        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv1 = new ContentValues();
        cv1.put(COL_NAME, "Android studio");
        cv1.put(COL_UNAME, "android");
        cv1.put(COL_PASSWORD, "123456");
        db.insert(TABLE_NAME, null, cv1);

        ContentValues cv2 = new ContentValues();
        cv2.put(COL_NAME, "Promlert Lovichit");
        cv2.put(COL_UNAME, "promlert");
        cv2.put(COL_PASSWORD, "456789");
        db.insert(TABLE_NAME, null, cv2);


        ContentValues cv3 = new ContentValues();
        cv3.put(COL_NAME, "Mark Zuckerberg");
        cv3.put(COL_UNAME, "markz");
        cv2.put(COL_PASSWORD, "789012");
        db.insert(TABLE_NAME, null, cv3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");
        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");

        onCreate(_db);
    }

}