FROM nikfarjam/base-jre-11:latest

COPY ./target/converter-server-1.0-SNAPSHOT.jar /opt/server/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/opt/server/app.jar"]