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
        if(user == null)
            user = "";
        network.put(user, topicsOfInterest);
    }

    @Override
    public void removeUser(String user) {
        if(network.containsKey(user))
            network.remove(user);
        else
            throw new IllegalArgumentException();
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
            if(userList.contains(topicOfInterest))
                userList.remove(topicOfInterest);
            else
                throw new IllegalArgumentException();
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
            topicList = new ArrayList<>(userList);
            for (int i = 1; i < network.size(); i++) {
                userList = network.get(users.get(i));
                for (TopicOfInterest topicOfInterest : userList) {
                    topic = topicOfInterest;
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
            userList = new ArrayList<>(network.get(user));
            if(!userList.isEmpty())
                return userList;
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
        List<String> users = new ArrayList<>(network.keySet());
        String user, topic;
        StringBuilder info = new StringBuilder("-: ");
        if(!users.isEmpty()) {
            int i, j;
            List<TopicOfInterest> userList;
            for(i = 0; i < users.size(); i++) {
                user = users.get(i);
                userList = network.get(user);
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
