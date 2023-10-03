#!/bin/bash

docker build --tag currency:1.0.8 .
docker tag currency:1.0.8 0x01code/monegoo-currency:1.0.8
docker push 0x01code/monegoo-currency:1.0.8