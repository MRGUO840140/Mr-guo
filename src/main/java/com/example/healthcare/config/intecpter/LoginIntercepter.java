package com.example.healthcare.config.intecpter;

import com.example.healthcare.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercepter implements HandlerInterceptor {
    /**
     * 进入controller方法之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle----------->");

        String requestURI = request.getRequestURI();

        System.out.println(requestURI+"==========");
        if("/user/register".equals(requestURI)){
            return true;
        }

        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            /*失败*/
            System.out.println("失败");
            return false;
        }else{
            System.out.println("成功");
            return true;
        }

}

    /**
     * 调用完controller之后，试图渲染之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle----------->");

    }

    /**
     * 整个完成之后，通常用于资源清理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion----------->");
    }
}
