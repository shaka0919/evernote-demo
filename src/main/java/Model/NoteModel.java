package Model;

/**
 * Created by ZX on 2017/3/28.
 */
public class NoteModel {
    private final String guid;
    private final String title;

    public NoteModel(String guid, String title) {
        this.guid = guid;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getGuid() {
        return guid;
    }
}
