#base image
FROM openjdk:15-slim
#env
ENV LOG_LEVEL INFO
ENV JDBC_USER postgres
ENV JDBC_PASS 123
#copy jar from target to image
ADD build/libs/metroMap-0.0.1-SNAPSHOT.jar metroMap-0.0.1-SNAPSHOT.jar

#port expose
EXPOSE 9000
#start jar inside container
ENTRYPOINT java -Dlogging.level.ru.docker=$LOG_LEVEL  -Dspring.datasource.username=$JDBC_USER -Dspring.datasource.password=$JDBC_PASS -jar metroMap-0.0.1-SNAPSHOT.jar

