import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class LoginDataPersister {

    private String persistenceDataPath = "persistenza.txt";

    public void saveLoginData(LoginData ld, boolean checkIfExists) throws IOException {
        Properties p = new Properties();
        p.setProperty("idAgenzia", ld.idAgenzia);
        p.setProperty("username", ld.username);
        p.setProperty("password", ld.password);

        File f = new File(persistenceDataPath);
        if(checkIfExists){
            if(f.exists() && !f.isDirectory()){
                System.out.println("File già presente.");
            }else{
                //delete old persistence file
                f.delete();
                //write new persistence file
                FileWriter fw = new FileWriter(persistenceDataPath);
                p.store(fw, "Utente Memorizzato");
                fw.close();
            }
        }else{
            //delete old persistence file
            f.delete();
            //write new persistence file
            FileWriter fw = new FileWriter(persistenceDataPath);
            p.store(fw, "Utente Memorizzato");
            fw.close();
        }
    }

    public LoginData retrieveLoginData() throws IOException {
        Properties p = new Properties();
        FileReader fr = new FileReader(persistenceDataPath);
        p.load(fr);
        fr.close();

        LoginData ld = new LoginData();
        ld.idAgenzia = p.getProperty("idAgenzia");
        ld.username = p.getProperty("username");
        ld.password = p.getProperty("password");

        return ld;
    }

    public void changePassword(String newPassword) throws IOException {
        LoginData tld = retrieveLoginData();
        tld.password = newPassword;
        saveLoginData(tld, false);
    }
}
