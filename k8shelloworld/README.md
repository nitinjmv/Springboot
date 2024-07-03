### Build springboot app
```
mvn clean install
```

### Build Docker Image
```
docker build -t sbk8shelloworld:latest .
```

### Test Image
```
docker run --rm -p 8080:8080 --name sbk8shelloworld_container sbk8shelloworld
http://localhost:8080/products
docker stop sbk8shelloworld_container
```

### Push Image on docker-hub 
```
docker login 
docker tag SOURCE_IMAGE[:TAG] TARGET_IMAGE[:TAG]
docker tag sbk8shelloworld:latest nitinjmv/sbk8shelloworld:latest
docker push nitinjmv/sbk8shelloworld
```

### Create kubernetes resources 
```
kubectl apply -f deployment.yml
```

### Test
Return list of all the products loaded into db on startup.
```
http://localhost:8080/products
```
