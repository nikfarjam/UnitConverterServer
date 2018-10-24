FROM nikfarjam/base-jre:11.0.1

ARG BUILD=target/
ENV APP_ROOT=/opt/uc-server/

COPY ${BUILD}/converter-server-1.0-SNAPSHOT.jar ${APP_ROOT}/app.jar
COPY ${BUILD}/dependency/config/ ${APP_ROOT}/

EXPOSE 8080

ENTRYPOINT ["java","-jar", "/opt/uc-server/app.jar"]