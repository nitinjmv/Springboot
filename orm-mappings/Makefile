build:
	mvn clean install -DskipTests=true
	docker build -t deploymentbpostgres:latest .
	docker tag deploymentbpostgres:latest nitinjmv/deploymentbpostgres:latest
	docker push nitinjmv/deploymentbpostgres

apply:
	kubectl apply -f deployment/namespace.yml --namespace=ns
	kubectl apply -f deployment/postgres-storage.yml --namespace=ns
	kubectl apply -f deployment/postgres-secret.yml --namespace=ns
	kubectl apply -f deployment/postgres-configmap.yml --namespace=ns
	kubectl apply -f deployment/postgres-deployment.yml --namespace=ns
	kubectl apply -f deployment/app-deployment.yml --namespace=ns
	kubectl get all --namespace=ns

clean:
	kubectl delete namespace ns
#	kubectl delete deployment deploymentbpostgres
#	kubectl delete deployment postgres
#	kubectl delete svc deploymentbpostgres
#	kubectl delete svc postgres
#	kubectl delete configmap postgres-config
#	kubectl delete secret postgres-credentials
#	kubectl delete pvc postgres-pv-claim
#	kubectl delete pv postgres-pv-volume

refresh: clean build apply

deploy: build apply