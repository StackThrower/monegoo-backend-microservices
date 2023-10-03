
# Help


#### Udpate version on prod

kubectl set image deployment.apps/monegoo-gateway monegoo-gateway=0x01code/monegoo-gateway:1.0.7


#### Build native image

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/
../mvnw -Pnative spring-boot:build-image