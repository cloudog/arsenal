package online.zxff.arsenal.sso.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    //spring拦截器加载在springcontentText之前，所以这里用@Bean提前加载。否则会导致过滤器中的@AutoWired注入为空

    @Bean
    SSOInterceptor getSsoInterceptor(){
        return new SSOInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("JWT拦截器启动");
        registry.addInterceptor(getSsoInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login",
                        "/api/login")
                ;
    }
}
