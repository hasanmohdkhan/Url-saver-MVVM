package khan.zian.hasan.mymedium.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import khan.zian.hasan.mymedium.dao.UrlDAO;
import khan.zian.hasan.mymedium.model.UrlModel;

@Database(entities = {UrlModel.class}, version = 1)
public abstract class UrlDatabase extends RoomDatabase {
    private static UrlDatabase instance;

    public abstract UrlDAO urlDAO();

    public static synchronized UrlDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UrlDatabase.class, "url_database").
                    fallbackToDestructiveMigration().addCallback(callback).build();
        }
        return instance;
    }


    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        /**
         * Called when the database is created for the first time. This is called after all the
         * tables are created.
         *
         * @param db The database.
         */
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UrlDAO urlDAO;

        PopulateDbAsyncTask(UrlDatabase db) {
            urlDAO = db.urlDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            urlDAO.insert(new UrlModel("www.medium.com", " new Medium article", "NA"));
            urlDAO.insert(new UrlModel("www.google.com", " new google article", "NA"));
            urlDAO.insert(new UrlModel("www.dev.io", " new dev article", "NA"));

            return null;
        }
    }
}
