#!/bin/bash

minikube start --driver=docker
eval $(minikube docker-env)

docker-compose build

kompose convert

kubectl apply -f backend-deployment.yaml
kubectl apply -f backend-service.yaml
kubectl apply -f frontend-deployment.yaml
kubectl apply -f frontend-service.yaml
kubectl apply -f postgres-deployment.yaml
kubectl apply -f postgres-data-persistentvolumeclaim.yaml
kubectl apply -f postgres-service.yaml

sleep 30

kubectl get all

echo "Port forwarding services..."
kubectl port-forward service/backend 8080:8080 &
kubectl port-forward service/frontend 3000:3000 &

sleep 5

echo "Successfull deployment! frontend at http://localhost:3000 and backend at http://localhost:8080"

# Keep the script running until interrupted
wait
