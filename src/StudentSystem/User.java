package StudentSystem;

public class User {
    private String username;
    private String password;
    private String phonenumber;
    private String idcard;

    public User(String name, String password, String phonenumber, String idcard) {
        this.username = name;
        this.password = password;
        this.phonenumber = phonenumber;
        this.idcard = idcard;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
