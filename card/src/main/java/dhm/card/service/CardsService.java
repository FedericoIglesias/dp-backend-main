package dhm.card.service;

import dhm.card.model.Cards;
import dhm.card.repository.ICardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsService {
    @Autowired
    ICardsRepository repoCards;

    public List<Cards> getListCards(){
        return repoCards.findAll();
    }

    public Cards getCard(Integer id){
        return repoCards.findById(id).orElse(null);
    }

    public Integer saveCards(Cards card){
        Cards res= repoCards.findByNumber(card.getNumber());
        if(res == null){
            repoCards.save(card);
            return 1;
        }
        return 0;

    }

    public void deleteCard(Integer id){
        repoCards.deleteById(id);
    }

    public String modifyCard(Integer id, Cards card){
        Cards oldCard = getCard(id);
        if(oldCard == null){
            return "Unsuccessful to find card";
        }
        oldCard.setCvv(card.getCvv());
        oldCard.setBank(card.getBank());
        oldCard.setEndDate(card.getEndDate());
        oldCard.setCvv(card.getCvv());

        saveCards(oldCard);

        return "Success to modify card";
    }

    public List<Cards> getUserCards(Integer idUser) {
        return repoCards.findByAccountId(idUser);
    }

    public Integer deleteCardFromAccount(Integer id) {
        Cards res= repoCards.findById(id).orElse(null);
        if(res == null){
            return 0;
        }
        repoCards.deleteById(id);
        return 1;
    }
}
