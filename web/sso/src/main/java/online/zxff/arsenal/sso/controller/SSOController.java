package online.zxff.arsenal.sso.controller;

import com.sun.deploy.net.HttpResponse;
import online.zxff.arsenal.sso.util.JWTUtils;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by cloudgo on 2019/7/28 21:52.
 */
@RestController("/")
public class SSOController {

    @RequestMapping("/")
    public String page1(HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getSession().getId());
        return "index page";
    }

    @RequestMapping("/login")
    public String login(HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest){
        String JWT = JWTUtils.createJWT("1", "wangyili", 100000);
        httpServletResponse.addHeader("authorization",JWT);
        httpServletResponse.addCookie(new Cookie("hello","world"));
        httpServletRequest.getSession();
        System.out.println(httpServletRequest.getSession().getId());
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return "this is login page";
    }
}
