import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        LoginDataPersister loginDataPersister = new LoginDataPersister();
        LoginData loginData = new LoginData();
        loginData.idAgenzia = "1";
        loginData.username = "1";
        loginData.password = "1";
        try {
            loginDataPersister.saveLoginData(loginData, true);
        } catch (IOException e) {
            System.out.println("Impossibile salvare i dati.");
        }
        new Pagina_Login();
    }

}