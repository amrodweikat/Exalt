public class AP extends Help{


    private String Network;


    public AP(String IPAddress,String Username,String Password){
            super(IPAddress,Username,Password);
    }

    public String getNetwork() {
        return Network;
    }

    public void setNetwork(String network) {
        Network = network;
    }
}
