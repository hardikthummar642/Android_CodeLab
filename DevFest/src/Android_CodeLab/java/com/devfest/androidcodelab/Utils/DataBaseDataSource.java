package com.devfest.androidcodelab.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.devfest.androidcodelab.Model.User;

import java.sql.SQLException;

/**
 * @author: Kioko
 * @description: This class maintains the connection to the Database and support SQL CRUD Functions
 */


public class DataBaseDataSource {

    //DataBase Fields
    private SQLiteDatabase sqLiteDatabase;
    private DataBaseHelper dataBaseHelper;


    //Constructor
    public DataBaseDataSource(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
    }

    //Enable Write access to the DataBase
    public void openDatabase() throws SQLException {
        dataBaseHelper.getWritableDatabase();
    }

    //Close DataBase Connection
    public void closeConnection() {
        dataBaseHelper.close();
    }

    /**
     * CRUD Functions
     */

    //Add New User
    public void createUser(User userDetails) {

        ContentValues contentValues = new ContentValues();
        //contentValues.put(dataBaseHelper.FULL_NAMES, userDetails.getUserName());

        //Open The DataBase
        try {
            openDatabase();
        } catch (SQLException e) {
            RunTimeLog.log(RunTimeLog.ERROR, Constants.SQLITE_OPENDB_EXCEPTION);
        }
        //Insert Data
        sqLiteDatabase.insert(DataBaseHelper.TABLE_NAME, null, contentValues);
        closeConnection(); //Call the Close Database Method
    }

    // Update Contacts
    public void updateContacts(User userDetails) {

    }

    //Delete User
    public void deleteUser(User userDetails) {

    }

    //Verify User Details (To be used when the User is logging in)
    public void verifyUser(String phoneNumber, String password) {

        String verifyQuery = "Select * FROM " + DataBaseHelper.TABLE_NAME + " WHERE "
                + DataBaseHelper.PHONE_NUMBER + " =  \"" + DataBaseHelper.PASSWORD + "\"";

        Cursor cursor = sqLiteDatabase.rawQuery(verifyQuery, null);

        User userDetails = new User();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();



        }
    }
}
