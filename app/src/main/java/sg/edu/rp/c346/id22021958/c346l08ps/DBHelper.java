package sg.edu.rp.c346.id22021958.c346l08ps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "songs.db";
    private static final String TABLE_SONGS = "songs";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_NAME = "name";
    private static final int COLUMN_YEAR = 0;
    private static final int COLUMN_STARS = 0;

    public void insertSong(String title, String name, int year, int stars){

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_NAME, name);
        values.put(String.valueOf(COLUMN_YEAR), year);
        values.put(String.valueOf(COLUMN_STARS), stars);
        db.close();

    }


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableSql = "CREATE TABLE " + TABLE_SONGS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT," + COLUMN_NAME + "TEXT, " + COLUMN_YEAR + "INTEGER, " + COLUMN_STARS + "INTEGER )";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONGS);
        //create table(s) again
        onCreate(db);
    }

    public ArrayList<String> getSongsContent() {
        // Create an ArrayList that holds String objects
        ArrayList<String> tasks = new ArrayList<String>();
        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_NAME, String.valueOf(COLUMN_YEAR), String.valueOf(COLUMN_STARS)};
        // Run the query and get back the Cursor object
        Cursor cursor = db.query(TABLE_SONGS, columns, null, null, null, null, null, null);

        // moveToFirst() moves to first row, null if no records
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  getString(0) retrieves first column data
                //  getString(1) return second column data
                //  getInt(0) if data is an integer value
                tasks.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return tasks;
    }
    public ArrayList<Songs> getTasks() {
        ArrayList<Songs> tasks = new ArrayList<Songs>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_NAME, String.valueOf(COLUMN_YEAR), String.valueOf(COLUMN_STARS)};
        Cursor cursor = db.query(TABLE_SONGS, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String name = cursor.getString(2);
                int year = cursor.getInt(3);
                int stars = cursor.getInt(4);
                Songs obj = new Songs(id, title, name, year, stars);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }

}
