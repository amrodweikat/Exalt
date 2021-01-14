
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Help {


    public List<Device> readJSONFile(String fileName){

        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        JSONObject deviceList = null;
        List<Device> allDevices = new ArrayList<>();

        try(FileReader reader = new FileReader(fileName) ) {
            obj = jsonParser.parse(reader);
            deviceList = (JSONObject) obj;
            for(int i = 1;i <= deviceList.size();i++){
                JSONObject device = (JSONObject) deviceList.get("Device"+i);
                allDevices.add(new Device(
                       (String) device.get("IPAddress"),(String) device.get("Username"),(String) device.get("Password")
                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return allDevices;
    }

    public  void validateIPAddress(List<Device> deviceList, Pattern ipAddressPattern ){

        for(int i = 1; i <= deviceList.size();i++){
            Matcher ipAddressMatcher = ipAddressPattern.matcher(deviceList.get(i-1).getIPAddress());
        if(ipAddressMatcher.matches()) System.out.println("Device"+i+" : ip address correct");
        else System.out.println("Device"+i+" : ip address not correct");
        Assert.assertEquals(true,ipAddressMatcher.matches());
        }


    }
}
