package com.example.healthcare.Controller;

import com.example.healthcare.Service.CommitService;
import com.example.healthcare.Service.OrdinglistService;
import com.example.healthcare.bean.Commit;
import com.example.healthcare.bean.Ordinglist;
import com.example.healthcare.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommitController {
    @Autowired
    private CommitService commitService;

    @Autowired
    private OrdinglistService ordinglistService;

    @RequestMapping("/user/addCommit")
    @ResponseBody
    public String addCommit(@RequestBody Commit commit, HttpSession session){
        User user = (User)session.getAttribute("user");
        System.out.println(commit);
        commit.setUid(user.getUid());
        commitService.addCommit1(commit);
        return "PersonalCenter";
    }

    @RequestMapping("/user/addCommit2")
    public String addCommit2(HttpServletRequest request){
        HttpSession session=request.getSession();
        User user = (User)session.getAttribute("user");
        String Did=(String) session.getAttribute("Did");
        String Title=request.getParameter("title");
        String Memo=request.getParameter("content");
        String telephone=request.getParameter("phone");
        Commit commit=new Commit(user.getUid(),Did,Title,Memo,telephone);
        commitService.addCommit2(commit);
        int pn=1;
        if(request.getParameter("pn")!=null){
            pn=Integer.parseInt(request.getParameter("pn"));
        }
        System.out.println("pn="+pn);
        com.example.healthcare.bean.PageHelper pageHelper=new com.example.healthcare.bean.PageHelper();
        pageHelper.setCurrentPage(pn);
        int pageSize=4;
        pageHelper.setPageSize(pageSize);
        List<Ordinglist> ords = ordinglistService.getOrdsByPage(user.getUid(),pn,pageSize);
        pageHelper.setListItems(ords);
        int totalPages=ordinglistService.getTotalOrds(user.getUid());
        pageHelper.setTotalPages(totalPages);
        int pageCount=(totalPages%pageSize==0?(totalPages/pageSize):(totalPages/pageSize+1));
        pageHelper.setPageCount(pageCount);
        session.setAttribute("pageHelper",pageHelper);
        List<Commit> tuwenCommits=commitService.selectTuwen(user.getUid());
        session.setAttribute("tuwenCommits",tuwenCommits);
        List<Commit> jisuCommits=commitService.selectJisu(user.getUid());
        session.setAttribute("jisuCommits",jisuCommits);
        return "PersonalCenter";
    }

    @RequestMapping("/user/cancelCommit")
    @ResponseBody
    public Object cancel(Integer CommitId){
        Map<String,Object> map=new HashMap<>();
        System.out.println("订单的id为："+CommitId);
        commitService.deleteCommit(CommitId);
        map.put("msg","取消预约成功");
        // JSONObject result = JSONObject.parseObject(JSON.toJSONString(map.put("msg","取消预约成功")));
        return map;
    }
}
