package online.zxff.arsenal.simpleweb.controller;

import online.zxff.arsenal.simpleweb.vo.WebResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cloudgo on 2019/7/28 16:14.
 */
@RestController("/")
public class HelloWorldController {
    @RequestMapping("/hello")
    public WebResult helloWorld(){
        return WebResult.builder().code(0).msg("hello world").build();
    }
}
