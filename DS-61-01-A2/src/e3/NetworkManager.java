package e3;
import java.util.List;
public interface NetworkManager {
    void setNetwork();

    void addUser(String user, List<TopicOfInterest> topicsOfInterest);
    //adds a user to the network.
    void removeUser(String user);
    //removes a user from the network.
    void addInterest(String user, TopicOfInterest topicOfInterest);
    //adds a topic of interest to a given user of the network.
    void removeInterest(String user, TopicOfInterest topicOfInterest);
    //removes a topic of interest for a given user of the network.
    List<String> getUsers();
    //returns a list with all the registered users.
    List<TopicOfInterest> getInterests();
    //returns a list with all the topics that the users are interested in.
    List<TopicOfInterest> getInterestsUser(String user);
    //returns the topics of interest for a given user.

    List<TopicOfInterest> getInterestsCommon(String a, String b);
    String printNetwork();
}
