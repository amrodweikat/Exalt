import java.util.List;

public class Router extends Help{


    private List<String> Networks;


    public Router(String IPAddress,String Username,String Password){
        super(IPAddress,Username,Password);
    }

    public List<String> getNetworks() {
        return Networks;
    }

    public void setNetworks(List<String> networks) {
        Networks = networks;
    }
}
