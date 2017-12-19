package tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


    @Autowired
    private TESTService TESTService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<TEST> rows = TESTService.getAll();
        model.addAttribute("rows", rows);
        return "mainPage";
    }

    @RequestMapping(value = "/addRow", method = RequestMethod.GET)
    public String add(@RequestParam(value = "f1", required = true) char f1,
                      @RequestParam(value = "f2", required = true) char f2,
                      @RequestParam(value = "f3", required = true) char f3,
                      Model model) {
        TEST row = new TEST();
        row.setF1(f1);
        row.setF2(f2);
        row.setF3(f3);
        TESTService.create(row);
        List<TEST> rows = TESTService.getAll();
        model.addAttribute("rows", rows);
        return "mainPage";
    }

    @RequestMapping(value = "/deleteRow", method = RequestMethod.DELETE)
    public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) {
        TESTService.delete(id);
        List<TEST> rows = TESTService.getAll();
        model.addAttribute("rows", rows);
        return "mainPage";
    }

    @RequestMapping(value = "/updateRow", method = RequestMethod.POST)
    public String update(@RequestParam(value = "id", required = true) int id,
                         @RequestParam(value = "f1", required = true) char f1,
                         @RequestParam(value = "f2", required = true) char f2,
                         @RequestParam(value = "f3", required = true) char f3,
                         Model model) {
        TEST row = new TEST();
        row.setF1(f1);
        row.setF2(f2);
        row.setF3(f3);
        row.setId(id);
        TESTService.update(row);
        List<TEST> rows = TESTService.getAll();
        model.addAttribute("rows", rows);
        return "mainPage";
    }
}
