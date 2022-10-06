package nttdata.grupouno.com.Clients.models;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Events<T> {

    private String id;
    private Date date;
    private EventType type;
    private T data;
}
