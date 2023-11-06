import java.util.*;
import javax.swing.*;
public class SocialMediaDataAnalytics {
    public static void main(String[] args) {
        CustomGraph<User, DefaultEdge> socialNetwork = new CustomGraph<>();

        User user0 = new User("Alice");
        User user1 = new User("Bob");
        User user2 = new User("Charlie");
        User user3 = new User("David");
        User user4 = new User("Eve");
        User user5 = new User("Frank");
        User user6 = new User("Grace");
        User user7 = new User("Hannah");
        User user8 = new User("Isabel");
        User user9 = new User("Jack");
        
        socialNetwork.addVertex(user0);
        socialNetwork.addVertex(user1);
        socialNetwork.addVertex(user2);
        socialNetwork.addVertex(user3);
        socialNetwork.addVertex(user4);
        socialNetwork.addVertex(user5);
        socialNetwork.addVertex(user6);
        socialNetwork.addVertex(user7);
        socialNetwork.addVertex(user8);
        socialNetwork.addVertex(user9);

        DefaultEdge aliceBobEdge = new DefaultEdge(user0, user1);
        DefaultEdge aliceCharlieEdge = new DefaultEdge(user0, user2);
        DefaultEdge bobDavidEdge = new DefaultEdge(user1, user3);
        DefaultEdge charlieDavidEdge = new DefaultEdge(user2, user3);
        DefaultEdge aliceEveEdge = new DefaultEdge(user0, user4);
        DefaultEdge frankCharlieEdge = new DefaultEdge(user5, user2);
        DefaultEdge graceHannahEdge = new DefaultEdge(user6, user7);
        DefaultEdge isabelJackEdge = new DefaultEdge(user8,user9);

        socialNetwork.addEdge(user0, user1, aliceBobEdge);
        socialNetwork.addEdge(user0, user2, aliceCharlieEdge);
        socialNetwork.addEdge(user1, user3, bobDavidEdge);
        socialNetwork.addEdge(user2, user3, charlieDavidEdge);
        socialNetwork.addEdge(user0, user4, aliceEveEdge);
        socialNetwork.addEdge(user5, user2, frankCharlieEdge);
        socialNetwork.addEdge(user6, user7, graceHannahEdge);
        socialNetwork.addEdge(user8,user9, isabelJackEdge);

        System.out.println("Social Network Graph Analysis:");
        System.out.println("Number of Users: " + socialNetwork.vertexSet().size());

        System.out.print("Friends of " + user0 + ": [");

        List<User> friends = new ArrayList<>();
        for (DefaultEdge edge : socialNetwork.outgoingEdgesOf(user0)) {
            User oppositeUser = socialNetwork.getOppositeUser(user0, edge);
            friends.add(oppositeUser);
        }
        System.out.print(friends);
        System.out.println("]");
        
        
        List<User> users = new ArrayList<>();
        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SocialMediaPanel(users);
            }
        });
    }
}






    
}
