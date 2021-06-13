package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User value : users) {
            if (value.getUsername().equals(login)) {
                user = value;
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User invalid");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr", true),
                new User("Alex", true),
                new User("Test9", false)
        };
        try {
            User user = findUser(users, "Test");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException usInEx) {
            usInEx.printStackTrace();
        } catch (UserNotFoundException usNoFoEx) {
            usNoFoEx.printStackTrace();
        }
    }
}