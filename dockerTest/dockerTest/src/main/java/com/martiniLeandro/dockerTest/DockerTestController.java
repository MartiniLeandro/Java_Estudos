package com.martiniLeandro.dockerTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerTestController {

    @RequestMapping("/")
    public String grett(){
        return "Hello World";
    }
}
