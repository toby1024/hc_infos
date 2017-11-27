package work.variety.hc_infos.controller;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import work.variety.hc_infos.entity.Info;
import work.variety.hc_infos.entity.InfoCategoryEnum;
import work.variety.hc_infos.entity.User;
import work.variety.hc_infos.service.InfoService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    @RequestMapping(path = "/infos/send", method = RequestMethod.GET)
    public String send() {
        return "infos/send";
    }

    @RequestMapping(path = "/infos/send", method = RequestMethod.POST)
    public String send(String title, Model model) {
        return "infos/index";
    }

    @RequestMapping(path = "/infos/ask", method = RequestMethod.GET)
    public String ask() {
        return "infos/ask";
    }

    @RequestMapping(path = "/infos/ask", method = RequestMethod.POST)
    public String ask(@RequestParam(name = "title") String title,
                      @RequestParam(name = "description") String description,
                      Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Info info = infoService.createOne(user, title, description, InfoCategoryEnum.REQUEST);
        Page<Info> infoPage = infoService.findMy(0, user);
        model.addAttribute("infoPage", infoPage);
        return "infos/index";
    }

}
