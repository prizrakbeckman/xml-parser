FROM openjdk:17-oracle
ARG JAR_FILE=*.jar
ADD target/${JAR_FILE} epaper-parser.jar
ENTRYPOINT ["java","-jar","epaper-parser.jar"]
EXPOSE 8080