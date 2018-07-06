package com.bmw.chat.client.chatroom.domain.service;

import java.util.List;

import com.bmw.chat.client.chatroom.domain.model.InstantMessage;

public interface InstantMessageService {
	
	void appendInstantMessageToConversations(InstantMessage instantMessage);
	List<InstantMessage> findAllInstantMessagesFor(String username, String chatRoomId);
}
