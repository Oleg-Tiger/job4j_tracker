FROM maven:3.6.3-openjdk-17

RUN mkdir job4j-tracker

WORKDIR job4j-tracker

COPY . .

RUN mvn package -Dmaven.test.skip=true

CMD ["mvn", "liquibase:update", "-Pdocker"]

CMD ["java", "-jar", "target/tracker.jar"]