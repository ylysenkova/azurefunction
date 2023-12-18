package org.example.function;

import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusQueueTrigger;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ServiceBusTrigger {

    Logger log = Logger.getLogger("ServiceBusTrigger");

    @FunctionName("myFunction")
    public void execute(
            @ServiceBusQueueTrigger(
                    name = "msg",
                    queueName = "%SPRING_CLOUD_AZURE_SERVICEBUS_CONSUMER_ENTITY_NAME%",
                    connection = "SPRING_CLOUD_AZURE_SERVICEBUS_CONSUMER_CONNECTION_STRING")
            ServiceBusReceivedMessage message,
            ExecutionContext context) {
        System.out.println("Run service bus function");
    }
}
