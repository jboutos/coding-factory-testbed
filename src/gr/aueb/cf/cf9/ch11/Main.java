package gr.aueb.cf.cf9.ch11;

public class Main {

    public static void main(String[] args) {
        User john = new User(23L, "John", "Boutos");

        System.out.println("Id: " + john.getId());
        System.out.println("Firstname: " + john.getFirstname());
        System.out.println("Lastname: " + john.getLastname());
    }


}
