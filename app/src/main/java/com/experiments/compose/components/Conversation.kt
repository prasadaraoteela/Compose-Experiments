package com.experiments.compose.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.experiments.compose.data.SampleData
import com.experiments.compose.data.model.Message

/**
 * Created by Prasada Rao on 13/11/21 12:50 PM
 **/
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message = message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    Conversation(messages = SampleData.conversationSample)
}