package ma.emsi.bankaccountservice.entities;

import ma.emsi.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = {BankAccount.class})
public interface AccountProjection {
    String getId();
    AccountType getType();
}
