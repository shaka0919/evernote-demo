package Service;

import Model.NoteBookModel;
import Model.NoteModel;
import com.evernote.auth.EvernoteAuth;
import com.evernote.auth.EvernoteService;
import com.evernote.clients.ClientFactory;
import com.evernote.clients.NoteStoreClient;
import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.notestore.NoteList;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.NoteSortOrder;
import com.evernote.edam.type.Notebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang Zhe on 2017/3/27.
 */
public class EvernoteHelper {
    private String AUTH_TOKEN = "S=s1:U=937c5:E=16265570c4c:C=15b0da5ded0:P=1cd:A=en-devtoken:V=2:H=439fbc4bf42f91edd8edcb84687c69c2";
    private static EvernoteHelper ourInstance;
    private NoteStoreClient noteStore;

    public static EvernoteHelper getInstance() throws Exception {
        if (ourInstance == null) {
            ourInstance = new EvernoteHelper();
        }
        return ourInstance;
    }

    private EvernoteHelper() throws Exception {
        EvernoteAuth evernoteAuth = new EvernoteAuth(EvernoteService.SANDBOX, AUTH_TOKEN);
        ClientFactory factory = new ClientFactory(evernoteAuth);
        noteStore = factory.createNoteStoreClient();
    }

    public String GetNoteContent(String guid) throws Exception {
        try {
            Note note = noteStore.getNote(guid, true, false, false, false);
            String content = note.getContent();
            int start = content.indexOf("<en-note>");
            int end = content.indexOf("</en-note>");
            String result = content.substring(start + 9, end);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public List<NoteBookModel> GetNoteList() throws Exception {
        List<Notebook> notebooks = noteStore.listNotebooks();
        List<NoteBookModel> result = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            NoteFilter filter = new NoteFilter();
            filter.setNotebookGuid(notebook.getGuid());
            filter.setOrder(NoteSortOrder.CREATED.getValue());
            filter.setAscending(true);
            NoteList noteList = noteStore.findNotes(filter, 0, 100);
            List<Note> notes = noteList.getNotes();

            List<NoteModel> notelist = new ArrayList<>();
            for (Note note : notes) {
                System.out.println(note.getTitle());
                notelist.add(new NoteModel(note.getGuid(), note.getTitle()));
            }
            result.add(new NoteBookModel(notebook.getName(), notelist));
        }
        return result;
    }
}
