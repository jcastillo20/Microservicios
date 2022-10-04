package nttdata.grupouno.com.Clients.models.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nttdata.grupouno.com.Clients.models.Clients;
import nttdata.grupouno.com.Clients.models.MasterAccount;

@AllArgsConstructor
@NoArgsConstructor
public class ClientsWithAccounts extends Clients  {
	
	@Getter
	@Setter
	List<MasterAccount> accounts;

}
