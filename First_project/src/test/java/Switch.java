

public class Switch extends Help{


    private String Network;
    private String MacAddress;

    public Switch(String IPAddress,String Username,String Password){
        super(IPAddress,Username,Password);
    }

    public String getNetwork() {
        return Network;
    }

    public void setNetwork(String network) {
        Network = network;
    }

    public String getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(String macAddress) {
        MacAddress = macAddress;
    }
}
