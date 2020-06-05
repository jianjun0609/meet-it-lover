FROM java:8
ADD target/meet-it-lover.jar /usr/local/meet-it-lover.jar
RUN echo "Asia/Shanghai" > /etc/timezone
