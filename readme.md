# Kafka demo

## Requirements

Docker desktop with kubernetes turned on.

On windows, use wsl shell.

## Preparation

Execute `./build.sh`to build docker images of producer and consumer.

## Run kafka cluster

Execute `./run.sh`, which will create pods for:

- zookeeper
- 3 kafka servers
- producer
- 2 consumers

## Stop

Execute `./stop.sh` to stop all pods.