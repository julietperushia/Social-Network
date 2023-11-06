import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CustomGraph<User, E> {
    private Map<User, List<E>> adjacencyMap;

    public CustomGraph() {
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(User vertex) {
        if (!adjacencyMap.containsKey(vertex)) {
            adjacencyMap.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(User source, User target, E edge) {
        if (adjacencyMap.containsKey(source) && adjacencyMap.containsKey(target)) {
            adjacencyMap.get(source).add(edge);
            adjacencyMap.get(target).add(edge);
        }
    }

    public Set<User> vertexSet() {
        return adjacencyMap.keySet();
    }

    public List<E> outgoingEdgesOf(User vertex) {
        return adjacencyMap.get(vertex);
    }
    public List<User> recommendFriends(User user) {
        List<User> recommendedFriends = new ArrayList<>();
        for (User potentialFriend : vertexSet()) {
            if (!user.equals(potentialFriend) && !areFriends(user, potentialFriend)) {
                if (hasMutualFriends(user, potentialFriend)) {
                    recommendedFriends.add(potentialFriend);
                }
            }
        }
        return recommendedFriends;
    }

    private boolean areFriends(User user1, User user2) {
        List<E> user1Edges = outgoingEdgesOf(user1);
        for (E edge : user1Edges) {
            if (getOppositeUser(user1, edge).equals(user2)) {
                return true;
            }
        }
        return false;
    }

    public User getOppositeUser(User user, E edge) {
       
        if (edge instanceof DefaultEdge) {
            DefaultEdge defaultEdge = (DefaultEdge) edge;
            if (defaultEdge.getSource().equals(user)) {
                return (User) defaultEdge.getTarget();
            } else {
                return (User)defaultEdge.getSource();
            }
        }
        return null;
    }

    private boolean hasMutualFriends(User user1, User user2) {
        List<User> user1Friends = new ArrayList<>();
        List<User> user2Friends = new ArrayList<>();

        for (E edge : outgoingEdgesOf(user1)) {
            user1Friends.add((User) getOppositeUser(user1, edge));
        }

        for (E edge : outgoingEdgesOf(user2)) {
            user2Friends.add((User) getOppositeUser(user2, edge));
        }

        user1Friends.retainAll(user2Friends); 

        return !user1Friends.isEmpty();
    }
}

