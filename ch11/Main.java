package gr.aueb.cf.oop.ch11;

public class Main {

    public static void main(String[] args) {
        User user = new User(1L, "bob", "marley");
        UserCredentials userCred = new UserCredentials(10L, "bob-username", "1234");

        System.out.println("{" + user.getId() + ", " + user.getFirstname() + ", " + user.getLastname() + "}");
        System.out.println("{" + userCred.getId() + ", " + userCred.getUsername()
                + ", " + userCred.getPassword() + "}");
    }
}
