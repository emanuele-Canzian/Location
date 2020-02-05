package com.example.SpringSecurityConfigurationBasicAuth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BasicAuthenticationController {
    @GetMapping(path= "/basicauth")
    public AuthenticationBean helloWorldBean(){
        return new AuthenticationBean("You are authicated");
    }
    @GetMapping(path="/hello-world/path-variable/{name}")
    public AuthenticationBean helloWorldPathVariable(@PathVariable String name){
        //throw new RuntimeException("Something went wrong")
        return  new AuthenticationBean(String.format("Hello,World, %s",name));
    }

}
