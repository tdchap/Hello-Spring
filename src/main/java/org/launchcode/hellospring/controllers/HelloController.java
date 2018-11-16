package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

@Controller
public class HelloController {
    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "little critter";
        }
            return "Hello " + name;
    }
    @RequestMapping(value = "customname", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='formmy' />" +
                "<input type='submit' value='Submission'>" +
                "</form>";
        return html;
    }
    @RequestMapping(value = "customname", method= RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){

        String joshua = request.getParameter("formmy");
        if (joshua == "") {
            joshua = "Secret Agent";
        }
        return "Hello " + joshua;

    }
    @RequestMapping(value = "customname/{fall}")
    @ResponseBody
    public String helloURLSegment(@PathVariable String fall){
        return "Hello " + fall;
    }

    @RequestMapping(value = "signingoff")

    public String goodbye() {
    }
}
