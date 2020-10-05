package cn.wkd.examples.domain;

/**
 * @author 许佳华
 * @Description:
 * @date 2020/3/12 17:29
 */
public class User {
    private int uid; //用户id
    private String username; //用户名
    private String password; //密码
    private String icon_url; //用户头像路径
    private String address; //用户地址
    private String telphone; //用户电话

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", icon_url='" + icon_url + '\'' +
                ", address='" + address + '\'' +
                ", telphone='" + telphone + '\'' +
                '}';
    }
}
