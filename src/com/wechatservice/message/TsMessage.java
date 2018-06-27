package com.wechatservice.message;

public class TsMessage extends BaseMessage{
 private String Event;
 private long MsgID;
 private String Status;
public String getEvent() {
	return Event;
}
public void setEvent(String event) {
	Event = event;
}
public long getMsgID() {
	return MsgID;
}
public void setMsgID(long msgID) {
	MsgID = msgID;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
 
 
}
