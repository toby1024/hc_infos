package work.variety.hc_infos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import work.variety.hc_infos.entity.Info;
import work.variety.hc_infos.service.InfoService;

@Controller
public class InfoController {
    @Autowired
    private InfoService infoService;

    @RequestMapping("index")
    public String index(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Info> infoPage = infoService.findAll(page);
        model.addAttribute("infoPage", infoPage);
        return "infos/index";
    }
}
