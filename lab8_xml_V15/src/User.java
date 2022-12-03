public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String ip;

    public User(int id, String firstName, String lastName, String eMail, String ip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
