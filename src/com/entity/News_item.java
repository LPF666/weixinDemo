package com.entity;

public class News_item {
 private String title;//ͼ����Ϣ�ı���
 private String thumb_media_id;//ͼ����Ϣ�ķ���ͼƬ�ز�id������������mediaID��
 private String show_cover_pic;//	�Ƿ���ʾ���棬0Ϊfalse��������ʾ��1Ϊtrue������ʾ
 private String author;//����
 private String digest;//	ͼ����Ϣ��ժҪ�����е�ͼ����Ϣ����ժҪ����ͼ�Ĵ˴�Ϊ��
 private String content;//	ͼ����Ϣ�ľ�������
 private String url;//ͼ��ҳ��URL
 private String content_source_url;//	ͼ����Ϣ��ԭ�ĵ�ַ����������Ķ�ԭ�ġ����URL
 private String thumb_url;//ͼƬURL
 private Uint32 need_open_comment ;//�Ƿ�����ۣ�0���򿪣�1��
 private Uint32 only_fans_can_comment ;//�Ƿ��˿�ſ����ۣ�0�����˿����ۣ�1��˿�ſ�����
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getThumb_media_id() {
	return thumb_media_id;
}
public void setThumb_media_id(String thumbMediaId) {
	thumb_media_id = thumbMediaId;
}
public String getShow_cover_pic() {
	return show_cover_pic;
}
public void setShow_cover_pic(String showCoverPic) {
	show_cover_pic = showCoverPic;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getDigest() {
	return digest;
}
public void setDigest(String digest) {
	this.digest = digest;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getContent_source_url() {
	return content_source_url;
}
public void setContent_source_url(String contentSourceUrl) {
	content_source_url = contentSourceUrl;
}
public String getThumb_url() {
	return thumb_url;
}
public void setThumb_url(String thumbUrl) {
	thumb_url = thumbUrl;
}
public Uint32 getNeed_open_comment() {
	return need_open_comment;
}
public void setNeed_open_comment(Uint32 needOpenComment) {
	need_open_comment = needOpenComment;
}
public Uint32 getOnly_fans_can_comment() {
	return only_fans_can_comment;
}
public void setOnly_fans_can_comment(Uint32 onlyFansCanComment) {
	only_fans_can_comment = onlyFansCanComment;
}
@Override
public String toString() {
	return "News_item [author=" + author + ", content=" + content
			+ ", content_source_url=" + content_source_url + ", digest="
			+ digest + ", need_open_comment=" + need_open_comment
			+ ", only_fans_can_comment=" + only_fans_can_comment
			+ ", show_cover_pic=" + show_cover_pic + ", thumb_media_id="
			+ thumb_media_id + ", thumb_url=" + thumb_url + ", title=" + title
			+ ", url=" + url + "]";
}
 
 
}
