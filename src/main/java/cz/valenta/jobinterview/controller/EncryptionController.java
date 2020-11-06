package cz.valenta.jobinterview.controller;

import cz.valenta.jobinterview.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptionController {

    @Autowired
    private EncryptionService encryptionService;

    @GetMapping("/encrypt")
    public String encrypt(@RequestParam("text") String text) {
        return encryptionService.encrypt(text);
    }
}
