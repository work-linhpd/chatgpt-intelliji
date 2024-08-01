package com.linhpd.chatgptintelliji.services

import com.intellij.openapi.components.PersistentStateComponent
import com.linhpd.chatgptintelliji.models.ChatHistoryState
import com.linhpd.chatgptintelliji.models.ChatMessage

class ChatHistoryService : PersistentStateComponent<ChatHistoryState> {
    private var chatHistoryState = ChatHistoryState()

    override fun getState(): ChatHistoryState = chatHistoryState

    override fun loadState(state: ChatHistoryState) {
        chatHistoryState = state
    }

    fun addMessage(sender: String, content: String) {
        chatHistoryState.messages.add(ChatMessage(sender, content, System.currentTimeMillis()))
    }

    fun getAllMessages(): List<ChatMessage> = chatHistoryState.messages
}