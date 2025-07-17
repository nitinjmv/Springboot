package com.jmv.controller;

import com.jmv.service.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
@RequiredArgsConstructor
public class SendMsgContoller {

    private final MessageSender sender;

    @PostMapping
    public ResponseEntity<String> send(@RequestBody String msg) {
        sender.send(msg);
        return ResponseEntity.ok("Message sent");
    }
}
