package com.example.healthcare.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JisuController {
    @RequestMapping("/user/jisu")
    public String jisu(){
        return "consultation";
    }
}
