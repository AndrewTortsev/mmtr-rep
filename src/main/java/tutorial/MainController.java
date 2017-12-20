package tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("rows", TESTService.getAll());
        return mv;
    }

    @RequestMapping(value = "/addRow", method = RequestMethod.GET)
    public @ResponseBody
    String add(ParamsModel paramsModel) throws Exception {
        TEST row = new TEST();
        row.setF1(paramsModel.getF1());
        row.setF2(paramsModel.getF2());
        row.setF3(paramsModel.getF3());
        return TESTService.create(row).getJson();
    }

    @RequestMapping(value = "/deleteRow", method = RequestMethod.GET)
    public @ResponseBody
    String delete(ParamsModel paramsModel) throws Exception {
        return TESTService.delete(paramsModel.getId()).getJson();
    }

    @RequestMapping(value = "/updateRow", method = RequestMethod.GET)
    public @ResponseBody
    String update(ParamsModel paramsModel) throws Exception {
        TEST row = new TEST();
        row.setF1(paramsModel.getF1());
        row.setF2(paramsModel.getF2());
        row.setF3(paramsModel.getF3());
        row.setId(paramsModel.getId());
        return TESTService.update(row).getJson();
    }
}
