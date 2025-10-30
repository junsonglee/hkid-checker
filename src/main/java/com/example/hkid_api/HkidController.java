package com.example.hkid_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HkidController {

    @GetMapping("/validate")
    public String validate(@RequestParam String hkid) {
        boolean valid = HkidValidator.isValid(hkid);
        return "{ \"hkid\": \"" + hkid + "\", \"valid\": " + valid + " }";
    }
}
