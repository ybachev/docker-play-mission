FROM java:8
VOLUME /tmp
ADD /target/docker-play-mission-0.0.1-SNAPSHOT.jar play-mission-app.jar
EXPOSE 8080
RUN bash -c 'touch /play-mission-app.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb/admin", "-Djava.security.egd=file:/dev/./urandom","-jar","/play-mission-app.jar"]