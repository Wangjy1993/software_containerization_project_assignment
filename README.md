# Software Containerization Project

### Team members: Jingye Wang, Qiuyang Fu, Shengyu Lu

### Github Repository
* https://github.com/Wangjy1993/software_containerization_project_assignment

<hr>

## Directory Guide
* #### k8s-configuration
* #### persistent-k8s-configuration
* #### persistent-layer-helm: Helm chart for postgresql using bitnami/postgresql as subchart
* #### rbac: Kubernetes Role Based Access Control configurations
* #### react-frontend: ReactJS frontend source code
* #### sc-frontend-chart: Helm chart for frontend
* #### sc-rest-api-chart: Helm chart for backend
* #### springboot-backend: Java Spring Boot source code

<hr>

Take rest-api as example.

## Build

cd sc/springboot-backend
docker build .
docker tag 6fd5542a7751 europe-west4-docker.pkg.dev/sc-group25/sc-group25-rest-api-docker/sc-restapi:0.2.0
docker push europe-west4-docker.pkg.dev/sc-group25/sc-group25-rest-api-docker/sc-restapi:0.2.0

<hr>

## Deploy
cd sc/sc-rest-api-chart
helm package ./
helm push sc-rest-api-0.2.0.tgz oci://europe-west4-docker.pkg.dev/sc-group25/sc-rest-api
helm install sc-rest-api oci://europe-west4-docker.pkg.dev/sc-group25/sc-rest-api/sc-rest-api --version 0.2.0 --debug --set datasourceUrl=jdbc:postgresql://10.12.13.16:5432/SoftwareContainerization


<hr>

## Update
cd sc/sc-rest-api-chart
helm package ./
helm push sc-rest-api-0.2.0.tgz oci://europe-west4-docker.pkg.dev/sc-group25/sc-rest-api
helm upgrade sc-rest-api oci://europe-west4-docker.pkg.dev/sc-group25/sc-rest-api/sc-rest-api --version 0.2.0 --debug --set datasourceUrl=jdbc:postgresql://10.12.13.16:5432/SoftwareContainerization

<hr>

## Uninstall

