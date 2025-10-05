FROM openjdk:21-jdk-slim AS build

RUN apt-get update && apt-get install maven -y

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src /app/src

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

EXPOSE 8080

RUN apt-get update && apt-get install netcat-openbsd -y

COPY --from=build /app/target/*.jar /usr/local/lib/backend-springboot.jar

COPY wait-for-it.sh /usr/local/bin/wait-for-it.sh

RUN chmod +x /usr/local/bin/wait-for-it.sh

COPY start.sh /usr/local/bin/start.sh

RUN chmod +x /usr/local/bin/start.sh

ENTRYPOINT ["/usr/local/bin/start.sh"]
#ENTRYPOINT ["/usr/local/bin/wait-for-it.sh", "mariadb:3306", "--", "java", "-jar", "/usr/local/lib/backend-springboot.jar"]
#ENTRYPOINT ["java", "-jar", "/usr/local/lib/backend-springboot.jar"]

