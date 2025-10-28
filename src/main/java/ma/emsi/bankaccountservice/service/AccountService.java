package ma.emsi.bankaccountservice.service;

import ma.emsi.bankaccountservice.dto.BankAccountRequestDTO;
import ma.emsi.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
