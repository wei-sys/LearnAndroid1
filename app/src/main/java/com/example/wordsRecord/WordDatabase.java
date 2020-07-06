package com.example.wordsRecord;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//singleton
@Database(entities = {Word.class}, version = 5, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase INSTANCE;

    static synchronized WordDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word_database")
                    //.fallbackToDestructiveMigration()  //直接摧毀整個數據庫重建
                    .build();
        }
        return INSTANCE;
    }

    public abstract WordDao getWordDao();
}
