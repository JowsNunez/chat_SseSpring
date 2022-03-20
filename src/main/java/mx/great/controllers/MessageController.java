package mx.great.controllers;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {

    private Map<Integer, SseEmitter> emmiters = new HashMap<>();

    @RequestMapping(value = "/subscribe", consumes = MediaType.ALL_VALUE)
    public SseEmitter subscribe(@RequestParam Integer userId){

        SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);

        try{
            sseEmitter.send(SseEmitter.event().name("INIT"));
            emmiters.put(userId,sseEmitter);

        }catch (IOException e){
            emmiters.remove(sseEmitter);
        }
        sseEmitter.onCompletion(()-> emmiters.remove(sseEmitter));
        sseEmitter.onError((e)-> emmiters.remove(sseEmitter));
        sseEmitter.onTimeout(()-> emmiters.remove(sseEmitter));


        return sseEmitter;
    }


    @PostMapping("/dispatch")
    public void dispatcher (@RequestParam String message,
                                @RequestParam Integer userId){

        String data = new JSONObject()
                .put("message",message)
                .toString();

        SseEmitter sseEmiter = emmiters.get(userId);
        try{
            sseEmiter.send(SseEmitter.event().name("message").data(data));

        }catch (IOException e){
            emmiters.remove(sseEmiter);
        }

    }
}
