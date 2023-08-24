package streams;

public class Permission {
    public String role;
    public String name;
    public boolean active;

    public Permission() {
    }

    public Permission(String role, String name, boolean active) {
        this.role = role;
        this.name = name;
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
