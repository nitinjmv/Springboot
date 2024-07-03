build:
	mvn clean install -DskipTests=true
	docker build -t k8sbpostgres:latest .
	docker tag k8sbpostgres:latest nitinjmv/k8sbpostgres:latest
	docker push nitinjmv/k8sbpostgres

apply:
	kubectl apply -f k8s/namespace.yml --namespace=ns
	kubectl apply -f k8s/postgres-storage.yml --namespace=ns
	kubectl apply -f k8s/postgres-secret.yml --namespace=ns
	kubectl apply -f k8s/postgres-configmap.yml --namespace=ns
	kubectl apply -f k8s/postgres-deployment.yml --namespace=ns
	kubectl apply -f k8s/app-deployment.yml --namespace=ns
	kubectl get all --namespace=ns

clean:
	kubectl delete namespace ns
#	kubectl delete deployment k8sbpostgres
#	kubectl delete deployment postgres
#	kubectl delete svc k8sbpostgres
#	kubectl delete svc postgres
#	kubectl delete configmap postgres-config
#	kubectl delete secret postgres-credentials
#	kubectl delete pvc postgres-pv-claim
#	kubectl delete pv postgres-pv-volume

refresh: clean build apply

deploy: build apply