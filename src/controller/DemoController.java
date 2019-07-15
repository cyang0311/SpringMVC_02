package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class DemoController{
    @RequestMapping("demo")
    public String Demo(String name,String pwd){
        System.out.println("执行控制器");
        System.out.println(name+"      "+pwd);
        return "main";
    }
    @RequestMapping("demo2")
    public String Demo2(User user, HttpServletRequest req){
        HttpSession session = req.getSession();
        session.setAttribute("username",user.getName());
        System.out.println(user.getName()+"   "+user.getPwd());
        return "main";
    }
    @RequestMapping("demo3")
    public String demo3(@RequestParam(value="name") String name, @RequestParam("pwd") String pwd){
        System.out.println(name+"     "+pwd);
        return "main";
    }
    @RequestMapping("demo4")
    public String demo4(@RequestParam(defaultValue ="NAME") String name,@RequestParam(required = true)String pwd){
        System.out.println(name+"   "+pwd);
        return "main";
    }
    @RequestMapping("demo5")
    public String demo5(String name,String pwd,@RequestParam(value="hover")List<String> abc){
        System.out.println(abc);
        return "main";
    }
    @RequestMapping("/demo6/{name}/{pwd}")
    public String demo6(@PathVariable String name,@PathVariable String pwd){
        System.out.println(name+"   "+pwd);

        return "forward:/test";
    }
    @RequestMapping(value = "test",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String test(HttpServletResponse resp) throws IOException {
        System.out.println("test");
        User user = new User("张三","333");
        return "中文";
    }

    @RequestMapping("enter/{method}")
    public String Login(HttpServletRequest request,@PathVariable String method){
        if (request.getSession().getAttribute("user")==null){
            System.out.println("未登录，跳转到login");
            request.getSession().setAttribute("method",method);
            return "login";
        }else{
            System.out.println(method);
            if (method.equals("comment")){
                System.out.println("相等");
                return "forward:/comment";
            }
        }
        return "index";
    }

    @RequestMapping("login")
    public String login(User user,HttpServletRequest request){
        request.getSession().setAttribute("user",user);
        System.out.println(user.getName());
        String method= (String) request.getSession().getAttribute("method");
        return "forward:"+method;
    }

    @RequestMapping("comment")
    @ResponseBody
    public String comment(HttpServletRequest request){
        if (request.getSession().getAttribute("user")==null){

            System.out.println("当前未登录");
            return "222";
        }
        System.out.println("当前登录");
        return "111";
    }
}
