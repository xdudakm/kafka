#!/bin/sh
kubectl apply -f ./kubernetes/zookeeper.yaml
kubectl apply -f ./kubernetes/kafka_server1.yaml
kubectl apply -f ./kubernetes/kafka_server2.yaml
kubectl apply -f ./kubernetes/kafka_server3.yaml
kubectl apply -f ./kubernetes/producer.yaml
kubectl apply -f ./kubernetes/consumer1.yaml
kubectl apply -f ./kubernetes/consumer2.yaml