
# Help


#### Udpate version on prod

kubectl set image deployment.apps/monegoo-currency monegoo-currency=0x01code/monegoo-currency:1.0.8.1


#### Build native image

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/
../mvnw -Pnative spring-boot:build-image

#### Push image to 
docker tag currency:1.0.8.1 0x01code/monegoo-currency:1.0.8.1
docker push 0x01code/monegoo-currency:1.0.8.1

#### Connect to DB on prod
kubectl run -it --rm --image=mysql:8.0 --restart=Never mysql-client -- mysql -u root -h monegoo-currency-mysql -p