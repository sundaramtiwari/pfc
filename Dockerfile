FROM openjdk:19-jdk-slim
ARG version=0.0.1-SNAPSHOT
ARG JAR_FILE=*.jar
ADD target/IBANValidator-$version.jar /ibanvalidator.jar
ENTRYPOINT ["java", "-jar", "ibanvalidator.jar"]
EXPOSE 8080