package chat.tamtam.api.objects;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import chat.tamtam.api.objects.attachment.TTAttachment;

/**
 * @author alexandrchuprin
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class TTMessage implements Serializable {
    private static final String SENDER = "sender";
    private static final String RECEPIENT = "recepient";
    private static final String MESSAGE = "message";
    private static final String TIMESTAMP = "timestamp";
    private static final String MID = "mid";
    private static final String SEQ = "seq";
    private static final String TEXT = "text";
    private static final String ATTACHMENTS = "attachments";
    private static final String REPLY_TO = "reply_to";

    private final TTUser sender;
    private final TTRecepient recipient;
    private final TTMessagePayload message;
    private final long timestamp;

    public TTMessage(TTUser sender, TTRecepient recipient, long timestamp, String messageId, long seq, String text,
                     List<TTAttachment> attachments, String replyTo) {
        this(sender, recipient, new TTMessagePayload(messageId, seq, text, attachments, replyTo), timestamp);
    }

    @JsonCreator
    private TTMessage(@JsonProperty(SENDER) TTUser sender, @JsonProperty(RECEPIENT) TTRecepient recipient,
                      @JsonProperty(MESSAGE) TTMessagePayload message, @JsonProperty(TIMESTAMP) long timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.timestamp = timestamp;
    }

    @JsonProperty(SENDER)
    public TTUser getSender() {
        return sender;
    }

    @JsonProperty(RECEPIENT)
    public TTRecepient getRecipient() {
        return recipient;
    }

    @JsonProperty(MESSAGE)
    protected TTMessagePayload getMessage() {
        return message;
    }

    @JsonProperty(TIMESTAMP)
    public long getTimestamp() {
        return timestamp;
    }

    public String getText() {
        return message.text;
    }

    public List<TTAttachment> getAttachments() {
        return message.attachments;
    }

    public String getMessageId() {
        return message.messageId;
    }

    private static class TTMessagePayload {
        @JsonProperty(MID)
        private final String messageId;
        @JsonProperty(SEQ)
        private final long seq;
        private final String text;
        private final List<TTAttachment> attachments;
        @JsonProperty(REPLY_TO)
        private final String replyTo;

        @JsonCreator
        private TTMessagePayload(@JsonProperty(MID) String messageId, @JsonProperty(SEQ) long seq,
                                 @JsonProperty(TEXT) String text,
                                 @JsonProperty(ATTACHMENTS) List<TTAttachment> attachments,
                                 @JsonProperty(REPLY_TO) String replyTo) {
            this.messageId = messageId;
            this.seq = seq;
            this.text = text;
            this.attachments = attachments;
            this.replyTo = replyTo;
        }
    }
}