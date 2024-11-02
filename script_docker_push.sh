#!/bin/bash

#cd achievements
#mvn clean package
#
#docker build -t achievements .
#docker tag achievements kseniya1/achievements:v1.1
#docker push kseniya1/achievements:v1.1


#cd customerprofile
#mvn clean package
#
#docker build -t customerprofile .
#docker tag customerprofile kseniya1/customerprofile:v1.1
#docker push kseniya1/customerprofile:v1.1

cd gameprofile
mvn clean package

docker build -t gameprofile .
docker tag gameprofile kseniya1/gameprofile:v1.1
docker push kseniya1/gameprofile:v1.1

#cd payments
#mvn clean package
#
#docker build -t payments .
#docker tag payments kseniya1/payments:v1.0
#docker push kseniya1/payments:v1.0