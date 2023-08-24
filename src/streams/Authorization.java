package streams;

import queue.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Authorization {
    public List<Permission> permissions;
    public List<User> users;

    public Authorization(List<Permission> permissions, List<User> users) {
        this.permissions = permissions;
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public ArrayList<String> listPermissions(int userId) {
        Predicate<User> neededUser= user -> user.id == userId;
        User user = users.stream().filter(neededUser).findFirst().get();
        Predicate<Permission> perms = permission -> user.roles.contains(permission.role) && permission.active;
        return (ArrayList<String>) permissions.stream().filter(perms).map(perm -> perm.name).collect(Collectors.toList());
    }

    public boolean checkPermitted(String permissionName, int userId){
        if(!permissionName.isBlank() && !permissionName.isEmpty() && userId > 0 ) {
            ArrayList<String> userPermissions = listPermissions(userId);

            Predicate<Permission> permTest = e -> e.name == permissionName && e.active;

            Permission perm = permissions.stream().filter(permTest).findFirst().get();
            if (userPermissions.stream().filter(stringPerm -> stringPerm == perm.name).count() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Authorization{" +
                "permissions=" + permissions +
                ", users=" + users +
                '}';
    }
}
