package newsAgency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
        boolean exit = false;
        NewsAgency newsAgency = new NewsAgency();
        Subscriber subscriber = new Subscriber();
        subscriber.setSubscriberName("Marianne");
        newsAgency.attach(subscriber);
        List<String> headlines = new ArrayList<>();
        headlines.add("Duck Quacks Loud!");
        newsAgency.setHeadlines(headlines);

        List<String> newsContent = new ArrayList<>();
        newsContent.add("Local duck, Marianne, was visited by the Guinea Pig World Record Office because of a" +
                " record-setting volume in one quack. Two turtles, Rachelle and Vem, congratulated their friend and gave her peas.");
        newsAgency.setNewsContent(newsContent);

        Scanner input = new Scanner(System.in);

        while (!exit)
        {
            System.out.println("Welcome to the News Cycle Simulation!\nLog-in here!");
            System.out.print("[1] User\n[2] Admin\n[0] Exit\nSelect here: ");

            int userType = input.nextInt();
            input.nextLine();

            switch(userType)
            {
                case 0: exit = true;
                        break;
                case 1: System.out.println("Welcome, user!");
                        subscriberSelection(newsAgency);
                        break;
                case 2: System.out.println("Let's break some news!");
                        newsCreation(newsAgency);
                        break;
            }
        }
    }

    private static void subscriberSelection(NewsAgency newsAgency)
    {
        Scanner input = new Scanner(System.in);
        List<Subscriber> subscribers =  newsAgency.getSubscriberList();
        boolean exit = false;

        while (!exit)
        {
            System.out.println("Select account");
            System.out.println("[1] Sign up here!");
            for(int i = 0; i < subscribers.size(); i++)
            {
                System.out.println("[" + (i + 2) + "] " + subscribers.get(i));
            }
            System.out.println("[0] Exit");
            System.out.print("Select: ");

            int process = input.nextInt();
            input.nextLine();

            Subscriber subscriber = new Subscriber();
            switch(process)
            {
                case 0:     exit = true;
                            break;

                case 1:     System.out.print("Enter name: ");
                            String newSubscriberName = input.next();

                            subscriber.setSubscriberName(newSubscriberName);

                            newsAgency.attach(subscriber);

                            System.out.println("Welcome to the Simulation Family, " + subscriber.getSubscriberName() + "!");
                            subscriberSelection(newsAgency);
                            break;

                default:    if (process - 2 >= 0 && process - 2 < subscribers.size()) 
                            {
                                Subscriber existingSubscriber = subscribers.get(process - 2);
                                System.out.println("Hello, " + existingSubscriber.getSubscriberName() + "!");

                                boolean breakingNewsNotified = false;
                                if (!breakingNewsNotified) 
                                {
                                    newsAgency.notifySubscribers(newsAgency.getHeadline());
                                    breakingNewsNotified = true; // Set the flag to true after notifying
                                }
                                boolean exit1 = false;
                                while (!exit1)
                                {
                                    System.out.println("Menu:\n[1] View News\n[2] Unsubscribe\n[0] Exit");
                                    System.out.print("Select: ");
                                    int action = input.nextInt();
                                    input.nextLine();
                                    switch (action)
                                    {
                                        case 0: exit1 = true;
                                                break;
                                        case 1: newsSelection(newsAgency);
                                                break;
                                        case 2: System.out.println("Thank you, " + existingSubscriber.getSubscriberName() + ". We'll miss you!");
                                                newsAgency.detach(existingSubscriber);
                                                exit1 = true;
                                                break;
                                    }
                                }
                            }

            }
        }
        
    }

    private static void newsSelection(NewsAgency newsAgency) 
    {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit)
        {
            System.out.println("Pick an article: ");
            List<String> availableArticles = newsAgency.getHeadline();
            List<String> availableNewsContent = newsAgency.getNewsContent();

            for (int i = 0; i < availableArticles.size(); i++) 
            {
                System.out.println("[" + (i + 1) + "] " + availableArticles.get(i));
            }
            System.out.println("[0] Exit");

            System.out.print("Select: ");
            int selectedArticleIndex = input.nextInt();

            if (selectedArticleIndex == 0)
            {
                exit = true;
                break;
            }
            else if (selectedArticleIndex >= 1 && selectedArticleIndex <= availableArticles.size()) 
            {
                String selectedArticle = availableArticles.get(selectedArticleIndex - 1);
                String selectedArticleContent = availableNewsContent.get(selectedArticleIndex - 1);

                System.out.println("\n" + selectedArticle);
                System.out.println("\n" + selectedArticleContent);
            }
        }
        if (!exit) {
            newsSelection(newsAgency);
        }
    }

    private static void newsCreation(NewsAgency newsAgency) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter headline:");
        String headline = input.nextLine();
        System.out.println("Enter news content:");
        String newsContent = input.nextLine();

        newsAgency.addHeadline(headline);
        newsAgency.addNewsContent(newsContent);
    }
}
