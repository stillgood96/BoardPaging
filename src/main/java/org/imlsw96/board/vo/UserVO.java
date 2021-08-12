package org.imlsw96.board.vo;

public class UserVO {
    int uno;
    String userid;
    String password;
    String repassword;

    public UserVO() {
    }

    public UserVO(int uno, String userid, String password, String repassword) {
        this.uno = uno;
        this.userid = userid;
        this.password = password;
        this.repassword = repassword;
    }

    public UserVO(int uno, String userid, String password) {
        this.uno = uno;
        this.userid = userid;
        this.password = password;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
