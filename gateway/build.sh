#!/bin/bash

docker build --tag gateway:1.0.7 .
docker tag gateway:1.0.7 0x01code/monegoo-gateway:1.0.7
docker push 0x01code/monegoo-gateway:1.0.7

