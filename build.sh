#!/bin/sh
docker build . -f ./producer/Dockerfile -t bp/producer
docker build . -f ./consumer1/Dockerfile -t bp/consumer1
docker build . -f ./consumer2/Dockerfile -t bp/consumer2