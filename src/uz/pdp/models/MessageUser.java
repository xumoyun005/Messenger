package uz.pdp.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessageUser {

    private UUID id;
    private User fromWhom;
    private User toWhom;
    private boolean isRead;
    private LocalDateTime dateTime;
    private String sms;

    public MessageUser(User fromWhom, User toWhom, String sms) {
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.sms = sms;
        this.id = UUID.randomUUID();
        this.isRead = false;
        this.dateTime  = LocalDateTime.of(LocalDateTime.now().getYear(),LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(),LocalDateTime.now().getHour(),LocalDateTime.now().getMinute());
    }

    public UUID getId() {
        return id;
    }

    public User getFromWhom() {
        return fromWhom;
    }

    public User getToWhom() {
        return toWhom;
    }

    public boolean isRead() {
        return isRead;
    }


    public String getSms() {
        return sms;
    }

    public void setFromWhom(User fromWhom) {
        this.fromWhom = fromWhom;
    }

    public void setToWhom(User toWhom) {
        this.toWhom = toWhom;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    @Override
    public String toString() {
        return sms + "    from:" + fromWhom.getUsername() +
                "  " + dateTime;
    }
}
