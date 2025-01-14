restart: stop start


start:
	echo "start.."
	docker-compose up -d
	echo "Adding 5 seconds delay for db to start"
	timeout 5
	mvn spring-boot:run &


stop:
	echo "stopping.."
	docker-compose down
	timeout 5