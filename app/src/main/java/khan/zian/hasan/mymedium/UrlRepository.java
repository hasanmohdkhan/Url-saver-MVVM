package khan.zian.hasan.mymedium;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import khan.zian.hasan.mymedium.dao.UrlDAO;
import khan.zian.hasan.mymedium.database.UrlDatabase;
import khan.zian.hasan.mymedium.model.UrlModel;

public class UrlRepository {
    private UrlDAO urlDAO;
    private LiveData<List<UrlModel>> allUrls;

    public UrlRepository(Application application){
        UrlDatabase database = UrlDatabase.getInstance(application);
        urlDAO = database.urlDAO();
        allUrls = urlDAO.getAllUrls();
    }

    public void insert(UrlModel urlModel){
        new InsertUrlAsyncTask(urlDAO).execute(urlModel);
    }

    public void update(UrlModel urlModel){
        new UpdateUrlAsyncTask(urlDAO).execute(urlModel);
    }

    public void delete(UrlModel urlModel){
        new DeleteUrlAsyncTask(urlDAO).execute(urlModel);
    }

    public void deleteAll(){
        new DeleteAllUrlUrlAsyncTask(urlDAO).execute();
    }

    public LiveData<List<UrlModel>> getAllUrls(){
        return allUrls;
    }

    private static class InsertUrlAsyncTask extends AsyncTask<UrlModel,Void,Void>{
        private UrlDAO urlDAO;

        InsertUrlAsyncTask(UrlDAO urlDAO) {
            this.urlDAO = urlDAO;
        }

        @Override
        protected Void doInBackground(UrlModel... urlModels) {
            urlDAO.insert(urlModels[0]);
            return null;
        }
    }

    private static class UpdateUrlAsyncTask extends AsyncTask<UrlModel,Void,Void>{
        private UrlDAO urlDAO;

        UpdateUrlAsyncTask(UrlDAO urlDAO) {
            this.urlDAO = urlDAO;
        }

        @Override
        protected Void doInBackground(UrlModel... urlModels) {
            urlDAO.update(urlModels[0]);
            return null;
        }
    }

    private static class DeleteUrlAsyncTask extends AsyncTask<UrlModel,Void,Void>{
        private UrlDAO urlDAO;

        DeleteUrlAsyncTask(UrlDAO urlDAO) {
            this.urlDAO = urlDAO;
        }

        @Override
        protected Void doInBackground(UrlModel... urlModels) {
            urlDAO.delete(urlModels[0]);
            return null;
        }
    }

    private static class DeleteAllUrlUrlAsyncTask extends AsyncTask<Void,Void,Void>{
        private UrlDAO urlDAO;

        DeleteAllUrlUrlAsyncTask(UrlDAO urlDAO) {
            this.urlDAO = urlDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            urlDAO.deleteAll();
            return null;
        }
    }


}
