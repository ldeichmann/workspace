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
      ViewProxy.
      queueEventToAll(new ChatEvent(ChatEvent.LIST_UPDATE, getNames()));
    }
  } 

  public void comment(String name, String comment) {
    queueEventToAll(new ChatEvent(ChatEvent.COMMENT, name + ": " + comment));
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

