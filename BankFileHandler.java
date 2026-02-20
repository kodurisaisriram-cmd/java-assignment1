import java.io.*;
import java.util.ArrayList;

public class BankFileHandler {
    private static final String FILE_NAME = "accounts.txt";

    public static void saveAccounts(ArrayList<Account> accounts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account acc : accounts) {
                bw.write(acc.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static ArrayList<Account> loadAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                accounts.add(Account.fromFileString(line));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return accounts;
    }
}