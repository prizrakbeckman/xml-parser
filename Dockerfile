FROM openjdk:17-oracle
ARG JAR_FILE=*.jar
EXPOSE 8080
ADD target/${JAR_FILE} epaper-parser.jar
ENTRYPOINT ["java","-jar","epaper-parser.jar"]
