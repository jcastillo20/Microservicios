package nttdata.grupouno.com.operations.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@EntityScan
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cardAccount")
public class CardAccountModel {
    @Id
    public Integer id;
    @NotEmpty
    private Integer idCardModel;
    @NotEmpty
    private String idMasterAccount;
    private String startDate;
}
