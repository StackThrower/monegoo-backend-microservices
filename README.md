
# Help

#### Delete all completed jobs
* kubectl delete pod --field-selector=status.phase==Succeeded

#### Delete all pods, deployments, rs, daemonsets, ingress
* kubectl delete deployments --all
* kubectl delete rs --all
* kubectl delete services --all
* kubectl delete pods --all
* kubectl delete daemonset --all
* kubectl delete ingress demo-localhost

#### Create local DBs

docker run -d -p 3308:3306 -e  MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=monegoo mysql:8.0