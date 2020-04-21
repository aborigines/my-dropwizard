# dropwizard

changelog
---
- add Junit5
- add HelloResource with test and integrationTest
- add database postgres
- add migration
- create table people
- add hibernate
- add People Domain, DAO, Resource and Service

TODO
---
- Handle Unexpected case (500)  
- add json reponse when return HTTP 204 content not found
- add Jbdi for extemly to custom sql (remcommend hibrenate for the basic sql)
- add cors
- add swagger

How to start the dropwizard application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`


How to run migration
---
1. `java -jar target/dropwizard-1.0-SNAPSHOT.jar db migrate config.yml`

Reference
---

- https://www.dropwizard.io/en/latest/index.html
- https://github.com/dropwizard/dropwizard
