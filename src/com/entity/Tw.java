package com.entity;

public class Tw {
private String title;//图文消息的标题
private String thumb_media_id;//图文消息的封面图片素材id（必须是永久mediaID）
private String show_cover_pic;//	是否显示封面，0为false，即不显示，1为true，即显示
private String author;//	作者
private String digest;//图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
private String content;//图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
private String url;//图文页的URL
private String content_source_url;//图文消息的原文地址，即点击“阅读原文”后的URL
private Uint32 need_open_comment;//是否打开评论，0不打开，1打开
private Uint32 only_fans_can_comment;//是否粉丝才可评论，0所有人可评论，1粉丝才可评论
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


}
