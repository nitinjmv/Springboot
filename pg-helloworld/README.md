### Build springboot app
```
mvn clean install -DskipTests=true
```

### To run postgres & pgadmin in container
```
docker-compose up -d
docker-compose down
```

### Test
Return list of all the products loaded into db on startup.
```
http://localhost:8080/products
```

product table can be verified via Pgadmin
```
http://localhost:5050
```

Register new server
```
General > Name: postgres_container 
Connection > hostname: postgresqldb
username: root
password: root
Save
```

### Troubleshooting
To refresh the sbprogres image
```
mvn clean install -DskipTests=true
docker-compose build --no-cache
```
