public class Client implements java.io.Serializable {
    private String username;
    private String password;
    private  String telefon;
    private int id;

    public Client(String username, String password, String telefon, int id) {
        this.username = username;
        this.password = password;
        this.telefon = telefon;
        this.id = id;
    }
    public Client()
    {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
