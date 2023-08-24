package streams;

import java.util.ArrayList;
import java.util.List;

public class AuthTester {

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();

        users.add(new User(1, "Anna Administrator", List.of("superuser")));
        users.add(new User(2, "Charles N. Charge", List.of("charger", "rider")));
        users.add(new User(7, "Ryder", List.of("rider")));
        users.add(new User(11, "Unregistered Ulysses", List.of()));
        users.add(new User(18, "Tessa Tester", List.of("beta tester")));

        List<Permission> permissions = new ArrayList<Permission>();

        permissions.add(new Permission("superuser", "lock user account", true));
        permissions.add(new Permission("superuser", "unlock user account", true));
        permissions.add(new Permission("superuser", "purchase widgets", false));
        permissions.add(new Permission("charger", "view pick up locations", true));
        permissions.add(new Permission("rider", "view my profile", true));
        permissions.add(new Permission("rider", "scooters near me", true));

        Authorization authorization = new Authorization(permissions, users);
        System.out.println(authorization.listPermissions(7));

        System.out.println(authorization.checkPermitted("view my profile", 2));
        System.out.println(authorization.checkPermitted("scooters near me", 2));
        System.out.println(authorization.checkPermitted("view pick up locations", 2));
        System.out.println(authorization.checkPermitted("view pick up locations", 11));
    }
}
