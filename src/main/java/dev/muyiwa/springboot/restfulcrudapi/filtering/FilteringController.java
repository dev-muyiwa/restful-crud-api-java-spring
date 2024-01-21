package dev.muyiwa.springboot.restfulcrudapi.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filters")
public class FilteringController {
    @GetMapping("")
    public SomeBean filtering() {
        return new SomeBean("value 1", "value 2", "value 3");
    }
}
