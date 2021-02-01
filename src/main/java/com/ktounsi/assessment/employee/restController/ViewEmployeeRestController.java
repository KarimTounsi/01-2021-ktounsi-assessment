package com.ktounsi.assessment.employee.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
public class ViewEmployeeRestController {


    @RequestMapping("/")
    public ModelAndView viewInstitutions() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view");
        return modelAndView;
    }


}
