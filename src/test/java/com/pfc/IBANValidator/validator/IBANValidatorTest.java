package com.pfc.IBANValidator.validator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class IBANValidatorTest {

    @Test
    public void shouldValidateIBAN() {
        IValidator ibanValidator = new IBANValidator();
        assertThat(ibanValidator.isValid("AD12 0001 2030 2003 5910 0100")).isTrue();
        assertThat(ibanValidator.isValid("AD12 0001 2030 2003 5910 0102")).isFalse();
        assertThat(ibanValidator.isValid("GB33BUKB20201555555555")).isTrue();
        assertThat(ibanValidator.isValid("QA52NONG124489817324573613521")).isTrue();
        assertThat(ibanValidator.isValid("GB94BARC20201530093459")).isFalse();
        assertThat(ibanValidator.isValid("1200012030")).isFalse();
        assertThat(ibanValidator.isValid("AASDRFFFF")).isFalse();
        assertThat(ibanValidator.isValid("gb33BukB20201555555555")).isFalse();
    }
}
