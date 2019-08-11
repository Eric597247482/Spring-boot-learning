package com.eric.controller;


import com.eric.model.Message;
import com.eric.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author eric
 */
@RestController
@RequestMapping("/")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;


    /**
     * return all messages
     * @return
     */
    @GetMapping(value = "messages")
    public List<Message> list() {
        List<Message> messages = this.messageRepository.findAll();
        return messages;
    }


    /**
     * create message
     * @param message
     * @return
     */
    @PostMapping(value = "message")
    public Message create(Message message) {
        this.messageRepository.save(message);
        return message;
    }

    /**
     * update message
     * @param message
     * @return
     */
    @PutMapping(value = "message")
    public Message update(Message message) {
        Message messageResult = this.messageRepository.update(message);
        return messageResult;
    }

    /**
     * 更新消息的text字段
     * partially update the content of the message
     * @param message
     * @return
     */
    @PatchMapping(value = "message/text")
    public Message patch(Message message) {
        Message messageResult = this.messageRepository.updateText(message);
        return messageResult;
    }


    /**
     * get message by id
     * @param id
     * @return
     */
    @GetMapping(value = "message/{id}")
    public Message get(@PathVariable Long id) {
        return this.messageRepository.findMessage(id);
    }

    /**
     * delete message by id
     * @param id
     */
    @DeleteMapping(value = "message/{id}")
    public void delete(@PathVariable Long id) {
        this.messageRepository.deleteMessage(id);
    }

}
