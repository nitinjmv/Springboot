package dev.jmv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
@ResponseBody
@Slf4j
public class HelloController {

    @GetMapping
    String home() {
        log.debug("Called");
        return "Hello world!";
    }

}
