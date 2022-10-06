package nttdata.grupouno.com.Clients.models.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nttdata.grupouno.com.Clients.models.Clients;
import nttdata.grupouno.com.Clients.models.Events;

@Data
@EqualsAndHashCode(callSuper = true)
public class EventsClients extends Events<Clients> {
}
