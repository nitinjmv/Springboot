`make restart`
This will create databases containers & run the application.


`make down`

http://localhost:9191/actuator/health

## Run MySQL & Postgres in Docker
<hr>

### Postgres

#### Run postgres in docker container
`docker run -d --rm 
--name my-pg 
-p 5432:5432
-e POSTGRES_PASSWORD=root 
-e PGDATA=/var/lib/postgresql/data/pgdata 
postgres`

- default username: postgres
- default database: postgres

#### Create & Connect to database
- `docker exec -it my-pg bash`
- `psql -h localhost -U postgres`
- `CREATE DATABASE accounts;`
- `\l`
- `\c accounts`

#### Find the IP address of container
`docker inspect my-postgres | findstr "IPAddress"`


### MySQL

`docker run -d --rm 
--name my-mysql
-p 3306:3306
-e MYSQL_ROOT_PASSWORD=root 
mysql`

#### Create & Connect to database

- `docker exec -it my-mysql bash`
- `mysql -u root -p` 
  - enter password `root`
- `CREATE DATABASE accounts;`
- `show databases`
- `use accounts`

<hr>

### Application

#### Endpoints to operate on MySql
    /my/accounts <br>
    POST: /bulkUpload -> upload accounts from data.sql <br>
    POST: / -> add one account <br> 
    GET: -> / list of accounts <br>
    GET: -> /{id} get accounts by id <br>
    DELETE: /{id} -> delete by id <br>
    DELETE: /cleanup -> delete all


#### Endpoints to operate on PG
    /pg/accounts <br>    
    POST: / -> add one account <br>
    GET: -> / list of accounts <br>
    GET: -> /{id} get accounts by id <br>
    DELETE: /{id} -> delete by id <br>
    DELETE: /cleanup -> delete all


#### Batch Job
Row by row operation
- Read data from MySql  
- Call another API to encrypt the account_number  
- Insert into PG

In Chuck (500 records)
- Read data from MySql
- Call another API to encrypt the account_number
- Insert into PG
