package mx.great.services;

import mx.great.models.User;
import mx.great.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public User create (User name){

        return this.iUserRepository.save(name);

    }


}
