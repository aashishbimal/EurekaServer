# EurekaServer
Ist Step Need to Run Eureka Server
----------------------------------------------------------------------------------
1. For running Eureka server need to add dependency in POM named "Eureka Server".
2. Enable eureka server in Main Class By annotating @EnableEurekaServer.
3. Add properties in application.yml
    spring:
      application:
        name: eureka-service

    server:
      port: 8070

    eureka:
      client:
        register-with-eureka: false
        fetch-registry: false
        server:
          waitTimeInMsWhenSyncEmpty: 0
        service-url:
              defaultZone: http://localhost:8070/eureka
4. Start The Server.

Client Test URL: http://localhost:8072/client/test/

IInd Step Need to Run Client to test service
----------------------------------------------------------------------------------
1. For running Client need to add dependency in POM named "Eureka Discovery".
2. Enable Client discovery in Main Class By annotating @EnableDiscoveryClient.
3. Add properties in application.yml
    spring:
      application:
        name: hello-client

    eureka:
      client:
        register-with-eureka: true
        fetch-registry: true
        service-url:
          defaultZone: http://localhost:8070/eureka/
      instance:
        hostname: localhost

    server:
      port: 8072
4. Start The Server.

IIIrd Step Need to Run server To Test Eureka service.
----------------------------------------------------------------------------------
1. For running Server need to add dependency in POM named "Eureka Discovery".
2. Enable Client discovery in Main Class By annotating @EnableDiscoveryClient.
3. Add properties in application.yml
    spring:
      application:
        name: hello-server

    server:
      port: 8071

    eureka:
      client:
        register-with-eureka: true
        fetch-registry: true
        service-url:
          defaultZone: http://localhost:8070/eureka/
      instance:
        hostname: localhost
4. Start The Server.
