package nttdata.grupouno.com.Clients.producer;

import nttdata.grupouno.com.Clients.convert.EventsConvert;
import nttdata.grupouno.com.Clients.models.Clients;
import nttdata.grupouno.com.Clients.models.Events;
import nttdata.grupouno.com.Clients.models.NaturalPerson;
import nttdata.grupouno.com.Clients.models.dto.EventsClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringProducer {


    @Autowired
    private  KafkaTemplate<String, Events<?>> producer;

    @Value("${topic.Clients.name:findByIdClientWithAccounts}")
    private String topicNaturalPerson;

    @Autowired
    private EventsConvert eventsConvert;

    public void Consult(Clients clients) {
        EventsClients eventsClient= eventsConvert.ConvertToEventsClients(clients);
        System.out.println(eventsClient);
        this.producer.send(topicNaturalPerson,eventsClient);
    }

}
