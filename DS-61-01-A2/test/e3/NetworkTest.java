package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class NetworkTest {

    private Network matrixNetwork;
    private Network mapNetwork;

    @BeforeEach
    void setUp() {
        matrixNetwork = new Network(new NetMatrix());
        matrixNetwork.setNetwork();
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
        mapNetwork.setNetwork();
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
    void testReading(){
        ArrayList<String> users = new ArrayList<>();
        users.add("user1");
        users.add("user2");
        users.add("user3");
        users.add("user4");

        assertEquals(users, matrixNetwork.getUsers());
        assertEquals(users, mapNetwork.getUsers());
        assertEquals(matrixNetwork.getUsers(),  mapNetwork.getUsers());

        ArrayList<TopicOfInterest> interests = new ArrayList<>();
        interests.add(new TopicOfInterest("Sports"));
        interests.add(new TopicOfInterest("Art"));
        interests.add(new TopicOfInterest("Computers"));
        interests.add(new TopicOfInterest("Adventure"));
        interests.add(new TopicOfInterest("Literature"));
        interests.add(new TopicOfInterest("Videogames"));

        assertEquals(interests, matrixNetwork.getInterests());
        assertEquals(interests, mapNetwork.getInterests());
        assertEquals(matrixNetwork.getInterests(), mapNetwork.getInterests());

        ArrayList<TopicOfInterest> user_interests = new ArrayList<>();
        user_interests.add(new TopicOfInterest("Sports"));
        user_interests.add(new TopicOfInterest("Art"));
        user_interests.add(new TopicOfInterest("Computers"));

        assertEquals(user_interests, matrixNetwork.getInterestsUser("user1"));
        assertEquals(user_interests, mapNetwork.getInterestsUser("user1"));
        assertEquals(matrixNetwork.getInterestsUser("user1"), mapNetwork.getInterestsUser("user1"));

        ArrayList<TopicOfInterest> common_interests = new ArrayList<>();
        common_interests.add(new TopicOfInterest("Sports"));

        assertEquals(common_interests, matrixNetwork.getInterestsCommon("user1", "user2"));
        assertEquals(common_interests, mapNetwork.getInterestsCommon("user1", "user2"));
        assertEquals(mapNetwork.getInterestsCommon("user1", "user2"), matrixNetwork.getInterestsCommon("user1", "user2"));

        mapNetwork.addInterest("user1", new TopicOfInterest("extra"));
        matrixNetwork.addInterest("user1", new TopicOfInterest("extra"));
        mapNetwork.removeInterest("user1", new TopicOfInterest("extra"));
        matrixNetwork.removeInterest("user1", new TopicOfInterest("extra"));

        assertEquals(user_interests, matrixNetwork.getInterestsUser("user1"));
        assertEquals(user_interests, mapNetwork.getInterestsUser("user1"));

        assertEquals("""
                -: user1: Sports, Art, Computers
                -: user2: Sports, Adventure
                -: user3: Art, Literature
                -: user4: Computers, Videogames""", mapNetwork.printNetwork());
        assertEquals("""
                -: user1: Sports, Art, Computers
                -: user2: Sports, Adventure
                -: user3: Art, Literature
                -: user4: Computers, Videogames""", matrixNetwork.printNetwork());
        assertEquals(matrixNetwork.printNetwork(), mapNetwork.printNetwork());

        mapNetwork.removeUser("user1");
        matrixNetwork.removeUser("user1");
        users.remove("user1");

        assertEquals(users, matrixNetwork.getUsers());
        assertEquals(users, mapNetwork.getUsers());
        assertEquals(matrixNetwork.getUsers(),  mapNetwork.getUsers());

    }

    @Test
    void testExceptions(){
        Network emptyMatrix;
        Network emptyMap;

        emptyMap = new Network(new NetMap());
        emptyMatrix = new Network(new NetMatrix());

        emptyMap.setNetwork();
        emptyMatrix.setNetwork();

        assertEquals("[No users found]", emptyMap.printNetwork());
        assertEquals("[No users found]", emptyMatrix.printNetwork());

        assertNull(emptyMap.getUsers());
        assertNull(emptyMatrix.getUsers());
        assertNull(emptyMap.getInterests());
        assertNull(emptyMatrix.getInterests());

        emptyMap.addUser(null, new ArrayList<>());
        emptyMatrix.addUser(null, new ArrayList<>());

        assertEquals("-: : [No interests found]", emptyMap.printNetwork());
        assertEquals("-: : [No interests found]", emptyMatrix.printNetwork());

        emptyMap.addUser("user2", new ArrayList<>());
        emptyMatrix.addUser("user2", new ArrayList<>());

        assertNull(emptyMap.getInterestsUser(""));
        assertNull(emptyMatrix.getInterestsUser(""));
        assertNull(emptyMap.getInterestsCommon("", "user2"));
        assertNull(emptyMatrix.getInterestsCommon("", "user2"));

        emptyMap.addInterest("", new TopicOfInterest("Sports"));
        emptyMatrix.addInterest("", new TopicOfInterest("Sports"));

        assertNull(emptyMap.getInterestsCommon("", "user2"));
        assertNull(emptyMatrix.getInterestsCommon("", "user2"));

        emptyMap.addInterest("user2", new TopicOfInterest("Art"));
        emptyMatrix.addInterest("user2", new TopicOfInterest("Art"));

        assertNull(emptyMap.getInterestsCommon("", "user2"));
        assertNull(emptyMatrix.getInterestsCommon("", "user2"));

        assertThrows(IllegalArgumentException.class, () -> emptyMap.getInterestsCommon("null", "user2"));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.getInterestsCommon("null", "user2"));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.getInterestsCommon("", "null"));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.getInterestsCommon("", "null"));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.getInterestsCommon(null, "user2"));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.getInterestsCommon(null, "user2"));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.getInterestsUser("null"));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.getInterestsUser("null"));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.getInterestsUser(null));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.getInterestsUser(null));

        assertThrows(IllegalArgumentException.class, () -> emptyMap.removeUser(null));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.removeUser(null));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.removeUser("null"));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.removeUser("null"));

        emptyMap.addInterest("user2", new TopicOfInterest(null));
        emptyMatrix.addInterest("user2", new TopicOfInterest(null));
        emptyMap.removeInterest("user2", new TopicOfInterest(null));
        emptyMatrix.removeInterest("user2", new TopicOfInterest(null));

        assertThrows(IllegalArgumentException.class, () -> emptyMap.removeInterest("", new TopicOfInterest("null")));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.removeInterest("", new TopicOfInterest("null")));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.removeInterest("null", new TopicOfInterest("null")));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.removeInterest("null", new TopicOfInterest("null")));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.removeInterest(null, new TopicOfInterest("null")));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.removeInterest(null, new TopicOfInterest("null")));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.removeUser(null));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.removeUser(null));
        assertThrows(IllegalArgumentException.class, () -> emptyMap.removeUser("null"));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.removeUser("null"));

        assertThrows(IllegalArgumentException.class, () -> emptyMap.addInterest("null", new TopicOfInterest("null")));
        assertThrows(IllegalArgumentException.class, () -> emptyMatrix.addInterest("null", new TopicOfInterest("null")));
    }
}
