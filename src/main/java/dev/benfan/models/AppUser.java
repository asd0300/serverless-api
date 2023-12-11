package dev.benfan.models;

public class AppUser {
    private String id;
    private String email;
    private String password;
    private UserAuthority authority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public UserAuthority getAuthority() {
        return authority;
    }

    public void setAuthority(UserAuthority authority) {
        this.authority = authority;
    }

    public static AppUser getTestAdminUser(){
        var user = new AppUser();
        user.id = "100";
        user.email = "vincent@gmail.com";
        user.password = "123456";
        user.authority = UserAuthority.ADMIN;

        return user;
    }
    public static AppUser getTestNormalUser(){
        var user = new AppUser();
        user.id = "101";
        user.email = "dora@gmail.com";
        user.password = "654321";
        user.authority = UserAuthority.NORMAL;

        return user;
    }
    public static AppUser getTestGuestUser(){
        var user = new AppUser();
        user.id = "102";
        user.email = "ivy@gmail.com";
        user.password = "000000";
        user.authority = UserAuthority.GUEST;

        return user;
    }

}

