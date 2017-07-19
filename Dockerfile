FROM maven as build-stage
WORKDIR /code
COPY pom.xml /code/
COPY src/main /code/src/main
RUN mvn package

FROM tomcat
WORKDIR /usr/local/tomcat/webapps
COPY --from=build-stage /code/target/blogitaway.war .
#COPY --from=build-stage /code/ .
CMD catalina.sh run
