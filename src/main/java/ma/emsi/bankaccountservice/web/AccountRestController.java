//package ma.emsi.bankaccountservice.web;
//
//import ma.emsi.bankaccountservice.entities.BankAccount;
//import ma.emsi.bankaccountservice.repositories.BankAccountRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//public class AccountRestController {
//
//    private BankAccountRepository bankAccountRepository;
//
//    public AccountRestController(BankAccountRepository bankAccountRepository) {
//        this.bankAccountRepository = bankAccountRepository;
//    }
//
//    @GetMapping("/bankAccounts")
//    public List<BankAccount> getAccounts() {
//        return bankAccountRepository.findAll();
//    }
//
//    @GetMapping("/bankAccounts/{id}")
//    public BankAccount getBankAccount(@PathVariable String id) {
//        return bankAccountRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException(
//                        String.format("Bank account with id %s not found", id)
//                ));
//    }
//    @PostMapping("/bankAccounts")
//    public BankAccount save(@RequestBody BankAccount bankAccount) {
//        // Générer l'ID et la date de création
//        bankAccount.setId(UUID.randomUUID().toString());
//        bankAccount.setCreatedAt(new Date());
//        return bankAccountRepository.save(bankAccount);
//    }
//    @PutMapping("/bankAccounts/{id}")
//    public BankAccount update (@PathVariable String id, @RequestBody BankAccount bankAccount) {
//        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
//        if (bankAccount.getBalance() != null) {
//            account.setBalance(bankAccount.getBalance());
//        }
//        if (bankAccount.getCurrency() != null) {
//            account.setCurrency(bankAccount.getCurrency());
//        }
//        if (bankAccount.getType() != null) {
//            account.setType(bankAccount.getType());
//        }
//        return bankAccountRepository.save(account);
//    }
//    @DeleteMapping("/bankAccounts/{id}")
//    public void delete (@PathVariable String id) {
//        bankAccountRepository.deleteById(id);
//    }
//}
////------------avec swagger
//package ma.emsi.bankaccountservice.web;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import ma.emsi.bankaccountservice.entities.BankAccount;
//import ma.emsi.bankaccountservice.repositories.BankAccountRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/bankAccounts")
//@Tag(name = "Bank Account", description = "API de gestion des comptes bancaires")
//public class AccountRestController {
//
//    private final BankAccountRepository bankAccountRepository;
//
//    public AccountRestController(BankAccountRepository bankAccountRepository) {
//        this.bankAccountRepository = bankAccountRepository;
//    }
//
//    @Operation(summary = "Récupérer tous les comptes bancaires",
//            description = "Retourne la liste de tous les comptes bancaires")
//    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
//    @GetMapping
//    public List<BankAccount> getAllAccounts() {
//        return bankAccountRepository.findAll();
//    }
//
//    @Operation(summary = "Récupérer un compte par ID",
//            description = "Retourne un compte bancaire spécifique par son identifiant")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Compte trouvé"),
//            @ApiResponse(responseCode = "404", description = "Compte non trouvé")
//    })
//    @GetMapping("/{id}")
//    public BankAccount getBankAccount(
//            @Parameter(description = "ID du compte bancaire")
//            @PathVariable String id) {
//        return bankAccountRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException(
//                        String.format("Bank account with id %s not found", id)
//                ));
//    }
//
//    @Operation(summary = "Créer un nouveau compte bancaire",
//            description = "Crée un nouveau compte bancaire avec les informations fournies")
//    @ApiResponse(responseCode = "201", description = "Compte créé avec succès")
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public BankAccount save(@RequestBody BankAccount bankAccount) {
//        bankAccount.setId(UUID.randomUUID().toString());
//        bankAccount.setCreatedAt(new Date());
//        return bankAccountRepository.save(bankAccount);
//    }
//
//    @Operation(summary = "Mettre à jour un compte bancaire",
//            description = "Met à jour les informations d'un compte bancaire existant")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Compte mis à jour"),
//            @ApiResponse(responseCode = "404", description = "Compte non trouvé")
//    })
//    @PutMapping("/{id}")
//    public BankAccount updateAccount(
//            @Parameter(description = "ID du compte bancaire")
//            @PathVariable String id,
//            @RequestBody BankAccount bankAccount) {
//        BankAccount account = bankAccountRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException(
//                        String.format("Bank account with id %s not found", id)
//                ));
//
//        if (bankAccount.getBalance() != null) {
//            account.setBalance(bankAccount.getBalance());
//        }
//        if (bankAccount.getCurrency() != null) {
//            account.setCurrency(bankAccount.getCurrency());
//        }
//        if (bankAccount.getType() != null) {
//            account.setType(bankAccount.getType());
//        }
//
//        return bankAccountRepository.save(account);
//    }
//
//    @Operation(summary = "Supprimer un compte bancaire",
//            description = "Supprime un compte bancaire par son identifiant")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Compte supprimé"),
//            @ApiResponse(responseCode = "404", description = "Compte non trouvé")
//    })
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteAccount(
//            @Parameter(description = "ID du compte bancaire")
//            @PathVariable String id) {
//        BankAccount account = bankAccountRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException(
//                        String.format("Bank account with id %s not found", id)
//                ));
//        bankAccountRepository.delete(account);
//    }
//}
//on commenter ca pour voir les api sans ce code
package ma.emsi.bankaccountservice.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import ma.emsi.bankaccountservice.dto.BankAccountRequestDTO;
import ma.emsi.bankaccountservice.dto.BankAccountResponseDTO;
import ma.emsi.bankaccountservice.entities.BankAccount;
import ma.emsi.bankaccountservice.mappers.AccountMapper;
import ma.emsi.bankaccountservice.repositories.BankAccountRepository;
import ma.emsi.bankaccountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bankAccounts")
@Tag(name = "Bank Account", description = "API de gestion des comptes bancaires")
public class AccountRestController {

    private  BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Operation(summary = "Récupérer tous les comptes bancaires",
            description = "Retourne la liste de tous les comptes bancaires")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    @Operation(summary = "Récupérer un compte par ID",
            description = "Retourne un compte bancaire spécifique par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Compte trouvé"),
            @ApiResponse(responseCode = "404", description = "Compte non trouvé")
    })
    @GetMapping("/{id}")
    public BankAccount getBankAccount(
            @Parameter(description = "ID du compte bancaire")
            @PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Bank account with id %s not found", id)
                ));
    }

    @Operation(summary = "Créer un nouveau compte bancaire",
            description = "Crée un nouveau compte bancaire avec les informations fournies")
    @ApiResponse(responseCode = "201", description = "Compte créé avec succès")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        // Créer l'entité BankAccount à partir du DTO
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(requestDTO.getBalance())
                .currency(requestDTO.getCurrency())
                .type(requestDTO.getType())
                .build();

        // Sauvegarder l'entité
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        // Retourner le DTO de réponse
        return BankAccountResponseDTO.builder()
                .id(savedBankAccount.getId())
                .createdAt(savedBankAccount.getCreatedAt())
                .balance(savedBankAccount.getBalance())
                .currency(savedBankAccount.getCurrency())
                .type(savedBankAccount.getType())
                .build();
    }

    @Operation(summary = "Mettre à jour un compte bancaire",
            description = "Met à jour les informations d'un compte bancaire existant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Compte mis à jour"),
            @ApiResponse(responseCode = "404", description = "Compte non trouvé")
    })
    @PutMapping("/{id}")
    public BankAccount updateAccount(
            @Parameter(description = "ID du compte bancaire")
            @PathVariable String id,
            @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Bank account with id %s not found", id)
                ));

        if (bankAccount.getBalance() != null) {
            account.setBalance(bankAccount.getBalance());
        }
        if (bankAccount.getCurrency() != null) {
            account.setCurrency(bankAccount.getCurrency());
        }
        if (bankAccount.getType() != null) {
            account.setType(bankAccount.getType());
        }

        return bankAccountRepository.save(account);
    }

    @Operation(summary = "Supprimer un compte bancaire",
            description = "Supprime un compte bancaire par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Compte supprimé"),
            @ApiResponse(responseCode = "404", description = "Compte non trouvé")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(
            @Parameter(description = "ID du compte bancaire")
            @PathVariable String id) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Bank account with id %s not found", id)
                ));
        bankAccountRepository.delete(account);
    }
}