package ma.emsi.bankaccountservice.web;


import ma.emsi.bankaccountservice.entities.BankAccount;
import ma.emsi.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
@QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }
//    @QueryMapping
//    public BankAccount bankAccountById(@Argument String id) {
//    return bankAccountRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Bank account not found"));
//    }
@QueryMapping
public BankAccount bankAccountById(@Argument String id) {
    UUID accountId = UUID.fromString(id); // conversion obligatoire si ID = UUID
    return bankAccountRepository.findById(String.valueOf(accountId))
            .orElseThrow(() -> new RuntimeException("Bank account not found"));
}
@MutationMapping
    public BankAccount addAccount(@Argument BankAccount bankAccount) {
    return bankAccountRepository.save(bankAccount);
}

}
//record BankAccount(Double balance , String type , String currency){
//
//}
