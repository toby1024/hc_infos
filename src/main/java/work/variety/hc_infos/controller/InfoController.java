package work.variety.hc_infos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import work.variety.hc_infos.entity.Info;
import work.variety.hc_infos.service.InfoService;

@Controller
public class InfoController {
    @Autowired
    private InfoService infoService;

    @RequestMapping("/index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Info> infoPage = infoService.findAll(page);
        model.addAttribute("infoPage", infoPage);
        return "infos/index";
    }

    @RequestMapping(path = "/send", method = RequestMethod.GET)
    public String send() {
        return "infos/send";
    }

    @RequestMapping(path = "/send", method = RequestMethod.POST)
    public String send(String title, Model model) {
        return "infos/index";
    }

    @RequestMapping(path = "/ask", method = RequestMethod.GET)
    public String ask() {
        return "infos/ask";
    }

    @RequestMapping(path = "/ask", method = RequestMethod.POST)
    public String ask(@RequestParam(name = "title") String title,
                      @RequestParam(name = "description") String description,
                      Model model) {
        return "infos/index";
    }


}
