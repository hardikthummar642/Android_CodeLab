package com.devfest.androidcodelab.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.devfest.androidcodelab.Model.User;

import java.util.logging.Level;

/**
 * @author: Kioko
 * @description: This class handles is responsible for creating and upgrading the DataBase.
 *
 */


public class DataBaseHelper extends SQLiteOpenHelper {


    //Declaration of Variables
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "devFest";
    public static final String TABLE_NAME = "devFestUsers";

    //Column Values
    public static final String ID = "id";
    public static final String FULL_NAMES = "fullNames";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    //Constructor

    /**
     *
     * @param context
     */
    public DataBaseHelper(Context context){
        /**
         * @param context : This is the context of the current state of the object/application
         * @param DATABASE_NAME : Name of the DataBase
         * @param CursorFactory
         * @param Version : This is the Database Version
         */
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

     //Create the Database Table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //SQL create command
        String CREATE_DEVFEST_USERS = "CREATE TABLE " + TABLE_NAME + ID + "INTEGER PRIMARY KEY," + FULL_NAMES + "TEXT, "
                + PHONE_NUMBER + "TEXT, " + EMAIL + "TEXT, " + PASSWORD + "TEXT" + ")";

        //Execute the Command
        sqLiteDatabase.execSQL(CREATE_DEVFEST_USERS);
    }

     //This method is called when the created DataBase is being upgraded
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        //Drop the older table if is exists
        String DROP_TABLE =  "DROP TABLE IF EXISTS" + TABLE_NAME;
        sqLiteDatabase.execSQL(DROP_TABLE);

        //Log the Data
        RunTimeLog.log(RunTimeLog.INFO, Constants.DATABASE_UPGRADE);

        //Create the Table Again
        onCreate(sqLiteDatabase);
    }

    /**
     * SQL CRUD Functions
     */

    //Add New User
    public void createUser(User userDetails){

    }

    // Update Contacts
    public void updateContacts(User userDetails){

    }

    //Delete User
    public void deleteUser(User userDetails){

    }

}
