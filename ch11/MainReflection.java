package gr.aueb.cf.oop.ch11;

import java.lang.reflect.Constructor;

public class MainReflection {

    public static void main(String[] args) {
        try {
            Class<?> userClass = Class.forName("gr.aueb.cf.oop.ch11.User");
            Class<?> userCredClass = Class.forName("gr.aueb.cf.oop.ch11.UserCredentials");

            Constructor<?> userCtr = userClass.getConstructor(long.class, String.class, String.class);
            Constructor<?> userCredCtr = userCredClass.getConstructor(long.class, String.class, String.class);

            User user = (User) userCtr.newInstance(1L, "bob", "marley");
            UserCredentials userCred = (UserCredentials) userCredCtr.newInstance(10L, "bob-username", "1234");

            System.out.println("{" + user.getId() + ", " + user.getFirstname() + ", " + user.getLastname() + "}");
            System.out.println("{" + userCred.getId() + ", " + userCred.getUsername()
                    + ", " + userCred.getPassword() + "}");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
