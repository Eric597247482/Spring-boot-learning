package com.eric.repository;

import com.eric.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author eric
 */
@Service("messageRepository")
public class InMemoryMessageRepository implements MessageRepository {
    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentHashMap<Long, Message> messages = new ConcurrentHashMap<>();

    @Override
    public List<Message> findAll() {
        List<Message> messageList = new ArrayList<Message>(this.messages.values());
        return messageList;
    }

    @Override
    public Message save(Message message) {
        Long id = message.getId();
        if (id == null) {
            id = counter.getAndIncrement();
            message.setId(id);
        }
        this.messages.put(id, message);
        return message;
    }

    @Override
    public Message update(Message message) {
        this.messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message updateText(Message message) {
        Message msg = this.messages.get(message.getId());
        msg.setText(message.getText());
        this.messages.put(message.getId(), msg);
        return msg;
    }

    @Override
    public Message findMessage(Long id) {
        return this.messages.get(id);
    }

    @Override
    public void deleteMessage(Long id) {
        this.messages.remove(id);
    }
}
