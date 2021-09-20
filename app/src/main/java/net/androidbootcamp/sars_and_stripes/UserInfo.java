package net.androidbootcamp.sars_and_stripes;

public class UserInfo {
    private int userId;
    private String userName;
    private String passWord;
    private String email;

    //constructors
    public UserInfo(int userId, String userName, String passWord, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.userId = userId;
    }
    public UserInfo() {}

    // toString function to convert over to text for output to our app
    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //getters and setters
    public void setUserId (int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return this.userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setPassWord (String passWord){
        this.passWord = passWord;
    }
    public String getPassWord(){
        return this.passWord;
    }

    public void setEmail (String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
}
