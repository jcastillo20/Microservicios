package nttdata.grupouno.com.operations.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Data
@EntityScan
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "card")
public class CardModel {
    @Id
    private Integer id;
    @NotEmpty
    private String numberCard;
    @NotEmpty
    private String type;    //D:Debito - C:Credito
    @DecimalMin(value = "0.00")
    private Double amount;  //debito: monto actual - credito: monto gastado
    @NotEmpty
    private String status;  //A:Activa - C:Cancelada

    private String startDate;
    private String endDate;
    //Solo debito:
    private String idMainMasterAccount; //Cuenta principal asociada
    //Solo credito:
    private Double maxAmountCreditCard; //Monto maximo credito
}
