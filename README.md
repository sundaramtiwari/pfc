# PFC
IBAN Validator

The IBAN Validator is developed with the business logic gathered from:
https://en.wikipedia.org/wiki/International_Bank_Account_Number
https://www.iban.com/structure

The endpoint chosen is GET for simplicity in testing via curl or browser. 
POST method is recommended for sending the data instead of GET.


**HOW TO RUN**

Run `mvn clean install` from project root to generate the jar file at location: 
    target/IBANValidator-$version.jar

Next, to build the docker image, execute below command from project root:

`$> docker build --tag=ibanvalidator:latest .`


Run Docker Container:

`$> docker run -p8080:8080 ibanvalidator:latest`

