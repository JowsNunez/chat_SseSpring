package mx.great.services;

import mx.great.models.Chat;
import mx.great.models.Chatuser;
import mx.great.models.Typechat;
import mx.great.models.User;
import mx.great.repositories.ChatRepository;
import mx.great.repositories.ChatUserRepository;
import mx.great.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChatUserService implements IChatUserService{

    @Autowired
    private ChatUserRepository _chatUserRepository;
     @Autowired
    private ChatRepository _chatRepository;
    @Autowired
    private IUserRepository _userRepository;
    @Autowired
    private TypeChatService _TypeChatService;
    @Override
    public boolean create(ArrayList<Integer> usersId, Integer type) {
        ArrayList<Chatuser> list = new ArrayList<>();

        Typechat typeChat =_TypeChatService.getTypeChat(type);
        Chat aux = new Chat();
        aux.setTypechat(typeChat);
        aux.setCreateAt(new Date());
        Chat newaux = this._chatRepository.save(aux);
        Chatuser aux2;
        System.out.println(usersId);

        for ( int i = 0;  i < usersId.size(); i++) {
            if(usersId.get(i)!=null) {
                aux2 = new Chatuser();
                User userAux = this._userRepository.getById(usersId.get(i));
                aux2.setUser(userAux);
                aux2.setChat(newaux);

                Chatuser added = this._chatUserRepository.save(aux2);

                list.add(added);
            }
        }

        System.out.println(list);

        return !list.isEmpty()? true : false;
    }
}
