package uz.pdp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class MessageGroup {

   private UUID id;
   private User fromWhom;
   private Group toGroup;
   private boolean isRead;
    private LocalDateTime dateTime;
   private String sms;

    public MessageGroup(User fromWhom, Group toGroup, String sms) {
        this.fromWhom = fromWhom;
        this.toGroup = toGroup;
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

    public Group getToGroup() {
        return toGroup;
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

    public void setToGroup(Group toGroup) {
        this.toGroup = toGroup;
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
        return   sms + "    from:" + fromWhom.getUsername() +
                "  " + dateTime;
    }
}
