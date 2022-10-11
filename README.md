# PFC
## IBAN Validator

The IBAN Validator is developed with the business logic gathered from:
https://en.wikipedia.org/wiki/International_Bank_Account_Number
https://www.iban.com/structure

**What is an IBAN**

The International Bank Account Number (IBAN) is an internationally agreed system of identifying bank accounts across national borders.

**Validating the IBAN**

An IBAN is validated by converting it into an integer and performing a basic mod-97 operation (as described in ISO 7064) on it. 
If the IBAN is valid, the remainder equals 1. The algorithm of IBAN validation is as follows:

1. Check that the total IBAN length is correct as per the country. If not, the IBAN is invalid
2. Move the four initial characters to the end of the string
3. Replace each letter in the string with two digits, thereby expanding the string, where A = 10, B = 11, ..., Z = 35
4. Interpret the string as a decimal integer and compute the remainder of that number on division by 97
5. If the remainder is 1, the check digit test is passed and the IBAN might be valid.

Note: The project expects IBAN alphabetical characters to be uppercase. However, any extra spaces in between IBAN characters are trimmed.

Example (fictitious United Kingdom bank, sort code 12-34-56, account number 98765432):

* IBAN: GB82 WEST 1234 5698 7654 32
* Rearrange: W E S T12345698765432 G B82
* Convert to integer: 3214282912345698765432161182
* Compute remainder: 3214282912345698765432161182	mod 97 = 1


### HOW TO RUN

Run `mvn clean install` from project root to generate the jar file at location: 
    `target/IBANValidator-$version.jar`

Next, to build the docker image, execute below command from project root:

`$> docker build --tag=ibanvalidator:latest .`


Run Docker Container:

`$> docker run -p8080:8080 ibanvalidator:latest`

Health Check:

`curl localhost:8080/ping`

IBAN Validation Endpoint:

`curl -X POST 'http://localhost:8080/validate?iban=<IBAN>'`