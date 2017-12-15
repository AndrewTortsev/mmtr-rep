package tutorial;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private TESTService TESTService;

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public String getAccounts(Model model) {
        logger.debug("received get request");
        List<TEST> days = TESTService.getAll();
        model.addAttribute("days", days);
        return "dayspage";
    }

    @RequestMapping(value = "/a/g", method = RequestMethod.GET)
    public String getAccount(@RequestParam(value = "id", required = true) Integer id, Model model) {
        logger.debug("received get by id request");
        model.addAttribute("day", TESTService.get(id));
        return "daysbyidpage";
    }
}
