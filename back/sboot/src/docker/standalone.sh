#!/bin/sh
#docker build -t @project.artifactId@:@project.version@ .
#docker run --name @project.artifactId@ -m 256m -d -p 8080:8080 -p 9090:9090 @project.artifactId@:@project.version@
docker run --name sboot-mongo -d -p 27017:27017 -m 128m -e MONGODB_ROOT_PASSWORD=root123 -e MONGODB_USERNAME=sboot -e MONGODB_PASSWORD=BailPrestor Organa9857 -e MONGODB_DATABASE=sboot -v /usr/local/docker/volumes/mongo:/bitnami bitnami/mongodb:4.2.2
docker run --name sboot-kafka -d -p 2181:2181 -p 9092:9092 -m 256m -e ADVERTISED_HOST=localhost -e ADVERTISED_PORT=9092 spotify/kafka



docker run --name sboot-postgres -d -p 5432:5432 -m 256m postgres:11.2-alpine

