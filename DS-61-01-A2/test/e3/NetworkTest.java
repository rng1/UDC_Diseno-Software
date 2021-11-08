package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkTest {

    private Network matrixNetwork;
    private Network mapNetwork;

    @BeforeEach
    void setUp() {
        matrixNetwork = new Network(new NetMatrix());
        matrixNetwork.addUser("user1", new ArrayList<>());
        matrixNetwork.addUser("user2", new ArrayList<>());
        matrixNetwork.addUser("user3", new ArrayList<>());
        matrixNetwork.addUser("user4", new ArrayList<>());
        matrixNetwork.addInterest("user1", new TopicOfInterest("Sports"));
        matrixNetwork.addInterest("user1", new TopicOfInterest("Art"));
        matrixNetwork.addInterest("user1", new TopicOfInterest("Computers"));
        matrixNetwork.addInterest("user2", new TopicOfInterest("Sports"));
        matrixNetwork.addInterest("user2", new TopicOfInterest("Adventure"));
        matrixNetwork.addInterest("user3", new TopicOfInterest("Art"));
        matrixNetwork.addInterest("user3", new TopicOfInterest("Literature"));
        matrixNetwork.addInterest("user4", new TopicOfInterest("Computers"));
        matrixNetwork.addInterest("user4", new TopicOfInterest("Videogames"));

        mapNetwork = new Network(new NetMap());
        mapNetwork.addUser("user1", new ArrayList<>());
        mapNetwork.addUser("user2", new ArrayList<>());
        mapNetwork.addUser("user3", new ArrayList<>());
        mapNetwork.addUser("user4", new ArrayList<>());
        mapNetwork.addInterest("user1", new TopicOfInterest("Sports"));
        mapNetwork.addInterest("user1", new TopicOfInterest("Art"));
        mapNetwork.addInterest("user1", new TopicOfInterest("Computers"));
        mapNetwork.addInterest("user2", new TopicOfInterest("Sports"));
        mapNetwork.addInterest("user2", new TopicOfInterest("Adventure"));
        mapNetwork.addInterest("user3", new TopicOfInterest("Art"));
        mapNetwork.addInterest("user3", new TopicOfInterest("Literature"));
        mapNetwork.addInterest("user4", new TopicOfInterest("Computers"));
        mapNetwork.addInterest("user4", new TopicOfInterest("Videogames"));
    }

    @Test
    void testGets(){
        ArrayList<String> users = new ArrayList<>();
        users.add("user1");
        users.add("user2");
        users.add("user3");
        users.add("user4");

        assertEquals(users, matrixNetwork.getUsers());
        assertEquals(users, mapNetwork.getUsers());

        ArrayList<String> interests = new ArrayList<>();
        interests.add("Sports");
        interests.add("Art");
        interests.add("Computers");
        interests.add("Adventure");
        interests.add("Literature");
        interests.add("Videogames");

        assertEquals(users, matrixNetwork.getInterests());
        assertEquals(users, mapNetwork.getInterests());

    }
}
