package pojo;

public class Comment {
    private String id;
    private String article_id;
    private String from_uid;
    private String content;
    private String to_uid;
    private String time;

    public Comment(String id, String article_id, String from_uid, String content, String to_uid, String time) {
        this.id = id;
        this.article_id = article_id;
        this.from_uid = from_uid;
        this.content = content;
        this.to_uid = to_uid;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(String from_uid) {
        this.from_uid = from_uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(String to_uid) {
        this.to_uid = to_uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", article_id='" + article_id + '\'' +
                ", from_uid='" + from_uid + '\'' +
                ", content='" + content + '\'' +
                ", to_uid='" + to_uid + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
