package com.example.pokemoncardapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    // https://www.digitalocean.com/community/tutorials/android-sqlite-database-example-tutorial

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String cardNum, String series, String _lang, String name, String cardType, int evolution, int normalArt, int holo, int reverseHolo, int fullHolo, int v, int ex, int gx) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.cardNum, cardNum);
        contentValue.put(DatabaseHelper.series, series);
        contentValue.put(DatabaseHelper._lang, _lang);

        contentValue.put(DatabaseHelper.name, name);
        contentValue.put(DatabaseHelper.type, cardType);
        contentValue.put(DatabaseHelper.evolution, evolution);

        contentValue.put(DatabaseHelper.normalArt, normalArt);
        contentValue.put(DatabaseHelper.holo, holo);
        contentValue.put(DatabaseHelper.reverse, reverseHolo);
        contentValue.put(DatabaseHelper.full, fullHolo);
        contentValue.put(DatabaseHelper.v, v);
        contentValue.put(DatabaseHelper.ex, ex);
        contentValue.put(DatabaseHelper.gx, gx);




        database.insert(DatabaseHelper.tableName, null, contentValue);
    }
}
