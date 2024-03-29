package chat.cs.sockets;

import chat.IView;

import java.io.Serializable;

/**
 * Simple Message class.
 */
public class Message implements Serializable {
 
  private static final long serialVersionUID = 1L;
  public final static int UNDEFINED = 0;
  public final static int LOGIN     = 1;
  public final static int COMMENT   = 2;
  public final static int LOGOUT    = 3;
  public final static int POLLING   = 4;
  public final static int CONFIRM   = 5;

  private int messageType;
  private String name;
  private String comment;
  private IView proxy;

  public Message() {
    this.messageType = UNDEFINED;
  }
  
  public Message(int messageType) {
    this.messageType = messageType;
  }

  public Message(int messageType, String name) {
    this.messageType = messageType;
    this.name        = name;
  }

  public Message(int messageType, String name, IView iv) {
    this.messageType = messageType;
    this.name        = name;
    this.proxy       = iv;
  }

  public Message(int messageType, String name, String comment) {
    this.messageType = messageType;
    this.name        = name;
    this.comment     = comment;
  }

  public int getMessageType() {
    return messageType;
  }

  public String getName() {
    return name;
  }

  public String getComment() {
    return comment;
  }

  public IView getProxy() { return proxy; }

}
