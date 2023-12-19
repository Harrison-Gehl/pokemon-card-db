package com.example.pokemoncardapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // https://www.digitalocean.com/community/tutorials/android-sqlite-database-example-tutorial

    //database Name
    public static final String dbName = "PokemonDatabase";

    // Table Name
    public static final String tableName = "cards";

    // database version
    static final int dbVersion = 1;

    // columns

    // primary key components
    public static final String cardNum = "card_num";
    public static final String series = "series";
    public static final String _lang = "lang";

    // info
    public static final String name = "pokemon_name";
    public static final String type = "card_type";
    public static final String evolution = "evolution_level";

    // misc atributes
    public static final String normalArt = "normal_art";
    public static final String holo = "holo";
    public static final String reverse = "reverse_holo";
    public static final String full = "full_holo";

    public static final String v = "v";

    public static final String ex = "ex";
    public static final String gx = "gx";


    public DatabaseHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    //create table string
    private static final String createTable =
            "CREATE TABLE " + tableName + "(" +
                    cardNum + " TEXT NOT NULL, " +       //PK attributes
                    series + " TEXT NOT NULL, " +
                    _lang + " TEXT NOT NULL, " +

                    name + " TEXT NOT NULL, " +  // info
                    type + " TEXT NOT NULL, " +
                    evolution + " INTEGER NOT NULL, " +

                    normalArt + " INTEGER NOT NULL, " +  // card attributes
                    holo + " INTEGER NOT NULL, " +
                    reverse + " INTEGER NOT NULL, " +
                    full + " INTEGER NOT NULL, " +
                    v + " INTEGER NOT NULL, " +
                    ex + " INTEGER NOT NULL, " +
                    gx + " INTEGER NOT NULL, " +
                    " PRIMARY KEY (" + cardNum + "," + series + "," + _lang +"));"; // composite key

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(createTable);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }
}
