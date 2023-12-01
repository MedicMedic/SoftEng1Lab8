package newsAgency;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements NewsDistributor
{
    private List<String> headline;
    private List<String> newsContent;
    private List<Subscriber> subscriberList;

    public void addHeadline(String headline) 
    {
        this.headline.add(headline);
    }

    public void addNewsContent(String content) {
        this.newsContent.add(content);
    }

    public List<String> getHeadline() 
    {
        return headline;
    }

    public void setHeadlines(List<String> headline) 
    {
        this.headline = headline;
    }

    public List<String> getNewsContent() 
    {
        return newsContent;
    }

    public void setNewsContent(List<String> newsContent) {
        this.newsContent = newsContent;
    }

    public List<Subscriber> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(List<Subscriber> subscriberList) {
        this.subscriberList = subscriberList;
    }

    @Override
    public void attach(Subscriber subscriber) 
    {
            subscriberList.add(subscriber);
    }

    @Override
    public void detach(Subscriber subscriber) 
    {
          subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscribers(List<String> headlines) 
    {
        for (Subscriber subscriber : subscriberList) {
            subscriber.updateNews(headlines);
        }
    }
    
    public NewsAgency()
    {
        this.subscriberList = new ArrayList<>();
    }
    
}
