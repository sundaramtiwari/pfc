package com.pfc.IBANValidator.controller;

import com.pfc.IBANValidator.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IBANController {

    @Autowired
    @Qualifier("iBanValidator")
    IValidator iBanValidator;

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public String validate(@RequestParam("iban") String iban) {
        boolean isValid = iBanValidator.isValid(iban);
        return "Provided IBAN: " + iban + " validity: " + isValid;
    }
}
