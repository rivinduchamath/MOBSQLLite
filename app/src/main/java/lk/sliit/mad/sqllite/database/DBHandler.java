package lk.sliit.mad.sqllite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserProfile.Users.TABLE_NAME + " (" +
                    UserProfile.Users._ID + " INTEGER PRIMARY KEY," +
                    UserProfile.Users.COLUMN_1 + " TEXT," +
                    UserProfile.Users.COLUMN_2 + " TEXT," +
                    UserProfile.Users.COLUMN_3 + " TEXT," +
                    UserProfile.Users.COLUMN_4 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserProfile.Users.TABLE_NAME;


    public long addInfo(String name, String dob, String password, String gender) {
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(UserProfile.Users.COLUMN_1, name);
        values.put(UserProfile.Users.COLUMN_2, dob);
        values.put(UserProfile.Users.COLUMN_3, password);
        values.put(UserProfile.Users.COLUMN_4, gender);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(UserProfile.Users.TABLE_NAME, null, values);
        return newRowId;
    }

    public Boolean updateInfo(String name, String dob, String password, String gender) {
        SQLiteDatabase db = getWritableDatabase();

        // New value for one column

        ContentValues values = new ContentValues();
        values.put(UserProfile.Users.COLUMN_2, dob);
        values.put(UserProfile.Users.COLUMN_3, password);
        values.put(UserProfile.Users.COLUMN_4, gender);

        // Which row to update, based on the title
        String selection = UserProfile.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { name };

        int count = db.update(
                UserProfile.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count >= 1;
    }

    public void deleteInfo(String userName) {

        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = UserProfile.Users.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = {"MyTitle"};
        // Issue SQL statement.
        int deletedRows = db.delete(UserProfile.Users.TABLE_NAME, selection, selectionArgs);

    }

public List getInfo(){
        String userName ="Gimmy";
    SQLiteDatabase db = getReadableDatabase();

    // Define a projection that specifies which columns from the database
    // you will actually use after this query.
    String[] projection = {
            BaseColumns._ID,
            UserProfile.Users.COLUMN_1,
            UserProfile.Users.COLUMN_2,
            UserProfile.Users.COLUMN_3,
            UserProfile.Users.COLUMN_4
    };

// Filter results WHERE "title" = 'My Title'
    String selection = UserProfile.Users.COLUMN_1 + " = ?";
    String[] selectionArgs = { userName };

// How you want the results sorted in the resulting Cursor
    String sortOrder =
            UserProfile.Users.COLUMN_1 + " ASE";

    Cursor cursor = db.query(
            UserProfile.Users.TABLE_NAME,   // The table to query
            projection,             // The array of columns to return (pass null to get all)
           null,
            null,     // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            sortOrder               // The sort order
    );
    List userNames = new ArrayList<>();
    while(cursor.moveToNext()) {
        String user = cursor.getString(
                cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_1));
        userNames.add(user);
    }
    cursor.close();
return userNames;

}
}
