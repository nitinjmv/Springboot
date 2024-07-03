FROM openjdk:11
ADD target/k8sbpostgres.jar k8sbpostgres.jar
ENTRYPOINT ["java", "-jar", "k8sbpostgres.jar"]