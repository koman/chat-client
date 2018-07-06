package com.bmw.chat.client.chatroom.domain.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.bmw.chat.client.chatroom.domain.model.InstantMessage;

public interface InstantMessageRepository extends CassandraRepository<InstantMessage> {
	
	List<InstantMessage> findInstantMessagesByUsernameAndChatRoomId(String username, String chatRoomId);
}
