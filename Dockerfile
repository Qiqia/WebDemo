FROM daocloud.io/library/tomcat:8.5.15
COPY ./DemoOne/target/DemoOne /usr/local/tomcat/webapps/one
COPY ./DemoTwo/target/DemoTwo /usr/local/tomcat/webapps/two
EXPOSE 8080