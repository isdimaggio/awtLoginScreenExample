public class LoginData {
    public String idAgenzia;
    public String username;
    public String password;

    public boolean checkLogin(String idAgenziaC, String usernameC, String passwordC) {
        if (idAgenzia.equals(idAgenziaC) && username.equals(usernameC) && password.equals(passwordC)) {
            return true;
        }
        return false;
    }
}
