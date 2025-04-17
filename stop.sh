#!/bin/sh
kubectl delete pod zookeeper
kubectl delete pod kafka-server1
kubectl delete pod kafka-server2
kubectl delete pod kafka-server3
kubectl delete pod producer
kubectl delete pod consumer1
kubectl delete pod consumer2