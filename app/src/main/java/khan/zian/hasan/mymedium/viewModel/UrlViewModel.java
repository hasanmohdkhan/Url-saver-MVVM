package khan.zian.hasan.mymedium.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import khan.zian.hasan.mymedium.UrlRepository;
import khan.zian.hasan.mymedium.model.UrlModel;

public class UrlViewModel extends AndroidViewModel {
    private UrlRepository repository;
    private LiveData<List<UrlModel>> allUrls;

    public UrlViewModel(@NonNull Application application) {
        super(application);

        repository = new UrlRepository(application);
        allUrls = repository.getAllUrls();
    }

    public void insert(UrlModel urlModel) {
        repository.insert(urlModel);
    }

    public void update(UrlModel urlModel){
        repository.update(urlModel);
    }

    public void delete(UrlModel urlModel){
        repository.delete(urlModel);
    }

    public void deleteAll(){
        repository.deleteAll();
    }
    public LiveData<List<UrlModel>> getAllUrls(){
        return allUrls;
    }
}
