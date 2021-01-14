

import org.testng.annotations.Test;
import java.util.regex.*;
import java.util.List;



public class TestIPAddress {

    private Pattern ipAddressPattern = Pattern.compile("\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b");
    private final static String fileName = "C:\\Exalt\\First_project\\test.json";
    private Help help = new Help() ;
    private List<Device> allDevices;

    @Test
    public void testIPAddressValidate(){

        allDevices = help.readJSONFile(fileName);
        help.validateIPAddress(allDevices,ipAddressPattern);

    }

}
