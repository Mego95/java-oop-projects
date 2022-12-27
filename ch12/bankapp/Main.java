package gr.aueb.cf.oop.ch12.bankapp;

import gr.aueb.cf.oop.ch12.bankapp.model.Holder;
import gr.aueb.cf.oop.ch12.bankapp.model.JointAccount;
import gr.aueb.cf.oop.ch12.bankapp.model.OverdraftAccount;

public class Main {

    public static void main(String[] args) {
        Holder jointHolder1 = new Holder(1L, "yoko", "ono", "1234");
        Holder jointHolder2 = new Holder(2L, "john", "lenon", "5678");
        Holder overdraftHolder = new Holder(10L, "bob", "marley", "abcd");

        JointAccount jointAccount = new JointAccount(jointHolder1, jointHolder2, "1111", 100.00);
        OverdraftAccount overdraftAccount = new OverdraftAccount(overdraftHolder, "2222", 300.00);

        try {
            jointAccount.withdraw(50.00, "1234", "5678");
            System.out.println(jointAccount.convertToString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            overdraftAccount.withdraw(500.00, "abcd");
            System.out.println(overdraftAccount.convertToString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
