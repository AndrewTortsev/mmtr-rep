package tutorial;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/ac", method = RequestMethod.GET)
    public String getDays(Model model) {
        logger.debug("received get request");
        List<Account> days = accountService.getAll();
        model.addAttribute("days", days);
        return "dayspage";
    }

    @RequestMapping(value = "/ac/get", method = RequestMethod.GET)
    public String getDay(@RequestParam(value = "id", required = true) Integer id, Model model) {
        logger.debug("received get by id request");
        model.addAttribute("day", accountService.get(id));
        return "daysbyidpage";
    }
}
