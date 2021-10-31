FROM openjdk:11
ADD target/genderdetector-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar genderdetector-0.0.1-SNAPSHOT.jar
