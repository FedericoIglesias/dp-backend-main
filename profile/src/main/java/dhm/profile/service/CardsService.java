package dhm.profile.service;

import dhm.profile.model.Cards;
import dhm.profile.repository.ICardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardsService {

    @Autowired
    ICardsRepository repoCards;

    public List<Cards> getListCards(Integer idUser) {
     List<Cards> listCards = new ArrayList();

        for(Cards card: repoCards.findAll()){
         if(card.getUsers().getId().equals(idUser)){
             listCards.add(card);
         }
     }
        return listCards;
    }

    public Cards getCard(Integer idUser, Integer idCard) {
        Cards card = repoCards.findById(idCard).orElse(null);
        if (card == null || !card.getUsers().getId().equals(idUser)){
            return null;
        }
        return card;

    }
}
