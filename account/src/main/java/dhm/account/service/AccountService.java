package dhm.account.service;

import dhm.account.model.Accounts;
import dhm.account.model.Cards;
import dhm.account.model.Transactions;
import dhm.account.repository.IAccountsRepository;
import dhm.account.repository.IFeignCardsRepository;
import dhm.account.repository.IFeignTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    IFeignTransactionsRepository feignTransaction;
    @Autowired
    IFeignCardsRepository feignCards;

    @Autowired
    IAccountsRepository repoAccount;


    public List<Cards> getCardsAccount(Integer idUser){
        return feignCards.getCards(idUser);
    }
    public List<Transactions> getListTransactionUser(Integer id){

        return feignTransaction.getTransaction(id);
    }

    public Cards getCard(Integer id){
        return feignCards.getCard(id);
    }

    public Double getAmount (Integer id){
        Accounts account = repoAccount.findById(id).orElse(null);
        if(account == null){
            return null;
        }
        return account.getAmount();
    }

    public void saveAccount(Accounts account){
        repoAccount.save(account);
    }

    public Accounts getAccount(Integer id) {
        return repoAccount.findById(id).orElse(null);
    }

    public String modifyAccount(Integer id, Accounts account) {
         Accounts oldAccount =repoAccount.findById(id).orElse(null);
         if(oldAccount == null){
             return "Unsuccessful to found Id";
         }

         oldAccount.setAlias(account.getAlias());
         oldAccount.setName(account.getName());
         oldAccount.setLastname(account.getLastname());
         oldAccount.setPhone(account.getPhone());
         repoAccount.save(oldAccount);

         return "Success to modify Account";
    }

    public Integer saveCard(Cards card) {
        return feignCards.saveCard(card);
    }

    public Integer deleteCard(Integer idCard) {
        return feignCards.deleteCard(idCard);
    }
}
