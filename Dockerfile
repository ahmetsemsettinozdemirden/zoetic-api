FROM registry.gitlab.com/bigo-digital/hotpet/server/base:latest as builder

WORKDIR /usr/local/app

COPY ./ ./

RUN mvn \
    -Dmaven.test.skip=true \
    --batch-mode \
    package


FROM gcr.io/distroless/java:8

EXPOSE  8080
WORKDIR /usr/local/app

COPY --from=builder \
    /usr/local/app/target/server*.jar \
    ./server.jar

COPY ./src/main/resources ./


CMD [ "/usr/local/app/server.jar", "-Djava.security.edg=file:/dev/./urandom"]