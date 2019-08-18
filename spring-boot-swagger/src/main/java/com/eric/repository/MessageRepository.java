package com.eric.repository;

import com.eric.model.Message;

import java.util.List;

/**
 * @author eric
 */
public interface MessageRepository {

    List<Message> findAll();

    Message save(Message message);

    Message update(Message message);

    Message updateText(Message message);

    Message findMessage(Long id);

    void deleteMessage(Long id);
}
