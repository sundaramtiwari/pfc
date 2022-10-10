package com.pfc.IBANValidator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator implements IValidator {

    private final Pattern pattern;
    public RegexValidator(String format) {
        pattern = Pattern.compile(format);
    }

    @Override
    public boolean isValid(String code) {
        Matcher matcher = pattern.matcher(code);
        return matcher.matches();
    }
}
