package com.wechatservice.message;

import java.util.List;

import com.entity.Article;

public class NewsMessage extends BaseMessage {
    // ͼ����Ϣ����������Ϊ10������
    private int ArticleCount;
    // ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }

    @Override
    public String toString() {
        return "NewsMessage [ArticleCount=" + ArticleCount + ", Articles="
                + Articles + "]";
    }

}
