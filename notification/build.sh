#!/bin/bash

docker build --tag notification:1.1.7 .
docker tag notification:1.0.7 0x01code/monegoo-notification:1.1.7
docker push 0x01code/monegoo-notification:1.1.7