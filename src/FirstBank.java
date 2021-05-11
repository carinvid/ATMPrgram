
public class FirstBank {

    public static void main (String[] args){

        Account carolina = new Account("Carolina Reedy", "A00001");
        carolina.showMenu();

        Account newAccount = new Account("Troy Smith", "B00002");
        newAccount.showMenu();
    }
}
