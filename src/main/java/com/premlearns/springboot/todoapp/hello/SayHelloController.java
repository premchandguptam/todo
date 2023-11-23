package com.premlearns.springboot.todoapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// since we are using web ui based bean we use @Controller annotation
@Controller
public class SayHelloController {


    /*@RequestMapping annotation is to specify the url for the page and @response body is to
    * give the Response body to the request */
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHellohtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<body>");
        sb.append("My first html");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    //META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("say-hello-jsp")

    public String sayHellojsp(){

        // return string should always be same as the jsp file name
        // for eg here META-INF/resources/WEB-INF/jsp/sayHello.jsp is
        // jsp file name for the request mapping say-hello-jsp
        // spring.mvc.view will resolve the path for the jsop with
        // spring.mvc.view.prefix and suffix
        return "sayHello";

    }
}
