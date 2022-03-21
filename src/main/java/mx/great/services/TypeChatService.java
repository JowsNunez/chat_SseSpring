package mx.great.services;

import mx.great.models.Typechat;
import mx.great.repositories.TypechatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeChatService implements ITypeChatService{
    @Autowired
    private TypechatRepository _typeChatRepository;
    @Override
    public Typechat getTypeChat(Integer typeChatId) {
        return this._typeChatRepository.getById(typeChatId);
    }
}
