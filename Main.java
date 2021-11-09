import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        LoginDataPersister loginDataPersister = new LoginDataPersister();
        LoginData loginData = new LoginData();
        loginData.idAgenzia = "admin";
        loginData.username = "admin";
        loginData.password = "admin";
        try {
            loginDataPersister.saveLoginData(loginData, true);
        } catch (IOException e) {
            System.out.println("Errore salvataggio dati!");
        }
        new PaginaLogin();
    }

}