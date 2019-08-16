package khan.zian.hasan.mymedium.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medium_url")
public class UrlModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String url;
    private String title;
    private String description;

    public UrlModel(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
