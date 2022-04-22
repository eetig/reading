spring:
  cloud:
    inetutils:
      ignoredInterfaces:
        - docker0
        - veth.*
        - VM.*
      preferredNetworks:
        - 172.16

eureka:
  server:
    enable-self-preservation: false
  instance: eureka-server
    hostname: 172.16.124.133
    prefer-ip-address: true
    instance-id: 172.16.124.133:8761
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka