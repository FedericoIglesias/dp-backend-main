package dhm.transacctions.service;

import dhm.transacctions.model.Transactions;
import dhm.transacctions.repository.ITransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

    @Autowired
    ITransactionsRepository repoTransactions;

    public List<Transactions> getListTransactions(){
     return repoTransactions.findAll();
    }

    public Transactions getTransaction(Integer id){
        return repoTransactions.findById(id).orElse(null);
    }

    public  void saveTransaction(Transactions transaction){
        repoTransactions.save(transaction);
    }

    public List<Transactions> getAccountTransactions(Integer id){
        return repoTransactions.findByAccount(id);
    }

}
