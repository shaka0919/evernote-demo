package Model;

import java.util.List;

/**
 * Created by ZX on 2017/3/28.
 */
public class NoteBookModel {
    private String name;
    private List<NoteModel> notelist;

    public NoteBookModel(String name, List<NoteModel> noteList) {
        this.name = name;
        this.notelist = noteList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NoteModel> getNotelist() {
        return notelist;
    }

}
