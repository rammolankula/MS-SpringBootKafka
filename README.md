#### Sprinb Boot + Apache Kafka
![Kafka_Architecture](https://github.com/user-attachments/assets/f8db3f7f-191a-44b4-8078-d5f37b1ae2d8)

<pre>
 &#8594; Kafka is a product s/w given by apache company. this used to implement
        message queues in application
   
 &#8594; Apache Kafka supports AMQP (Advanced message queues protocols). 

Limitations of Basic Message Queue Protocols are:
 &#8594;  No Load Balance supported for message broker. ie only one message broker instance
   is created even if we execute multiple producers and consumers.
   
 &#8594; slow in data transfer if data is too large and sent as Text representation only
   (or manual binary conversion required).
  
 &#8594; if MOM is not responding then communication can not be done between applications.
===================================================================================
 &#8594; Apache kafka supports Integration with any type of application(language Independent),
        JMS works only with java applications.
  
 &#8594; Kafka supports only TOPIC which can be used to send data for one consumer/multiple consumer

 &#8594; kafka contains "Multiple Brokers Servers" which are also called as message brokers.
         so load balance supported using Multi-broker concept.
  
 &#8594; All these broker instances (Broker Servers) as a set called as 'Kafka Cluster'.

 &#8594; Kafka cluster is auto-scaled by BootStrap server(ie zookeeper). it handled
         multiple broker servers in kafka.
  
 &#8594; Apache zookeeper behaves like R&d server here, that controls load request for 
          Producer and Consumer applications.
   
   Kafka EcoSystem=BootStrap Server +Kafka Cluster
                    (Zookeeper)        (Multiple Brokers)
					
 &#8594; Data is sent by producer application in Key=Val format, key=TopicName(DestinationName)
  val=Data/Message.
 
 &#8594; Zookeeper receives the request for data transfer from producer application.
  now, it will check for one message broker instance which is free now, else create
  one instance.
 
 &#8594; Once message broker |broker server is allocated, then it will read Data|Message
         from producer to Kafka Topic Section.
  
 &#8594; Message Broker reads message from Topics section and create one message Replica
         (Cloned Object) to send data to one consumer in key=val format.
  
 &#8594; Kafka supports any type of application protocol (or) it is protocol independent.
         ie it works on your application protocol (like HTTP,FTP,TCP,,,,etc)
  
 &#8594;  Kafka supports communication types P2P and Pub/Sub using only Topic type. it will not
          supports queues concept.
  
Apache Kafka download and setup
===================================
a.Goto: Apache Kafka
b.choose binary downloads
c. click on :tar
d. extract it
====================================
=>Open command prompt for kafka location

e.Start Zookeeper s/w
cmd> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
 
(for Non-Windows)
cmd> .\bin\windows\zookeeper-server-start.sh .\config\zookeeper.properties

j.start kafka cluster (Open Cmd/Terminal for kafka location)
</pre>
c:\user cd kafka_file
c:\kafka file
cmd> .\bin\windows\kafka-server-start.bat .\config\server.properties
<pre>
 (for non-windows) 
cmd> .\bin\kafka-server-start.sh .\config\server.properties
=================================================================
 **) To stop them press ctrl+c(first stop kafka then then zookeeper)
</pre>


#### Work Flow
Microservices-21
================
Apache Kafka work flow using one message broker
===============================================
<pre>
 &#8594; Producer will send data using kafkaTemplate<K,V>.
        Here, KafkaTemplate is class which is auto-configured by spring boot.
  
 &#8594; Data is sent from producer to kafka as serilized format(ie n/w understandable format)
        that supports large data transfer.
  
 &#8594; Data is received at topic section(memory), every topic is identified
         using in unique name. this topic sectxion stored data as partitions.
  
 &#8594; Now, a link must be created between message broker and multiple consumers 
         using one groupId. By using groupId few consumers can be allocated to one
        message broker and other few consumers are allocated to one more message broker.
 
 &#8594; Consumer has to provide topicName to message broker, to read data from Topic section.

 &#8594;<b>***</b>Two consumers having same groupId may have different TopicNames, but not a good
              approach. making groups for consumer is for parallel service using multiple message
	      brokers.

Ex: Consider 9 consumers are trying to read message from 'sample-app' topicName
    Now here first 3 consumers are made as one group 'group-a' and even
	next 3 consumer are 'group-b' and next 3 consumers 'group-c'.
	now one group is allocated to one message broker, ie 3 message brokers
	are going to serve 3 groups in parallel

 &#8594; Here, topic Name is used to specify message  for consumer to be read by messageBroker.
  Message broker create one copy of actual message to send data to one consumer.
  
 &#8594; Data is received at consumer in deserialized format. At consumer side use one
  annotation @KafkaListener(topics="",groupOd="")
http://localhsot:8080/send?message=RAM
http://localhsot:8080/viewAll
 </pre>
