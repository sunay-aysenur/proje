public abstract class LoginSystem {
    protected User credential;
    protected boolean isLogin;

    public LoginSystem() {
        this.isLogin = false;
    }

    public abstract void login(User user);

}
