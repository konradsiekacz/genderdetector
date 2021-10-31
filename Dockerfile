FROM openjdk:11
EXPOSE 8080
ADD /target/genderdetector-0.0.1-SNAPSHOT.jar .
CMD java -jar genderdetector-0.0.1-SNAPSHOT.jar
