
# Help

#### Create local DBs

docker run -d -p 3308:3306 -e  MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=monegoo mysql:8.0


#### Udpate version on prod

kubectl set image deployment.apps/monegoo-notification monegoo-notification=0x01code/monegoo-notification:1.1.7