package com.pfc.IBANValidator.validator;

public class IBANFormats {

    /**
     * The following formats are taken as per examples shared in: <a href="https://www.iban.com/structure">...</a>
     * sorted by country code. Need to confirm the formats in case digits can also have characters and vice versa.
     */
    static final Validator[] DEFAULT_FORMATS = {
            new Validator("AD", 24, "AD\\d{22}"), // Andorra
            new Validator("AE", 23, "AE\\d{21}"), // United Arab Emirates
            new Validator("AL", 28, "AL\\d{26}"), // Albania
            new Validator("AT", 20, "AT\\d{18}"), // Austria
            new Validator("AZ", 28, "AZ\\d{2}[A-Z]{4}\\d{20}"), // Azerbaijan
            new Validator("BA", 20, "BA\\d{18}"), // Bosnia and Herzegovina
            new Validator("BE", 16, "BE\\d{14}"), // Belgium
            new Validator("BG", 22, "BG\\d{2}[A-Z]{4}\\d{14}"), // Bulgaria
            new Validator("BH", 22, "BH\\d{2}[A-Z]{4}\\d{14}"), // Bahrain
            new Validator("BI", 27, "BI\\d{25}"), // Burundi
            new Validator("BR", 29, "BR\\d{25}[A-Z]{1}\\d{1}"), // Brazil
            new Validator("BY", 28, "BY\\d{2}[A-Z]{4}\\d{20}"), // Belarus
            new Validator("CH", 21, "CH\\d{19}"), // Switzerland
            new Validator("CR", 22, "CR\\d{20}"), // Costa Rica
            new Validator("CY", 28, "CY\\d{26}"), // Cyprus
            new Validator("CZ", 24, "CZ\\d{22}"), // Czech Republic
            new Validator("DE", 22, "DE\\d{20}"), // Germany
            new Validator("DK", 18, "DK\\d{16}"), // Denmark
            new Validator("DO", 28, "DO\\d{2}[A-Z]{4}\\d{20}"), // Dominican Republic
            new Validator("EE", 20, "EE\\d{18}"), // Estonia
            new Validator("ES", 24, "ES\\d{22}"), // Spain
            new Validator("FI", 18, "FI\\d{16}"), // Finland
            new Validator("FO", 18, "FO\\d{16}"), // Denmark (Faroes)
            new Validator("FR", 27, "FR\\d{25}"), // France
            new Validator("GB", 22, "GB\\d{2}[A-Z]{4}\\d{14}"), // United Kingdom
            new Validator("GE", 22, "GE\\d{2}[A-Z]{2}\\d{16}"), // Georgia
            new Validator("GI", 23, "GI\\d{2}[A-Z]{4}\\d{15}"), // Gibraltar
            new Validator("GL", 18, "GL\\d{16}"), // Denmark (Greenland)
            new Validator("GR", 27, "GR\\d{25}"), // Greece
            new Validator("GT", 28, "GT\\d{2}[A-Z]{4}\\d{20}"), // Guatemala
            new Validator("HR", 21, "HR\\d{19}"), // Croatia
            new Validator("HU", 28, "HU\\d{26}"), // Hungary
            new Validator("IE", 22, "IE\\d{2}[A-Z]{4}\\d{14}"), // Ireland
            new Validator("IL", 23, "IL\\d{21}"), // Israel
            new Validator("IS", 26, "IS\\d{24}"), // Iceland
            new Validator("IT", 27, "IT\\d{2}[A-Z]{1}\\d{22}"), // Italy
            new Validator("IQ", 23, "IQ\\d{2}[A-Z]{4}\\d{15}"), // Iraq
            new Validator("JO", 30, "JO\\d{2}[A-Z]{4}\\d{22}"), // Jordan
            new Validator("KW", 30, "KW\\d{2}[A-Z]{4}\\d{22}"), // Kuwait
            new Validator("KZ", 20, "KZ\\d{18}"), // Kazakhstan
            new Validator("LB", 28, "LB\\d{26}"), // Lebanon
            new Validator("LC", 32, "LC\\d{2}[A-Z]{4}\\d{24}"), // Saint Lucia
            new Validator("LI", 21, "LI\\d{19}"), // Liechtenstein
            new Validator("LT", 20, "LT\\d{18}"), // Lithuania
            new Validator("LU", 20, "LU\\d{18}"), // Luxembourg
            new Validator("LV", 21, "LV\\d{2}[A-Z]{4}\\d{13}"), // Latvia
            new Validator("MC", 27, "MC\\d{25}"), // Monaco
            new Validator("ME", 22, "ME\\d{20}"), // Montenegro
            new Validator("MK", 19, "MK\\d{17}"), // North Macedonia
            new Validator("MR", 27, "MR\\d{25}"), // Mauritania
            new Validator("MT", 31, "MT\\d{2}[A-Z]{4}\\d{23}"), // Malta
            new Validator("MU", 30, "MU\\d{2}[A-Z]{4}\\d{19}[A-Z]{3}"), // Mauritius
            new Validator("NL", 18, "NL\\d{2}[A-Z]{4}\\d{10}"), // The Netherlands
            new Validator("NO", 15, "NO\\d{13}"), // Norway
            new Validator("PK", 24, "PK\\d{2}[A-Z]{4}\\d{16}"), // Pakistan
            new Validator("PL", 28, "PL\\d{26}"), // Poland
            new Validator("PS", 29, "PS\\d{2}[A-Z]{4}\\d{21}"), // Palestine
            new Validator("PT", 25, "PT\\d{23}"), // Portugal
            new Validator("QA", 29, "QA\\d{2}[A-Z]{4}\\d{21}"), // Qatar
            new Validator("RO", 24, "RO\\d{2}[A-Z]{4}\\d{16}"), // Romania
            new Validator("RS", 22, "RS\\d{20}"), // Serbia
            new Validator("SA", 24, "SA\\d{22}"), // Saudi Arabia
            new Validator("SC", 31, "SC\\d{2}[A-Z]{4}\\d{20}[A-Z]{3}"), // Seychelles
            new Validator("SE", 24, "SE\\d{22}"), // Sweden
            new Validator("SI", 19, "SI\\d{17}"), // Slovenia
            new Validator("SK", 24, "SK\\d{22}"), // Slovak Republic
            new Validator("SM", 27, "SM\\d{2}[A-Z]{1}\\d{22}"), // San Marino
            new Validator("ST", 25, "ST\\d{23}"), // Sao Tome and Principe
            new Validator("TL", 23, "TL\\d{21}"), // Timor-Leste
            new Validator("TN", 24, "TN\\d{22}"), // Tunisia
            new Validator("TR", 26, "TR\\d{24}"), // Turkey
            new Validator("UA", 29, "UA\\d{27}}"), // Ukraine
            new Validator("VA", 22, "VA\\d{20}}"), // Holy See
            new Validator("VG", 24, "VG\\d{2}[A-Z]{4}\\d{16}"), // Virgin Islands, British
            new Validator("XK", 20, "XK\\d{18}}"), // Kosovo
    };
}
