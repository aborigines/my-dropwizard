# dropwizard

changelog
---
- add Junit5
- add HelloResource with test and integrationTest
- add database postgres
- add migration
- create table people

How to start the dropwizard application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

How to run migration
1. `java -jar target/dropwizard-1.0-SNAPSHOT.jar db migrate config.yml`
