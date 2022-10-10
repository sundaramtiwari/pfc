package com.pfc.IBANValidator.validator;

/**
 * The Validator class that contains the information required to validate the format of an IBAN.
 * As per wikipedia: <a href="https://en.wikipedia.org/wiki/International_Bank_Account_Number#Structure">...</a>>
 * IBAN consists of up to 34 alphanumeric characters, as follows:
 * country code using ISO 3166-1 alpha-2 – two letters,
 * check digits – two digits, and
 * Basic Bank Account Number (BBAN) – up to 30 alphanumeric characters that are country-specific.
 * <p>
 * So, if we consider a minimum of 4 characters for BBAN, we can consider 8 as absolute minimum for IBAN.
 * Maximum number of characters is limited to 34.
 */
public class Validator {
    private static final int MIN_LEN = 8;
    private static final int MAX_LEN = 34;
    private final String countryCode;
    private final RegexValidator regexValidator;
    private final int lengthOfIBAN; // used to avoid unnecessary regex matching

    /**
     * Creates the validator
     *
     * @param cc     the country code
     * @param len    the length of the IBAN
     * @param format the regex to use to check the format
     */
    public Validator(String cc, int len, String format) {
        if (!(cc.length() == 2 && Character.isUpperCase(cc.charAt(0)) && Character.isUpperCase(cc.charAt(1)))) {
            throw new IllegalArgumentException("Invalid country Code; must be exactly 2 upper-case characters");
        }
        if (len > MAX_LEN || len < MIN_LEN) {
            throw new IllegalArgumentException("Invalid length parameter, must be in range " + MIN_LEN + " to " + MAX_LEN + " inclusive: " + len);
        }
        if (!format.startsWith(cc)) {
            throw new IllegalArgumentException("countryCode '" + cc + "' does not agree with format: " + format);
        }
        this.countryCode = cc;
        this.regexValidator = new RegexValidator(format);
        this.lengthOfIBAN = len;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public RegexValidator getRegexValidator() {
        return regexValidator;
    }

    public int getLengthOfIBAN() {
        return lengthOfIBAN;
    }
}