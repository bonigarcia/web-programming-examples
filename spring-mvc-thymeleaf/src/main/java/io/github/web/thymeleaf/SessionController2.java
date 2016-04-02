package io.github.web.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController2 {

    @Autowired
    private User user;

    private String sharedInfo;

    @RequestMapping(value = "/processFormSession2")
    public ModelAndView processForm(@RequestParam String info) {
        user.setInfo(info);
        sharedInfo = info;
        return new ModelAndView("info_session2");
    }

    @RequestMapping("/showDataSession2")
    public ModelAndView showData() {
        String userInfo = user.getInfo();
        return new ModelAndView("data_session").addObject("userInfo", userInfo)
                .addObject("sharedInfo", sharedInfo);
    }
}
