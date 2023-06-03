#!/bin/sh

cd server

sh mvnw clean install -DskipTests

docker build -t byanat:challenge .

cd ..

docker-compose up -d
