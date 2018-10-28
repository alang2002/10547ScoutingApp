package com.example.sir_acolyte.scoutingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {
    DBHandler database;
    public DBAdapter (Context context) {
        database = new DBHandler(context);
    }

    public void addEntry(EntryInfo entry) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHandler.KEY_TEAMNAME, entry.getTeamName());
        values.put(DBHandler.KEY_TEAMNUMBER, entry.getTeamNumber());
        values.put(DBHandler.KEY_GAMENUMBER, entry.getGameNumber());
        values.put(DBHandler.KEY_ALLIANCECOLOR, entry.getAllianceColor());
        values.put(DBHandler.KEY_TOTALSCORE, entry.getTotalScore());
        values.put(DBHandler.KEY_LANDED, entry.getLandedString());
        values.put(DBHandler.KEY_CLAIMED_DEPOT, entry.getLandedString());
        values.put(DBHandler.KEY_PARKED_AUTO, entry.getParkedAutoString());
        values.put(DBHandler.KEY_SAMPLING, entry.getSampledString());
        values.put(DBHandler.KEY_MINERALDEPOT, entry.getMineralDepot());
        values.put(DBHandler.KEY_MINERALLANDER, entry.getMineralLander());
        values.put(DBHandler.KEY_HANGED, entry.getHangedString());
        values.put(DBHandler.KEY_PARKED_PARTIAL, entry.getParkedPartialString());
        values.put(DBHandler.KEY_PARKED_FULL, entry.getParkedFullString());
        db.insert(DBHandler.TABLE_NAME, null, values);
        db.close();
    }

    public EntryInfo getEntry(int id) {
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.query(DBHandler.TABLE_NAME, new String[] {DBHandler.KEY_ID,
        DBHandler.KEY_TEAMNAME, DBHandler.KEY_TEAMNUMBER, DBHandler.KEY_GAMENUMBER,
        DBHandler.KEY_ALLIANCECOLOR, DBHandler.KEY_TOTALSCORE, DBHandler.KEY_LANDED,
        DBHandler.KEY_CLAIMED_DEPOT, DBHandler.KEY_PARKED_AUTO, DBHandler.KEY_SAMPLING,
        DBHandler.KEY_MINERALDEPOT, DBHandler.KEY_MINERALLANDER, DBHandler.KEY_HANGED,
        DBHandler.KEY_PARKED_PARTIAL, DBHandler.KEY_PARKED_FULL}, DBHandler.KEY_ID + "=?",
                new String[]{String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        EntryInfo entry = new EntryInfo(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
                cursor.getInt(3), cursor.getString(4), cursor.getInt(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getInt(10),
                cursor.getInt(11), cursor.getString(12), cursor.getString(13), cursor.getString(14));
        cursor.close();
        return entry;
    }

    public int getEntriesCount() {
        String countQuery = "SELECT * FROM " + DBHandler.TABLE_NAME;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();
    }

    public List<EntryInfo> getAllEntries() {
        List<EntryInfo> entryList = new ArrayList<EntryInfo>();
        String selectQuery = "SELECT * FROM " + DBHandler.TABLE_NAME;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                EntryInfo entry = new EntryInfo(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
                        cursor.getInt(3), cursor.getString(4), cursor.getInt(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getInt(10),
                        cursor.getInt(11), cursor.getString(12), cursor.getString(13), cursor.getString(14));
                entryList.add(entry);
            } while (cursor.moveToNext());
        }
        return entryList;
    }

    public void updateEntry(EntryInfo entry) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHandler.KEY_TEAMNAME, entry.getTeamName());
        values.put(DBHandler.KEY_TEAMNUMBER, entry.getTeamNumber());
        values.put(DBHandler.KEY_GAMENUMBER, entry.getGameNumber());
        values.put(DBHandler.KEY_ALLIANCECOLOR, entry.getAllianceColor());
        values.put(DBHandler.KEY_TOTALSCORE, entry.getTotalScore());
        values.put(DBHandler.KEY_LANDED, entry.getLandedString());
        values.put(DBHandler.KEY_CLAIMED_DEPOT, entry.getLandedString());
        values.put(DBHandler.KEY_PARKED_AUTO, entry.getParkedAutoString());
        values.put(DBHandler.KEY_SAMPLING, entry.getSampledString());
        values.put(DBHandler.KEY_MINERALDEPOT, entry.getMineralDepot());
        values.put(DBHandler.KEY_MINERALLANDER, entry.getMineralLander());
        values.put(DBHandler.KEY_HANGED, entry.getHangedString());
        values.put(DBHandler.KEY_PARKED_PARTIAL, entry.getParkedPartialString());
        values.put(DBHandler.KEY_PARKED_FULL, entry.getParkedFullString());
        db.update(DBHandler.TABLE_NAME, values, DBHandler.KEY_ID + " = ?",
                new String[]{String.valueOf(entry.getId())});
    }

    public void deleteEntry(EntryInfo entry) {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete(DBHandler.TABLE_NAME, DBHandler.KEY_ID + " = ? ", new String[]{
                String.valueOf(entry.getId())});
        db.close();
    }

    static class DBHandler extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "ScoutingAppDatabase";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME = "Entries";
        private static final String KEY_ID = "ID";
        private static final String KEY_TEAMNAME = "TeamName";
        private static final String KEY_TEAMNUMBER = "TeamNumber";
        private static final String KEY_GAMENUMBER = "GameNumber";
        private static final String KEY_ALLIANCECOLOR = "AllianceColor";
        private static final String KEY_TOTALSCORE = "TotalScore";
        private static final String KEY_LANDED = "Landed";
        private static final String KEY_CLAIMED_DEPOT = "ClaimedDepot";
        private static final String KEY_PARKED_AUTO = "ParkedInAutonomous";
        private static final String KEY_SAMPLING = "Sampling";
        private static final String KEY_MINERALDEPOT = "MineralsFromDepot";
        private static final String KEY_MINERALLANDER = "MineralsFromLander";
        private static final String KEY_HANGED = "HangedFromLander";
        private static final String KEY_PARKED_PARTIAL = "ParkedPartial";
        private static final String KEY_PARKED_FULL = "ParkedFull";
        public static final String CREATE_ENTRIES_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + KEY_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_TEAMNAME + " TEXT, " + KEY_TEAMNUMBER + " INTEGER, " + KEY_GAMENUMBER + " INTEGER, "
                + KEY_ALLIANCECOLOR + " TEXT, " + KEY_TOTALSCORE + " INTEGER, " + KEY_LANDED + " TEXT, "
                + KEY_CLAIMED_DEPOT + " TEXT, " + KEY_PARKED_AUTO + " TEXT, " + KEY_SAMPLING + " TEXT, "
                + KEY_MINERALDEPOT + " INTEGER, " + KEY_MINERALLANDER + " INTEGER, " + KEY_HANGED + " TEXT, "
                + KEY_PARKED_PARTIAL + " TEXT, " + KEY_PARKED_FULL + " TEXT" + ")";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public DBHandler(Context context) {
            super(context, DATABASE_NAME , null, DATABASE_VERSION);
            this.context = context;
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_ENTRIES_TABLE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }
}