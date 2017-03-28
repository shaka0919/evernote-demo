package Controller;

import Model.NoteBookModel;
import Service.EvernoteHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by Wang Zhe on 2017/3/28.
 */
@Controller
public class Home {
    @RequestMapping("/")
    public String Home(Model model) throws Exception {
        final List<NoteBookModel> noteBookModels = EvernoteHelper.getInstance().GetNoteList();
        model.addAttribute("books", noteBookModels);
        return "home";
    }

    @RequestMapping("/{guid}")
    public String GetNoteContent(@PathVariable String guid, Model model) throws Exception {
        String result = EvernoteHelper.getInstance().GetNoteContent(guid);
        model.addAttribute("content", result);
        return "content";
    }
}
