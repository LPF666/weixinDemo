package com.wechatservice.message;

public class TextMessage extends BaseMessage {
    /**
     * �ظ�����Ϣ����
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString()+"[Content:"+this.Content+"]";
    }
}
