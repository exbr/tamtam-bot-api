/*
 * ------------------------------------------------------------------------
 * TamTam chat Bot API
 * ------------------------------------------------------------------------
 * Copyright (C) 2018 Mail.Ru Group
 * ------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ------------------------------------------------------------------------
 */

package chat.tamtam.botapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;

/**
 * Chat
 */
public class Chat implements TamTamSerializable {

    private final Long chatId;
    private final ChatType type;
    private final ChatStatus status;
    private final String title;
    private final Image icon;
    private final Long lastEventTime;
    private final Integer participantsCount;
    private Long ownerId;
    private Map<String, Long> participants;

    @JsonCreator
    public Chat(@JsonProperty("chat_id") Long chatId, @JsonProperty("type") ChatType type, @JsonProperty("status") ChatStatus status, @JsonProperty("title") String title, @Nullable @JsonProperty("icon") Image icon, @JsonProperty("last_event_time") Long lastEventTime, @JsonProperty("participants_count") Integer participantsCount) { 
        this.chatId = chatId;
        this.type = type;
        this.status = status;
        this.title = title;
        this.icon = icon;
        this.lastEventTime = lastEventTime;
        this.participantsCount = participantsCount;
    }

    /**
    * Chats identifier
    * @return chatId
    **/
    @JsonProperty("chat_id")
    public Long getChatId() {
        return chatId;
    }

    /**
    * Type of chat. One of: dialog, chat, channel
    * @return type
    **/
    @JsonProperty("type")
    public ChatType getType() {
        return type;
    }

    /**
    * Chat status. One of:  - active: bot is active member of chat  - removed: bot was kicked  - left: bot intentionally left chat  - closed: chat was closed
    * @return status
    **/
    @JsonProperty("status")
    public ChatStatus getStatus() {
        return status;
    }

    /**
    * Visible title of chat
    * @return title
    **/
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
    * Icon of chat
    * @return icon
    **/
    @Nullable
    @JsonProperty("icon")
    public Image getIcon() {
        return icon;
    }

    /**
    * Time of last event occured in chat
    * @return lastEventTime
    **/
    @JsonProperty("last_event_time")
    public Long getLastEventTime() {
        return lastEventTime;
    }

    /**
    * Number of people in chat. Always 2 for &#x60;dialog&#x60; chat type
    * @return participantsCount
    **/
    @JsonProperty("participants_count")
    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public Chat ownerId(@Nullable Long ownerId) {
        this.setOwnerId(ownerId);
        return this;
    }

    /**
    * Identifier of chat owner. Visible only for chat admins
    * @return ownerId
    **/
    @Nullable
    @JsonProperty("owner_id")
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(@Nullable Long ownerId) {
        this.ownerId = ownerId;
    }

    public Chat participants(@Nullable Map<String, Long> participants) {
        this.setParticipants(participants);
        return this;
    }

    public Chat putParticipantsItem(String key, Long participantsItem) {
        if (this.participants == null) {
            this.participants = new HashMap<String, Long>();
        }

        this.participants.put(key, participantsItem);
        return this;
    }

    /**
    * Participants in chat with time of last activity. Visible only for chat admins
    * @return participants
    **/
    @Nullable
    @JsonProperty("participants")
    public Map<String, Long> getParticipants() {
        return participants;
    }

    public void setParticipants(@Nullable Map<String, Long> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        Chat other = (Chat) o;
        return Objects.equals(this.chatId, other.chatId) &&
            Objects.equals(this.type, other.type) &&
            Objects.equals(this.status, other.status) &&
            Objects.equals(this.title, other.title) &&
            Objects.equals(this.icon, other.icon) &&
            Objects.equals(this.lastEventTime, other.lastEventTime) &&
            Objects.equals(this.participantsCount, other.participantsCount) &&
            Objects.equals(this.ownerId, other.ownerId) &&
            Objects.equals(this.participants, other.participants);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (chatId != null ? chatId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (lastEventTime != null ? lastEventTime.hashCode() : 0);
        result = 31 * result + (participantsCount != null ? participantsCount.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (participants != null ? participants.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chat{"
            + " chatId='" + chatId + '\''
            + " type='" + type + '\''
            + " status='" + status + '\''
            + " title='" + title + '\''
            + " icon='" + icon + '\''
            + " lastEventTime='" + lastEventTime + '\''
            + " participantsCount='" + participantsCount + '\''
            + " ownerId='" + ownerId + '\''
            + " participants='" + participants + '\''
            + '}';
    }
}
