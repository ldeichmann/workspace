package chat.cs;

import chat.ChatEvent;
import chat.IView;

import java.util.*;

public class ChatEventManager implements IChat {
  private Map<String,IView> eventsMap;

  public ChatEventManager() {
    eventsMap  = new HashMap<String,IView>();
  } 

  private void queueEventToAll(ChatEvent evt) {
    for (IView q: eventsMap.values())
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

  public void comment(String name, String comment) {
      if (name.equals("Admin") && comment.substring(0, 5).contains("/kick")) {
          try {
              String kickname = comment.split(" ")[1];
              if (eventsMap.containsKey(kickname)) {
                  eventsMap.get(kickname).update(new ChatEvent(ChatEvent.COMMENT, "You've been kicked"));
                  eventsMap.get(kickname).update(new ChatEvent(ChatEvent.LIST_UPDATE, new String[0]));
                  logout(kickname);
                  queueEventToAll(new ChatEvent(ChatEvent.COMMENT, name + " kicked " + kickname));
              } else {
                      eventsMap.get(name).update(new ChatEvent(ChatEvent.COMMENT, "no such user"));
              }
          } catch (Exception e) {e.printStackTrace();};
      } else {
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

