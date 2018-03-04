package com.yong.location.property;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PropertyController {

    private PropertyService propertyService;

    @GetMapping("/property")
    public String hello(){
        String firstProperty = propertyService.getFirstProperty();
        String secondProperty = propertyService.getSecondProperty();
        return firstProperty.concat(secondProperty);
    }

    @GetMapping("/location")
    public String location(){
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "location";
    }

    @GetMapping("/")
    public String demo(){
        return "Hello World from Location Service!";
    }
}
