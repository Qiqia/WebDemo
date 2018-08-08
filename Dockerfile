FROM daocloud.io/library/tomcat:8.5.15
ADD ./DemoOne/target/DemoOne.war /usr/local/tomcat/webapps/one.war
ADD ./DemoTwo/target/DemoTwo.war /usr/local/tomcat/webapps/two.war
EXPOSE 8080