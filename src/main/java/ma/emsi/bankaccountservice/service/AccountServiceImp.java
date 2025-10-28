package ma.emsi.bankaccountservice.service;

import ma.emsi.bankaccountservice.dto.BankAccountResponseDTO;
import ma.emsi.bankaccountservice.dto.BankAccountRequestDTO;
import ma.emsi.bankaccountservice.entities.BankAccount;
import ma.emsi.bankaccountservice.mappers.AccountMapper;
import ma.emsi.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImp implements AccountService {



    @Autowired
//    public AccountServiceImp(BankAccountRepository bankAccountRepository) {
//        this.bankAccountRepository = bankAccountRepository;
//    }
private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO responseDTO=accountMapper.fromBankAccount(savedBankAccount);
//        BankAccountResponseDTO responseDTO = BankAccountResponseDTO.builder()
//
//                .balance(savedBankAccount.getBalance())
//                .type(savedBankAccount.getType())
//                .currency(savedBankAccount.getCurrency())
//                .build();

        return responseDTO;
    }
}
