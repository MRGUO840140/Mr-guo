package com.example.healthcare.Controller;


import com.example.healthcare.Service.WebSocketService;
import com.example.healthcare.bean.InMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private WebSocketService ws;

    @MessageMapping("/single/chat")
    public void singleChat(InMessage inMessage){
        System.out.println(inMessage);
        ws.SendChatMessage(inMessage);
    }
}
