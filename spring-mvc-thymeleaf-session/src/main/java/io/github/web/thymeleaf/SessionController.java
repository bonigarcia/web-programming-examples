package io.github.web.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

    private String sharedInfo;
    private User user;

    public SessionController(User user) {
        this.user = user;
    }

    @RequestMapping(value = "/")
    public ModelAndView processForm() {
        return new ModelAndView("home_page");
    }

    @RequestMapping(value = "/processFormSession")
    public ModelAndView processForm(@RequestParam String info) {
        user.setInfo(info);
        sharedInfo = info;
        return new ModelAndView("info_session");
    }

    @RequestMapping("/showDataSession")
    public ModelAndView showData() {
        String userInfo = user.getInfo();
        return new ModelAndView("data_session").addObject("userInfo", userInfo)
                .addObject("sharedInfo", sharedInfo);
    }
}
