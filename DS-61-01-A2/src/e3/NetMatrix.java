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
        if(user == null)
            user = "";
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
            if(topicList.contains(topicOfInterest))
                topicList.remove(topicOfInterest);
            else
                throw new IllegalArgumentException();
            interests.set(index, topicList);
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        if(!users.isEmpty())
            return users;
        else
            return null;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        TopicOfInterest newTopic;
        int pos;
        List<TopicOfInterest> topicList, newList;
        if (interests.isEmpty())
            return null;
        else {
            topicList = new ArrayList<>(interests.get(0));
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
            topicList = new ArrayList<>(interests.get(index));
            if(!topicList.isEmpty())
                return topicList;
            else
                return null;
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public List<TopicOfInterest> getInterestsCommon(String a, String b) {
        TopicOfInterest topicA;
        List<TopicOfInterest> topicList, listA, listB;
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
            if(topicList.isEmpty())
                return null;
            else
                return topicList;
        }
        else
            return null;
    }

    @Override
    public String printNetwork() {
        String user, topic;
        StringBuilder info = new StringBuilder("-: ");
        int i, j;
        List<TopicOfInterest> userList;
        if(!users.isEmpty()) {
            for(i = 0; i < users.size(); i++) {
                user = users.get(i);
                userList = interests.get(i);
                info.append(user).append(": ");
                if(!userList.isEmpty()) {
                    topic = userList.get(0).topic();
                    info.append(topic);
                    for (j = 1; j < userList.size(); j++) {
                        topic = userList.get(j).topic();
                        info.append(", ").append(topic);
                    }
                }
                else
                    info.append("[No interests found]");
                if(i+1 != users.size())
                    info.append("\n-: ");
            }
        }
        else {
            info = new StringBuilder("[No users found]");
        }
        System.out.println(info);
        return String.valueOf(info);
    }
}
