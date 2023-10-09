Acessar Swagger no eureka:

1 - clique na url do service no eureka:
http://thiago-pc:63880/actuator/info

2 - retire a parte /actuator/info
e coloque: /swagger-ui/index.html


Criar container RabbitMQ:
CMD:  docker run -it --name RABBITMQ --restart=always -d -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management