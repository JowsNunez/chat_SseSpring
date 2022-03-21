package mx.great.controllers;

import mx.great.DTO.createChatDTO;
import mx.great.models.User;
import mx.great.services.ChatUserService;
import mx.great.services.MessageService;
import mx.great.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    public UserService _iUserService;
    @Autowired
    public MessageService _iMessageService;

    @Autowired
    public ChatUserService _chatUserService;

    @RequestMapping(value = "/create", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser (@Validated  @RequestBody User newUser){
        newUser.setUpdateAt(new Date());
        newUser.setCreateAt(new Date());

        System.out.println(newUser);
        User aux =  this._iUserService.create(newUser);
        return  ResponseEntity.ok().body( new HashMap<String, Object>(){{
            put("status","Success");
            put("user",aux);

        }});
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMsg (  @RequestBody createChatDTO a){

      boolean is =this._chatUserService.create(a.getUsersId(),a.getType());

        return  ResponseEntity.ok().body( new HashMap<String, Object>(){{
            put("status",is);


        }});
    }


}






