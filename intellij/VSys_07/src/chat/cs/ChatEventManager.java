package chat.cs;

import chat.ChatEvent;
import chat.IView;

import java.util.*;

public class ChatEventManager implements IChat {
    private Map<String, IView> eventsMap;
    private List<String> mutedList = new ArrayList<String>();

    public ChatEventManager() {
        eventsMap = new HashMap<String, IView>();
    }

    private void queueEventToAll(ChatEvent evt) {
        for (IView q : eventsMap.values())
            try {
                q.update(evt);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void login(String name, IView ViewProxy) {
        if (!eventsMap.containsKey(name)) {
            eventsMap.put(name, ViewProxy);
            queueEventToAll(new ChatEvent(ChatEvent.LIST_UPDATE, getNames()));
        }
    }

    public boolean isCommand(String name, String command) {

        if (command.substring(0, 1).contains("/")) {
            try {
                if (command.substring(0, 5).contains("/help")) {
                    eventsMap.get(name).update(new ChatEvent(ChatEvent.COMMENT, "/help\tShow this help\n" +
                            "/kick user\tkicks user if command from admin\n" +
                            "/mute user\tmutes the user if command from admin\n" +
                            "/unmute user\tunmutes the user if command from admin"));
                } else if (name.equals("Admin") && command.substring(0, 5).contains("/kick")) { // kick logic
                    String kickname = command.substring(6);
                    if (eventsMap.containsKey(kickname)) {
                        eventsMap.get(kickname).update(new ChatEvent(ChatEvent.COMMENT, "You've been kicked"));
                        eventsMap.get(kickname).update(new ChatEvent(ChatEvent.LIST_UPDATE, new String[0]));
                        logout(kickname);
                        queueEventToAll(new ChatEvent(ChatEvent.COMMENT, name + " kicked " + kickname));
                    } else {
                        eventsMap.get(name).update(new ChatEvent(ChatEvent.COMMENT, "no such user"));
                    }
                } else if (name.equals("Admin") && command.substring(0, 5).contains("/mute")) {
                    String mutename = command.substring(6);
                    if (eventsMap.containsKey(mutename) && !mutedList.contains(mutename)) {
                        mutedList.add(mutename);
                        queueEventToAll(new ChatEvent(ChatEvent.COMMENT, name + " muted " + mutename));
                    } else {
                        eventsMap.get(name).update(new ChatEvent(ChatEvent.COMMENT, "no such user"));
                    }
                } else if (name.equals("Admin") && command.substring(0, 7).contains("/unmute")) {
                    String mutename = command.substring(8);
                    if (eventsMap.containsKey(mutename) && mutedList.contains(mutename)) {
                        mutedList.remove(mutename);
                        queueEventToAll(new ChatEvent(ChatEvent.COMMENT, name + " unmuted " + mutename));
                    } else {
                        eventsMap.get(name).update(new ChatEvent(ChatEvent.COMMENT, "no such user"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }

    }

    public void comment(String name, String comment) {
        if (!isCommand(name, comment) && !mutedList.contains(name)) {
            queueEventToAll(new ChatEvent(ChatEvent.COMMENT, name + ": " + comment));
        }
    }

    public ChatEvent poll(String name) {
//    if (!eventsMap.containsKey(name)) return null;
//    Queue<ChatEvent> q = eventsMap.get(name);
//    return q.poll();
        return null;
    }

    public void logout(String name) {
        eventsMap.remove(name);
        queueEventToAll(new ChatEvent(ChatEvent.LIST_UPDATE, getNames()));
    }

    private String[] getNames() {
        String[] array = new String[eventsMap.size()];
        return eventsMap.keySet().toArray(array);
    }
}

