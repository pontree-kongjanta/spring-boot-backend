package com.example.training.myApp4.api;

import com.example.training.myApp4.business.ChatBusiness;
import com.example.training.myApp4.request.ChatMessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatAPI {

    private final ChatBusiness chatBusiness;

    public ChatAPI(ChatBusiness chatBusiness) {
        this.chatBusiness = chatBusiness;
    }

    @PostMapping("/message")
    public ResponseEntity<Void> chat(@RequestBody ChatMessageRequest request){
        chatBusiness.getMessage(request);
        return ResponseEntity.ok().build();
    }
}
