package io.github.web.thymeleaf;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

    private String sharedInfo;

    @RequestMapping(value = "/processFormSession")
    public ModelAndView processForm(@RequestParam String info,
            HttpSession sesion) {

        sesion.setAttribute("userInfo", info);
        sharedInfo = info;
        return new ModelAndView("info_session");
    }

    @RequestMapping("/showDataSession")
    public ModelAndView showData(HttpSession session) {
        String userInfo = (String) session.getAttribute("userInfo");

        return new ModelAndView("data_session").addObject("userInfo", userInfo)
                .addObject("sharedInfo", sharedInfo);
    }

}
