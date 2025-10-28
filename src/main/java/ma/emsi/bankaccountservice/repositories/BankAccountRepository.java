package ma.emsi.bankaccountservice.repositories;

import ma.emsi.bankaccountservice.entities.BankAccount;
import ma.emsi.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.lang.reflect.Type;
import java.util.List;

@RepositoryRestResource
//demander a spring stp au démarrage demmarer moi un web service restful qui permet de gérer une entité de type bankaccount get put delete
public interface BankAccountRepository  extends JpaRepository<BankAccount, String> {
    // Spring Data REST génère automatiquement les endpoints :
    // GET    /bankAccounts          -> Liste tous les comptes
    // GET    /bankAccounts/{id}     -> Obtenir un compte par ID
    // POST   /bankAccounts          -> Créer un nouveau compte
    // PUT    /bankAccounts/{id}     -> Mettre à jour un compte
    // PATCH  /bankAccounts/{id}     -> Mise à jour partielle
    // DELETE /bankAccounts/{id}     -> Supprimer un compte

    // Recherche par type de compte

    @RestResource(path = "byType")
    List<BankAccount> findByType(@Param("type") AccountType type);
}
