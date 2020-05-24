package learn.zno.znostudy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import learn.zno.znostudy.TotalStats.DateDb.DateDbStats;
import learn.zno.znostudy.TotalStats.DateDb.methodDbDate;
import learn.zno.znostudy.TotalStats.StatsDb.DateDbTotalStats;
import learn.zno.znostudy.TotalStats.StatsDb.methodDbTotalStats;

public class DBHelpers extends SQLiteOpenHelper implements methodDb, methodDbTotalStats, methodDbDate {

    // Database Name
    private static final String DATABASE_NAME = "DBHelpers";

    // Todo table create zno
    private static final String CREATE_TABLE_ZNO =
            "CREATE TABLE questionZNO (id INTEGER PRIMARY KEY NOT NULL, " +
                    "questions VARCHAR(255) NOT NULL , " +
                    "answ1 VARCHAR(255) NOT NULL , " +
                    "answ2 VARCHAR(255) , " +
                    "answ3 VARCHAR(255) , " +
                    "answ4 VARCHAR(255) , " +
                    "answ5 VARCHAR(255)); ";


    // Todo table create total statistics
    private static final String CREATE_TABLE_STATISTICS =
            "CREATE TABLE totalStatistics (idText  VARCHAR(50) PRIMARY KEY NOT NULL , " +
                    "typeTest VARCHAR(50) NOT NULL , " +
                    "statsTest VARCHAR(50) NOT NULL , " +
                    "dateTest VARCHAR(50) NOT NULL , " +
                    "CountAnswers int Not Null , " +
                    "startSize int Not Null, " +
                    "endSize int Not Null );  ";

    // Todo table create total statistics
    private static final String CREATE_TABLE_DATE_STATISTICS =
            "CREATE TABLE dateTotalStatistics (id INTEGER PRIMARY KEY NOT NULL , " +
                    "Questions VARCHAR(50) NOT NULL , " +
                    "YourAnswer VARCHAR(50) NOT NULL , " +
                    "RightAnswer VARCHAR(50) NOT NULL); ";


    public DBHelpers(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(CREATE_TABLE_ZNO);
       db.execSQL(CREATE_TABLE_STATISTICS);
       db.execSQL(CREATE_TABLE_DATE_STATISTICS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists questionZNO");
        db.execSQL("drop table if exists totalStatistics");
        db.execSQL("drop table if exists dateTotalStatistics");
        onCreate(db);
    }


    //TODO Add Date in a BD for test
    @Override
    public void addData(DateDb dateDb) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("id", dateDb.getId());
            values.put("questions", dateDb.getQuestion());
            values.put("answ1", dateDb.getAnswer1());
            values.put("answ2", dateDb.getAnswer2());
            values.put("answ3", dateDb.getAnswer3());
            values.put("answ4", dateDb.getAnswer4());
            values.put("answ5", dateDb.getAnswer5());

            db.insert("questionZNO", null, values);
            db.close();
        } catch (SQLiteException e) {
            db.close();
            e.printStackTrace();
        }
    }

    @Override
    public DateDb getDate(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("questionZNO", new String[] { "id",
                        "questions", "answ1", "answ2" , "answ3", "answ4", "answ5" }, "id" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        DateDb dateDb = null;
        if (cursor != null) {
            dateDb = new DateDb(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return dateDb;
    }

    @Override
    public List<DateDb> getAllContacts() {
        List<DateDb> datelist = new ArrayList<DateDb>();
        String selectQuery = "SELECT  * FROM " + "questionZNO";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DateDb date = new DateDb();
                date.setId(Integer.parseInt(cursor.getString(0)));
                date.setQuestion(cursor.getString(1));
                date.setAnswer1(cursor.getString(2));
                date.setAnswer2(cursor.getString(3));
                date.setAnswer3(cursor.getString(4));
                date.setAnswer4(cursor.getString(5));
                date.setAnswer5(cursor.getString(6));
                datelist.add(date);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return datelist;
    }

    //TODO Add Date for statistics
    @Override
    public void addDataTotalStats(DateDbTotalStats dateDb) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("idText", dateDb.getIdText());
            values.put("typeTest", dateDb.getTypeTest());
            values.put("statsTest", dateDb.getStatsTest());
            values.put("dateTest", dateDb.getDateTest());
            values.put("CountAnswers", dateDb.getCountAnswers());
            values.put("startSize", dateDb.getStartSize());
            values.put("endSize", dateDb.getEndSize());

            db.insert("totalStatistics", null, values);
            db.close();
        } catch (SQLiteException e) {
            db.close();
            e.printStackTrace();
        }
    }

    @Override
    public DateDbTotalStats getDateTotalStats(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("totalStatistics", new String[] { "idText",
                        "typeTest", "statsTest", "dateTest" , "CountAnswers", "startSize", "endSize" }, "idText" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        DateDbTotalStats dateDb = null;
        if (cursor != null) {
            dateDb = new DateDbTotalStats(cursor.getString(0),cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6));
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return dateDb;
    }

    @Override
    public List<DateDbTotalStats> getAllTotalStats() {
        List<DateDbTotalStats> datelist = new ArrayList<DateDbTotalStats>();
        String selectQuery = "SELECT  * FROM " + "totalStatistics";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DateDbTotalStats date = new DateDbTotalStats();
                date.setIdText(cursor.getString(0));
                date.setTypeTest(cursor.getString(1));
                date.setStatsTest(cursor.getString(2));
                date.setDateTest(cursor.getString(3));
                date.setCountAnswers(cursor.getInt(4));
                date.setStartSize(cursor.getInt(5));
                date.setEndSize(cursor.getInt(6));

                datelist.add(date);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return datelist;
    }

    @Override
    public void deleteDateTotalStats(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {

            String[] args = new String[]{id};
            db.delete("totalStatistics", "idText" + "=?", args);

            db.close();
        } catch (SQLiteException e) {
            db.close();
            e.printStackTrace();
        }
    }


    //TODO Add Date inside Statistics
    @Override
    public void addDataInStats(DateDbStats dateDb) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("id", dateDb.getId());
            values.put("Questions", dateDb.getQuestion());
            values.put("YourAnswer", dateDb.getYourAnswer());
            values.put("RightAnswer", dateDb.getRightAnswer());

            db.insert("dateTotalStatistics", null, values);
            db.close();
        } catch (SQLiteException e) {
            db.close();
            e.printStackTrace();
        }

    }

    @Override
    public DateDbStats getDateFromStats(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("dateTotalStatistics", new String[] { "id",
                        "Questions", "YourAnswer", "RightAnswer" }, "id" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        DateDbStats dateDb = null;
        if (cursor != null) {
            dateDb = new DateDbStats(cursor.getInt(0),cursor.getString(1), cursor.getString(2),cursor.getString(3));
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return dateDb;
    }

    @Override
    public List<DateDbStats> getAllDateFromStats() {
        List<DateDbStats> datelist = new ArrayList<DateDbStats>();
        String selectQuery = "SELECT  * FROM " + "dateTotalStatistics";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DateDbStats date = new DateDbStats();
                date.setId(cursor.getInt(0));
                date.setQuestion(cursor.getString(1));
                date.setYourAnswer(cursor.getString(2));
                date.setRightAnswer(cursor.getString(3));

                datelist.add(date);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return datelist;
    }

    @Override
    public void deleteDateFromStats(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.delete("dateTotalStatistics", "id" + "=?", new String[]{String.valueOf(id)});

            db.close();
        } catch (SQLiteException e) {
            db.close();
            e.printStackTrace();
        }

    }

}
