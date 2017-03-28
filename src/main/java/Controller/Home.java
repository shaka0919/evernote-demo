package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Wang Zhe on 2017/3/28.
 */
@Controller
public class Home {
    @RequestMapping("/home")
    public String Home() {
        return "home";
    }
}
