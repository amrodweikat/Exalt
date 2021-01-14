

public class Help {

    private String IPAddress ;
    private String Username;
    private String Password;


    public Help(String IPAddress, String Username, String password){
        this.IPAddress = IPAddress;
        this.Username = Username;
        this.Password = password;

    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }






}
