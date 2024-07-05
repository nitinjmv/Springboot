stop:
	docker-compose down

build:
	mvn clean install -DskipTests=true

clean-image:
	docker-compose build --no-cache

up:
	docker-compose up


run:
	stop
	build
	clean-install
	up