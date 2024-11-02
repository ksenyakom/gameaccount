Microservices:

### Customerprofile
(Customer, CustomerInfo),
Spring Boot, Postgres
8080
http://localhost:30001/swagger-ui/index.html

### Gameprofile
(CustomerGameProfile,Inventory, CustomerInventory)
Spring Boot, Postgres
8082
/customer/inventory - тут кеш

### Achievements:
(Achievements, CustomerAchievements, Statistics) 
String Boot, Mongo, Kafka
achievements posts achievements-> gameprofile reads and increases level
8081

### Payments
(Payment)
Spring Webflux, Postgres
8084

### Helm
Install:
> helm install gameaccount-app ./helm 
> 
> kubectl port-forward svc/postgres 5432:5432
> 
> helm install my-kafka bitnami/kafka -f db/kafka-values.yaml

Kafka get password and forward port:
> kubectl get secret my-kafka-user-passwords --namespace default -o jsonpath='{.data.client-passwords}' | base64 -d | cut -d , -f 1

>kubectl port-forward svc/my-kafka 9092:9092

Uninstall:
>helm uninstall gameaccount-app

>helm uninstall my-kafka

#### Problems:

While installing project in kubernates there were some problems:
- I tried to create databases in postgres using script create-databases.sql, but it didn't work. 
I had to create databases manually.
- Mongo database of latest version didn't installed - I had to downgrade version to 4.4
- Kafka didn't work and I couldn't find the reason untill tried to install it separately.
Also, couldn't set my own user/password, it always set random password. - need to fix it and add kafka in common helm



ToDo list:
messages
сквозное логирование
helm to up all services
prometheus grafana
grpc
