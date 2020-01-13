package Apteka;

final class User {

    String login;
    String password;


    User(String login, String password) {
        this.login = login;
        this.password = password;

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "Jesteś zalogowany jako: " + getLogin();
    }
}
