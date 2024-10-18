package com.example.training.myApp4.business;

import com.example.training.myApp4.model.ChatMessage;
import com.example.training.myApp4.request.ChatMessageRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatBusiness {

    private final SimpMessagingTemplate template;

    public ChatBusiness(SimpMessagingTemplate messagingTemplate) {
        this.template = messagingTemplate;
    }

    public void getMessage(ChatMessageRequest request){
        String destination = "/topic/chat";
        ChatMessage payload = new ChatMessage();
        payload.setFrom("user test");
        payload.setMessage(request.getMessage());
        template.convertAndSend(destination,payload);
    }

}
