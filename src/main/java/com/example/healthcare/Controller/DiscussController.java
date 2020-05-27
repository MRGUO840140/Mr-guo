package com.example.healthcare.Controller;

import com.example.healthcare.bean.Discuss;
import com.example.healthcare.mapper.DiscussMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName:
 * @Author Mr GuoQing
 * @Date: 2020/4/17 20:56
 * @Description:
 */
@Controller
public class DiscussController {

    @Autowired
    private DiscussMapper discussMapper;

    //@GetMapping("/new_file")
    //public String new_file(){
    //    return "new_file";
    //}

    @GetMapping("/new_file_one")
    public String new_file_one(){
        return "new_file_one";
    }


    @GetMapping("/Discuss/getAll")
    public String getAll(Model model){
        List<Discuss> discusses = discussMapper.selectAll();
       discusses.stream().forEach(discuss -> discuss.Cut(discuss.getText()));
        model.addAttribute("discusses",discusses);
        return "new_file";
    }

    @GetMapping("/Discuss/queryById/{id}")
    public String queryById(@PathVariable Long id, Model model){
        Discuss discuss = discussMapper.selectById(id);
        model.addAttribute("dicuss",discuss);
        System.out.println(discuss);
        return "new_file_one";
    }
}
