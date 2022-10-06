package nttdata.grupouno.com.Clients.convert;

import nttdata.grupouno.com.Clients.models.Clients;
import nttdata.grupouno.com.Clients.models.EventType;
import nttdata.grupouno.com.Clients.models.dto.EventsClients;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class EventsConvert {

    public EventsClients ConvertToEventsClients(Clients clients){
        EventsClients dto=new EventsClients();
        dto.setData(clients);
        dto.setId(UUID.randomUUID().toString());
        dto.setType(EventType.CONSULT);
        dto.setDate(new Date());
        System.out.println("Convert");
        System.out.println(dto.getData());
        return dto;
    }
}
