package mx.great.services;


import mx.great.models.Message;
import mx.great.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService implements IMessageService {


    private IMessageRepository iMessageRepository;
    @Autowired
    public void setInjectedBean(IMessageRepository iMessageRepository) {
        this.iMessageRepository = iMessageRepository;
    }

    public Message create(Message newMessage){


             return  this.iMessageRepository.save(newMessage);
    }

}
