Keep data.sql file in src/main/resources folder and it will be automatically executed on startup.


Create a schema.sql file (or schema-h2.sql) as well to create schema:
We shouldn't have to do this since Spring boot already configures Hibernate to create schema based on the entities (model classes) for an in memory database. 
If really want to use schema.sql we'll have to disable this feature by adding this to your application.properties:
```
spring.jpa.hibernate.ddl-auto=none
```

https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization