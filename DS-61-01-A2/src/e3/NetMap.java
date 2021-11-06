package e3;

import java.util.*;

public class NetMap implements NetworkManager{

    Map<String, List<TopicOfInterest>> network;

    @Override
    public void setNetwork() {
        network = new HashMap<>();
    }

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        network.put(user, topicsOfInterest);
    }

    @Override
    public void removeUser(String user) {
        network.remove(user);
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        List<TopicOfInterest> userList;
        if (network.containsKey(user)) {
            userList = network.get(user);
            userList.add(topicOfInterest);
            network.replace(user, network.get(user), userList);
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        List<TopicOfInterest> userList;
        if (network.containsKey(user)) {
            userList = network.get(user);
            userList.remove(topicOfInterest);
            network.replace(user, network.get(user), userList);
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        if(!network.isEmpty())
            return new ArrayList<>(network.keySet());
        else
            return null;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        if(!network.isEmpty()) {
            List<String> users = new ArrayList<>(network.keySet());
            TopicOfInterest topic;
            List<TopicOfInterest> userList, topicList;
            userList = network.get(users.get(0));
            topicList = userList;
            for (int i = 1; i < network.size(); i++) {
                userList = network.get(users.get(i));
                for (int j = 0; j < userList.size(); j++) {
                    topic = userList.get(0);
                    if (!topicList.contains(topic))
                        topicList.add(topic);
                }
            }
            return topicList;
        }
        else
            return null;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        List<TopicOfInterest> userList;
        if(network.containsKey(user)) {
            userList = network.get(user);
            return userList;
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public List<TopicOfInterest> getInterestsCommon(String a, String b) {
        TopicOfInterest topicA;
        List<TopicOfInterest> topicList = null, listA, listB;
        if (network.containsKey(a) && network.containsKey(b)) {
            listA = network.get(a);
            listB = network.get(b);
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
        List<String> users = new ArrayList<>(network.keySet());
        String user, topic;
        StringBuilder info = new StringBuilder("-: ");
        int i, j;
        List<TopicOfInterest> userList;
        for(i = 0; i < users.size(); i++) {
            user = users.get(i);
            userList = network.get(user);
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
