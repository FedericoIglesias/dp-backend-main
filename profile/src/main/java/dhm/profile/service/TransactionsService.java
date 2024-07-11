package dhm.profile.service;

import dhm.profile.model.Transactions;
import dhm.profile.repository.ITransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

    @Autowired
    ITransactionsRepository repoHistory;
    public List<Transactions> getTransactionsUser(Integer id) {
        List<Transactions> listHistory = null;
        List<Transactions> listReturnHistory = repoHistory.findAll();

        for(Transactions history : listReturnHistory){
            if(history.getId().equals(id)){
                listHistory.add(history);
            }
        }
        return listHistory;
    }
}
