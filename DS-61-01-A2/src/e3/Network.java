package e3;


import java.util.List;

public record Network(NetworkManager manager) {

    void setNetwork() { manager.setNetwork(); }

    void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        manager.addUser(user, topicsOfInterest);
    }

    void removeUser(String user) {
        manager.removeUser(user);
    }

    void addInterest(String user, TopicOfInterest topicOfInterest) {
        manager.addInterest(user, topicOfInterest);
    }

    void removeInterest(String user, TopicOfInterest topicOfInterest) {
        manager.removeInterest(user, topicOfInterest);
    }

    List<String> getUsers() {
        return manager.getUsers();
    }

    List<TopicOfInterest> getInterests() {
        return manager.getInterests();
    }

    List<TopicOfInterest> getInterestsUser(String user) {
        return manager.getInterestsUser(user);
    }

    List<TopicOfInterest> getInterestsCommon(String a, String b) {
        return manager.getInterestsCommon(a, b);
    }

    String printNetwork() {
        return manager.printNetwork();
    }


}
