package com.pfc.IBANValidator.validator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Qualifier("iBanValidator")
public class IBANValidator implements IValidator {

    private static final BigInteger NINETY_SEVEN = BigInteger.valueOf(97);

    private final Map<String, Validator> formatValidators;

    /**
     * Create a default IBAN validator.
     */
    public IBANValidator() {
        this(IBANFormats.DEFAULT_FORMATS);
    }

    /**
     * Create an IBAN validator from the specified map of IBAN formats.
     *
     * @param formatMap map of IBAN formats
     */
    public IBANValidator(Validator[] formatMap) {
        Map<String, Validator> countryCodeValidatorMap = new ConcurrentHashMap<>();
        for (Validator v : formatMap) {
            countryCodeValidatorMap.put(v.getCountryCode(), v);
        }
        this.formatValidators = countryCodeValidatorMap;
    }

    /**
     * Validate an IBAN Code.
     * As per wiki:
     * <a href="https://en.wikipedia.org/wiki/International_Bank_Account_Number#Algorithms">Validating the IBAN</a>
     * The algorithm of IBAN validation is as follows:
     * Check that the total IBAN length is correct as per the country. If not, the IBAN is invalid
     * Move the four initial characters to the end of the string
     * Replace each letter in the string with two digits, thereby expanding the string, where A = 10, B = 11, ..., Z = 35
     * Interpret the string as a decimal integer and compute the remainder of that number on division by 97
     * If the remainder is 1, the check digit test is passed and the IBAN might be valid.
     *
     * @param iban The value validation is being performed on
     * @return <code>true</code> if the value is valid
     */
    @Override
    public boolean isValid(String iban) {
        if (iban == null) {
            return false;
        }

        iban = iban.replaceAll("\\s+", ""); // Remove unnecessary spaces if present

        Validator formatValidator = getValidator(iban);

        if (formatValidator == null
                || iban.length() != formatValidator.getLengthOfIBAN()
                || !formatValidator.getRegexValidator().isValid(iban)) {
            return false;
        }

        String reformattedCode = iban.substring(4) + iban.substring(0, 4);
        StringBuilder numericIban = new StringBuilder();

        for (int i = 0; i < reformattedCode.length(); i++) {
            numericIban.append(Character.getNumericValue(reformattedCode.charAt(i)));
        }

        return new BigInteger(numericIban.toString()).mod(NINETY_SEVEN).equals(BigInteger.ONE);
    }

    /**
     * Get the Validator for a given IBAN
     *
     * @param code a string starting with the ISO country code (e.g. an IBAN)
     * @return the validator or {@code null} if there is not one registered.
     */
    private Validator getValidator(String code) {
        if (code == null || code.length() < 2) { // ensure we can extract the code
            return null;
        }
        String key = code.substring(0, 2);
        return formatValidators.get(key);
    }

}
