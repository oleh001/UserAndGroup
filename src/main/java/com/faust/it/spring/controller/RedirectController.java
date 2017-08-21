package com.faust.it.spring.controller;

import com.faust.it.dao.impl.GroupService;
import com.faust.it.dao.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@Log
public class RedirectController {

    // redirect to index.xhtml
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request,
                                  HttpServletResponse httpServletResponse) {

        return "redirect:" + request.getRequestURL().append("index.xhtml").toString();
    }
}
