### quick commands
```
make deploy
make apply
make refresh
make clean
```

### test postgresdb
```
kubectl exec -it [pod-name] --  psql -h localhost -U postgres --password -p 5432 postgresdb

\conninfo
```

### Test app
```
http://localhost:30200/products
```