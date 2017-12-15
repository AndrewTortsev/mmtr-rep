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
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private TESTService TESTService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAccounts(Model model) {
        logger.debug("received get request");
        List<TEST> rows = TESTService.getAll();
        model.addAttribute("rows", rows);
        return "rowsPage";
    }

    @RequestMapping(value = "/a/g", method = RequestMethod.GET)
    public String getAccount(@RequestParam(value = "id", required = true) Integer id, Model model) {
        logger.debug("received get by id request");
        model.addAttribute("row", TESTService.get(id));
        return "rowByIdPage";
    }
}
