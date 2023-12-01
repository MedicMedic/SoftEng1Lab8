package newsAgency;

import java.util.List;

public class Subscriber implements PushNotifications{

    private String subscriberName;


    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void updateNews(List<String> newsContent) {
        for (String news : newsContent) {
            System.out.println("Breaking News: " + news);
        }
    }


    @Override
    public String toString() {
        return subscriberName;
    }
}