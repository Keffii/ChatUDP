package Chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatRoom {
    private final List<String> activeUsers = Collections.synchronizedList(new ArrayList<>());

    public void addUser(String username) {
        synchronized (activeUsers) {
            if (!activeUsers.contains(username)) {
                activeUsers.add(username);
            }
        }
    }

    public void removeUser(String username) {
        synchronized (activeUsers) {
            activeUsers.remove(username);
        }
    }

    public List<String> getActiveUsers() {
        synchronized (activeUsers) {
            return new ArrayList<>(activeUsers);
        }
    }
}