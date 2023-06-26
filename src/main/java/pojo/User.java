package pojo;

public class User {
    private String username;
    private String email;
    private String password;
    private String coverSrc;
    private String avatarSrc;
    private String uid;

    public User(String username, String email, String password, String coverSrc, String avatarSrc, String uid) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.coverSrc = coverSrc;
        this.avatarSrc = avatarSrc;
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCoverSrc() {
        return coverSrc;
    }

    public void setCoverSrc(String coverSrc) {
        this.coverSrc = coverSrc;
    }

    public String getAvatarSrc() {
        return avatarSrc;
    }

    public void setAvatarSrc(String avatarSrc) {
        this.avatarSrc = avatarSrc;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", coverSrc='" + coverSrc + '\'' +
                ", avatarSrc='" + avatarSrc + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
