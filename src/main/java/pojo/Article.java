package pojo;

public class Article {
    private String articleID;
    private String articleTitle;
    private String articleAuthor;
    private String articleContent;
    private String articleTime;
    private String articleClick;
    private String articlePreview;
    private String imgSrc;

    private String comment_number;
    private String mark_number;
    private String author_uid;

    private float rate;

    //实体类内的字段的getter和setter是必不可少的，否则无法用sql注解给这个实体内的字段赋值


    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getComment_number() {
        return comment_number;
    }

    public void setComment_number(String comment_number) {
        this.comment_number = comment_number;
    }

    public String getMark_number() {
        return mark_number;
    }

    public void setMark_number(String mark_number) {
        this.mark_number = mark_number;
    }

    public String getAuthor_uid() {
        return author_uid;
    }

    public void setAuthor_uid(String author_uid) {
        this.author_uid = author_uid;
    }




    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(String articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(String articleClick) {
        this.articleClick = articleClick;
    }

    public String getArticlePreview() {
        return articlePreview;
    }

    public void setArticlePreview(String articlePreview) {
        this.articlePreview = articlePreview;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
