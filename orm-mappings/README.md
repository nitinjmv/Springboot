https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

# Demo of ORM Mappings

## Tech stack

- Springboot
- Postgres
- Docker
- Kubernetes

## Entities

- Cart
- Category
- OrderDetail
- Orders
- Payment
- Product
- User

## Mappings

One-to-One 

### In a user's journey context.

- One-to-One

  One Order has one OrderDetail
  One User has One Cart at a time
  Only One Payment can be made against One Order

- One-to-Many

  One User can place Many Orders

- Many-to-One

  Many payments can be made by One User

- Many-to-Many

  Many products can be part of Many Categories

## Run

There are 2 profiles

- dev: application runs against h2
- prod: application runs against Postgres running in Kubernetes

HealthCheck
`http://localhost:8080/actuator/health`

`git clone https://github.com/nitinjmv/Springboot.git`

`cd orm-mappings`

`docker build -t nitinjmv/springboot: orm-mappings .`

`docker push nitinjmv/springboot:tagname`

Test Image

`docker run -d --rm -p 8080:8080 nitinjmv/orm-mappings`

`http://localhost:8080/actuator/health`

``
