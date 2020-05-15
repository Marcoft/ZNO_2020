package learn.zno.znostudy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelpers extends SQLiteOpenHelper implements methodDb {

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


    public DBHelpers(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(CREATE_TABLE_ZNO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists questionZNO");
        onCreate(db);
    }


    @Override
    public void addData(DateDb dateDb) {
        SQLiteDatabase db = this.getWritableDatabase();
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

        DateDb dateDb = new DateDb(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));

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

        return datelist;
    }
}
