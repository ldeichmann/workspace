package chat.cs;

import chat.ChatEvent;
import chat.IView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Simple ChatModel
 */
public class ChatModel {

    Map<String, IView> userMap;

    public ChatModel() {

        this.userMap = new HashMap<String, IView>();

    }

    private void sendEventToAll(ChatEvent evt) {
        for (IView iv: this.userMap.values()) {
            try {
                iv.update(evt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void login(String name, IView iv) {
        if (!userMap.containsKey(name)) {
            userMap.put(name, iv);
        }
    }

    public void comment(String name, String comment) {
        sendEventToAll(new ChatEvent(ChatEvent.COMMENT, name + ": " + comment));
    }

    public void logout(String name) {
        userMap.remove(name);
    }

    private String[] getNames() {
        String[] array = new String[userMap.size()];
        return userMap.keySet().toArray(array);
    }

}
