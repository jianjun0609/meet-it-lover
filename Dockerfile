FROM java:8
ADD target/laiai-data-analysis.jar /usr/local/javaapp/laiai-data-analysis.jar
RUN echo "Asia/Shanghai" > /etc/timezone
