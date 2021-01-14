
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Help {

    private final Pattern IP_ADDRESS_PATTERN = Pattern.compile("\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b");

    public List<Device> readJSONFile(String fileName){

        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        JSONArray deviceList = null;
        JSONObject device = null;
        JSONObject subDevic = null;
        List<Device> allDevices = new ArrayList<>();

        try(FileReader reader = new FileReader(fileName) ) {
            obj = jsonParser.parse(reader);
            deviceList = (JSONArray) obj;
            for(int i = 1;i <= deviceList.size();i++){
                 device = (JSONObject) deviceList.get(i-1);
                 subDevic = (JSONObject) device.get("Device");
                allDevices.add(new Device(
                       (String) subDevic.get("IPAddress"),(String) subDevic.get("Username"),(String) subDevic.get("Password")
                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return allDevices;
    }

    public  void validateIPAddress(List<Device> deviceList ){

        for(int i = 1; i <= deviceList.size();i++){
            Matcher ipAddressMatcher = IP_ADDRESS_PATTERN.matcher(deviceList.get(i-1).getIPAddress());
        if(ipAddressMatcher.matches()) System.out.println("Device"+i+" : ip address correct");
        else System.out.println("Device"+i+" : ip address not correct");
        Assert.assertEquals(true,ipAddressMatcher.matches());
        }


    }

    public boolean checkEmptyJSONFile(String fileName){
        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        JSONArray deviceList = null;

        try(FileReader reader = new FileReader(fileName) ) {
            obj = jsonParser.parse(reader);
            deviceList = (JSONArray) obj;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(deviceList == null) return true;
        else return false;
    }

    public List<Switch> numberOfSwitches(String fileName){
        List<Switch> allSwitches = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        JSONArray deviceList = null;
        JSONObject device = null;
        JSONObject subDevice = null;

        try(FileReader reader = new FileReader(fileName) ) {
            obj = jsonParser.parse(reader);
            deviceList = (JSONArray) obj;
            for(int i = 1;i <= deviceList.size();i++){
                 device = (JSONObject) deviceList.get(i-1);
                 subDevice = (JSONObject) device.get("Device");
               if(subDevice.get("Type").equals("Switch")){
                   allSwitches.add(new Switch(
                           (String) subDevice.get("IPAddress"),(String) subDevice.get("Username"),(String) subDevice.get("Password")
                   ));
               }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allSwitches;
    }

    public List<Router> numberOfRouters(String fileName){
        List<Router> allRouters = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        JSONObject device = null;
        JSONArray deviceList = null;
        JSONObject subDevice = null;

        try(FileReader reader = new FileReader(fileName) ) {
            obj = jsonParser.parse(reader);
            deviceList = (JSONArray) obj;
            for(int i = 1;i <= deviceList.size();i++){
                 device = (JSONObject) deviceList.get(i-1);
                 subDevice = (JSONObject) device.get("Device");
                if(subDevice.get("Type").equals("Router")){
                    allRouters.add(new Router(
                            (String) subDevice.get("IPAddress"),(String) subDevice.get("Username"),(String) subDevice.get("Password")
                    ));
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allRouters;
    }

    public List<AP> numberOfAPs(String fileName){
        List<AP> allAPs = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        JSONObject device = null;
        JSONArray deviceList = null;
        JSONObject subDevice = null;

        try(FileReader reader = new FileReader(fileName) ) {
            obj = jsonParser.parse(reader);
            deviceList = (JSONArray) obj;
            for(int i = 1;i <= deviceList.size();i++){
                 device = (JSONObject) deviceList.get(i-1);
                 subDevice = (JSONObject) device.get("Device");
                if(subDevice.get("Type").equals("AP")){
                    allAPs.add(new AP(
                            (String) subDevice.get("IPAddress"),(String) subDevice.get("Username"),(String) subDevice.get("Password")
                    ));
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allAPs;
    }

    public void validateComponentsNumber(int numberOfSwitches , int numberOfRouters,int numberOfAps){
        Assert.assertEquals(true , numberOfRouters >= 1);
        Assert.assertEquals(true , numberOfSwitches >= 2);
        Assert.assertEquals(true , numberOfAps >= 0);
    }
}
