FROM amazoncorretto:17-alpine as corretto-deps

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

RUN unzip application.jar -d temp &&  \
    jdeps  \
      --print-module-deps \
      --ignore-missing-deps \
      --recursive \
      --multi-release 17 \
      --class-path="./temp/BOOT-INF/lib/*" \
      --module-path="./temp/BOOT-INF/lib/*" \
      application.jar > /modules.txt

FROM amazoncorretto:17-alpine as corretto-jdk

COPY --from=corretto-deps /modules.txt /modules.txt

# hadolint ignore=DL3018,SC2046
RUN apk add --no-cache binutils && \
    jlink \
     --verbose \
     --add-modules "$(cat /modules.txt),jdk.crypto.ec,jdk.crypto.cryptoki" \
     --strip-debug \
     --no-man-pages \
     --no-header-files \
     --compress=2 \
     --output /jre

# hadolint ignore=DL3007
FROM alpine:latest
ENV JAVA_HOME=/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY --from=corretto-jdk /jre $JAVA_HOME

WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring

#ADD --chown=spring:spring https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar agent.jar

ARG JAR_FILE=target/*.jar
COPY --chown=spring:spring ${JAR_FILE} application.jar

EXPOSE 8080

USER spring:spring

#ENTRYPOINT exec java -javaagent:agent.jar $JAVA_OPTS -Djava.security.edg=file:/dev/./urandom -Dspring.profiles.active=prd -jar application.jar

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.edg=file:/dev/./urandom -Dspring.profiles.active=dev -jar application.jar
