package e3;

import java.util.List;
import java.util.ArrayList;


public class NetMatrix implements NetworkManager {

    // The two lists are separated but I  ake sure their indexes are the same.
    private ArrayList<List<TopicOfInterest>> interests;
    private ArrayList<String> users;

    @Override
    public void setNetwork() {
        users = new ArrayList<>();
        interests = new ArrayList<>();
    }

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        users.add(user);
        interests.add(topicsOfInterest);
    }

    @Override
    public void removeUser(String user) {
        int index;
        if (users.contains(user)){
            index = users.indexOf(user);
            users.remove(index);
            interests.remove(index);
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        int index;
        List<TopicOfInterest> topicList;
        if (users.contains(user)){
            index = users.indexOf(user);
            topicList = interests.get(index);
            topicList.add(topicOfInterest);
            interests.set(index, topicList);
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        int index;
        List<TopicOfInterest> topicList;
        if (users.contains(user)){
            index = users.indexOf(user);
            topicList = interests.get(index);
            topicList.remove(topicOfInterest);
            interests.set(index, topicList);
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        return users;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        TopicOfInterest newTopic;
        int pos;
        List<TopicOfInterest> topicList, newList;
        if (interests.isEmpty())
            return null;
        else {
            topicList = interests.get(0);
            for (pos = 1; pos < interests.size(); pos++) {
                newList = interests.get(pos);
                for (TopicOfInterest topicOfInterest : newList) {
                    newTopic = topicOfInterest;
                    if (!topicList.contains(newTopic))
                        topicList.add(newTopic);
                }
            }
        }
        return topicList;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        int index;
        List<TopicOfInterest> topicList;
        if (users.contains(user)){
            index = users.indexOf(user);
            topicList = interests.get(index);
            return topicList;
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public List<TopicOfInterest> getInterestsCommon(String a, String b) {
        TopicOfInterest topicA;
        List<TopicOfInterest> topicList = null, listA, listB;
        int index;
        if (users.contains(a) && users.contains(b)) {
            index = users.indexOf(a);
            listA = interests.get(index);
            index = users.indexOf(b);
            listB = interests.get(index);
        }
        else
            throw new IllegalArgumentException();
        if(!listA.isEmpty() && !listB.isEmpty()) {
            topicList = new ArrayList<>();
            for (TopicOfInterest topicOfInterest : listA) {
                topicA = topicOfInterest;
                if (listB.contains(topicA))
                    topicList.add(topicA);
            }
        }
        return topicList;
    }

    @Override
    public void printNetwork() {
        String user, topic;
        StringBuilder info = new StringBuilder("-: ");
        int i, j;
        List<TopicOfInterest> userList;
        for(i = 0; i < users.size(); i++) {
            user = users.get(i);
            userList = interests.get(i);
            info.append(String.format("%" + 8 + "s", user)).append(":");
            for(j = 0; j < userList.size(); j++) {
                topic = userList.get(j).topic();
                info.append(String.format("%" + 8 + "s", topic));
            }
            info.append("\n-: ");
        }
        System.out.println(info);
    }
}
