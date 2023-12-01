package newsAgency;

import java.util.List;

public interface NewsDistributor
{
    public void attach(Subscriber subscriber);
    public void detach(Subscriber subscriber);
    public void notifySubscribers(List<String> newsContent);
}
