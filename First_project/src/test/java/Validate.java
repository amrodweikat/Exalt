import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public Switch s ;
    public Router r;
    public AP ap;


    public  List<String> validateIPAddress(JSONObject deviceList, Pattern p, Matcher m){

        List<String> all_IPAddresses = new ArrayList<String>();

        for(int i = 1; i <= deviceList.size();i++){

            JSONObject deviceObject = (JSONObject) deviceList.get("Device"+i);

            if(deviceObject.get("Type").equals("Switch")){
                s = new Switch(
                        (String) deviceObject.get("IPAddress"),
                        (String) deviceObject.get("Username"),
                        (String) deviceObject.get("Password")
                );

                s.setMacAddress((String) deviceObject.get("MacAddress"));
                s.setNetwork((String) deviceObject.get("Network"));


                if(s.getIPAddress() == null){
                    System.out.println("Device"+i+" of type switch: IP address not correct");
                }
                else{
                    m = p.matcher(s.getIPAddress());

                    if(m.matches()){
                        System.out.println("Device"+i+" of type switch: IP address  correct");
                    }
                    else{
                        System.out.println("Device"+i+" of type switch: IP address not correct");
                    }
                }

                all_IPAddresses.add(s.getIPAddress());

            }


            else if(deviceObject.get("Type").equals("Router")){
                r = new Router(
                        (String) deviceObject.get("IPAddress"),
                        (String) deviceObject.get("Username"),
                        (String) deviceObject.get("Password")
                );

                r.setNetworks((List<String>) deviceObject.get("Networks"));


                if(r.getIPAddress() == null){
                    System.out.println("Device"+i+" of type router: IP address not correct");
                }
                else{
                    m = p.matcher(r.getIPAddress());

                    if(m.matches()){
                        System.out.println("Device"+i+" of type router: IP address  correct");
                    }
                    else{
                        System.out.println("Device"+i+" of type router: IP address not correct");
                    }
                }

                all_IPAddresses.add(r.getIPAddress());
            }


            else if(deviceObject.get("Type").equals("AP")){
                ap = new AP(
                        (String) deviceObject.get("IPAddress"),
                        (String) deviceObject.get("Username"),
                        (String) deviceObject.get("Password")
                );

                ap.setNetwork((String) deviceObject.get("Network"));


                if(ap.getIPAddress() == null){
                    System.out.println("Device"+i+" of type ap: IP address not correct");
                }
                else{
                    m = p.matcher(ap.getIPAddress());

                    if(m.matches()){
                        System.out.println("Device"+i+" of type ap: IP address  correct");
                    }
                    else{
                        System.out.println("Device"+i+" of type ap: IP address not correct");
                    }
                }

                all_IPAddresses.add(ap.getIPAddress());

            }



        }

        return  all_IPAddresses;

    }
}
