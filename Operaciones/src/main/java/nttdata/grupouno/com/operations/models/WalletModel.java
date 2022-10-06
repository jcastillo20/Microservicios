package nttdata.grupouno.com.operations.models;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class WalletModel {
    @Id
    private Integer id;
    @NotNull
    private String docNumber;
    @Positive
    @NotNull
    private Integer phoneNumber;
    @NotNull
    private String imei;
    @NotNull
    @Email(regexp = ".+[@].+[\\.].+")
    private String mail;
}
