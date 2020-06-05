FROM java:8
MAINTAINER nanhaidetianzhi <957186816@qq.com>
VOLUME /tmp
COPY jenkins*.jar app.jar
RUN bash -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]