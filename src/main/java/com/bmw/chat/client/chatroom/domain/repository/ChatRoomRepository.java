package com.bmw.chat.client.chatroom.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.bmw.chat.client.chatroom.domain.model.ChatRoom;

public interface ChatRoomRepository extends CrudRepository<ChatRoom, String> {

}
