package chat.cs;
import chat.ChatEvent;
import chat.IView;

public interface IChat {
  public void login(String name, IView iv) throws Exception;
  public void logout(String name) throws Exception;  
  public void comment(String name, String comment) throws Exception; 
  public ChatEvent poll(String name) throws Exception; 
}
