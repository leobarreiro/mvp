#!/bin/sh
docker build -t @project.artifactId@:@project.version@ .
docker stack deploy --compose-file docker-stack.yml @project.artifactId@