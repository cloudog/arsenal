package online.zxff.arsenal.sso.interceptor;

import online.zxff.arsenal.sso.util.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by cloudgo on 2019/7/28 21:37.
 */
public class SSOInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许自定义请求头token(允许head跨域)
        // response.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");

        //后台管理页面产生的token
        String token = request.getHeader("authorization");
        if(!StringUtils.isEmpty(token)) {
            try {
                JWTUtils.parseJWT(token);
            } catch (Exception e) {
                redirect(response);
                return false;
            }
        }else{
            redirect(response);
            return false;
        }
        return true;
    }

    protected  void redirect(HttpServletResponse httpServletResponse){
        try {
            httpServletResponse.sendRedirect("/login");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        throw new RuntimeException("token不存在");
    }
}
