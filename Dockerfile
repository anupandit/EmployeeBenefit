FROM openjdk:8
COPY target/EmployeeBenefit-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","EmployeeBenefit-0.0.1-SNAPSHOT.jar"]