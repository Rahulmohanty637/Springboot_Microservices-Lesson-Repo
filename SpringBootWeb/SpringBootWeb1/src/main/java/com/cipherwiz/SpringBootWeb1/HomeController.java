package com.cipherwiz.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        System.out.println("home method called");
        return "index";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest req, HttpSession session) {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;
        System.out.println(num1 + " " + num2);
        System.out.println(result);

        session.setAttribute("result", result);

        return "result";
    }

    @RequestMapping("subtract")
    public String sub(@RequestParam("num1") int num, int num2, Model model) {
        int result = num - num2;

        model.addAttribute("subres", result);

        return "result";
    }

    @RequestMapping("product")
    public ModelAndView product(int num1, int num2, ModelAndView mv) {
        int result = num1 * num2;
        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("addAlien")
    public ModelAndView addAlien(@RequestParam("aid") int id, @RequestParam("aname") String name, ModelAndView mv){
        Alien obj = new Alien();
        obj.setAid(id);
        obj.setAname(name);

        mv.addObject("alien", obj);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("addAlien")
    public String addAnotherAlien(Alien alien){
        return "result";
    }
}
