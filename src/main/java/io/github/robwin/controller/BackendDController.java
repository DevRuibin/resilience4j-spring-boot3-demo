package io.github.robwin.controller;


import io.github.robwin.service.BackendDService;
import io.github.robwin.service.Service;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/backendD")
public class BackendDController {

    @Resource(name = "backendDService")
    private Service service;

    @GetMapping("success")
    public String success(){
        return service.success();
    }
}
