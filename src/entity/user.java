package entity;

public class user {
    private int uid;
    private String uname;
    private String uzd;
    private String upsd;
    private String ugender;

    public user() {
    }

    public user(int uid, String uname, String uzd, String upsd, String ugender) {
        this.uid = uid;
        this.uname = uname;
        this.uzd = uzd;
        this.upsd = upsd;
        this.ugender = ugender;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUzd() {
        return uzd;
    }

    public void setUzd(String uzd) {
        this.uzd = uzd;
    }

    public String getUpsd() {
        return upsd;
    }

    public void setUpsd(String upsd) {
        this.upsd = upsd;
    }

    public String getUgender() {
        return ugender;
    }

    public void setUgender(String ugender) {
        this.ugender = ugender;
    }
}
