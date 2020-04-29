FROM mcr.microsoft.com/java/jdk:8-zulu-alpine
VOLUME /tmp
ADD eureka-server-0.0.1-SNAPSHOT.jar app.jar
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT java -jar -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom /app.jar
EXPOSE 8861