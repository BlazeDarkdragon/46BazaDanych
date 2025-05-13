package com.example.a46bazadanych;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Asystent extends SQLiteOpenHelper {

    public Asystent(Context context) {
        super(context, "szkola.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase bd1) {
        bd1.execSQL("CREATE TABLE UCZEN (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "IMIE TEXT, " +
                "NAZWISKO TEXT, " +
                "KLASA TEXT, " +
                "WIEK INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd1, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            bd1.execSQL("ALTER TABLE UCZEN ADD COLUMN WIEK INTEGER;");
        }
    }

    public void dodaj(String imie, String nazwisko, String klasa, int wiek) {
        SQLiteDatabase bd1 = getWritableDatabase();
        ContentValues dane = new ContentValues();
        dane.put("IMIE", imie);
        dane.put("NAZWISKO", nazwisko);
        dane.put("KLASA", klasa);
        dane.put("WIEK", wiek);
        bd1.insertOrThrow("UCZEN", null, dane);
    }

    public Cursor wypiszCalosc() {
        SQLiteDatabase bd1 = getReadableDatabase();
        return bd1.rawQuery("SELECT * from UCZEN", null);
    }

    public int policz() {
        SQLiteDatabase bd1 = getReadableDatabase();
        String licznik = "SELECT count(*) FROM UCZEN";
        Cursor kursor2 = bd1.rawQuery(licznik, null);
        kursor2.moveToFirst();
        int ilosc = kursor2.getInt(0);
        kursor2.close();
        return ilosc;
    }
}




