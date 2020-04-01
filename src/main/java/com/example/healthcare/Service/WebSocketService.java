package com.example.healthcare.Service;


import com.example.healthcare.bean.InMessage;
import com.example.healthcare.bean.OutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendTopicMessage(String dest, InMessage message){
        for (int i = 0; i <20 ; i++) {
            template.convertAndSend(dest, new OutMessage(message.getContent()+i));
        }
    }

    public void SendChatMessage(InMessage message){
        System.out.println(message);
        template.convertAndSend("/chat/single/"+message.getTo(),
                new OutMessage(message.getContent()+""));
    }
}
