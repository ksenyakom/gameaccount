Microservices:

### Customerprofile
(Customer, CustomerInfo),
Spring Boot, Postgres
8080

### Gameprofile
(CustomerGameProfile,Inventory, CustomerInventory)
Spring Boot, Postgres
8082

CustomerInventoryController - сквозное логирование - ходит в cusotmerprofile - не работает
localhost:8082/customer/inventory - тут кеш

### Achievements:
(Achievements, CustomerAchievements, Statistics) 
String Boot, Mongo, Kafka
achievements posts achievements-> gameprofile reads and increases level
8081

### Payments
(Payment)
Spring Webflux, Postgres


ToDo list:
???? messages

сквозное логирование
helm to up all services on needed ports
prometheus grafana
grpc


Plans:

job
    counts statistics

cache
    inventory
