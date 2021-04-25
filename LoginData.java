import java.security.SecureRandom;

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

    public String setRandomPassword(int length){
        //caratteri ammessi
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        //loop per la lunghezza della pass
        for (int i = 0; i < length; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        password = sb.toString();

        return sb.toString();
    }
}
