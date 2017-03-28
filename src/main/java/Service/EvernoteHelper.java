package Service;

import com.evernote.auth.EvernoteAuth;
import com.evernote.auth.EvernoteService;
import com.evernote.clients.ClientFactory;
import com.evernote.clients.NoteStoreClient;
import com.evernote.edam.error.EDAMNotFoundException;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.Notebook;
import com.evernote.thrift.TException;

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
        Note note = noteStore.getNote(guid, true, false, false, false);
        if (note != null) {
            return note.getContent();
        } else {
            return null;
        }
    }

    public String GetNoteList() throws Exception {
        List<Notebook> notebooks = noteStore.listNotebooks();
        return null;
    }
}
