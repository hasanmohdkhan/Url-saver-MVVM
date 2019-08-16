package khan.zian.hasan.mymedium.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import khan.zian.hasan.mymedium.model.UrlModel;

@Dao
public interface UrlDAO {

    @Insert
    void insert(UrlModel urlModel);

    @Update
    void update(UrlModel urlModel);

    @Delete
    void delete(UrlModel urlModel);

    @Query("DELETE from medium_url")
    void deleteAll();

    @Query("SELECT * FROM medium_url")
    LiveData<List<UrlModel>> getAllUrls();

}

