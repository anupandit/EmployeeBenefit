
FROM openjdk:8
ADD target/EmployeeBenefit-0.0.1-SNAPSHOT.jar opt/EmployeeBenefit-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","opt/EmployeeBenefit-0.0.1-SNAPSHOT.jar"]