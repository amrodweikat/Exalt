

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;



public class TestIPAddress_TestComponentsNumber {

    private final static String FILENAME = "C:\\Exalt\\First_project\\test.json";
    private Help help = new Help() ;
    private List<Device> allDevices;
    private boolean check;
    private List<Switch> allSwitches;
    private List<Router> allRouters;
    private List<AP> allAPs;


    @BeforeTest
    public void testJSONFile(){
        check = help.checkEmptyJSONFile(FILENAME);
        Assert.assertEquals(false,check);
    }


    @Test
    public void testIPAddressValidate(){
        allDevices = help.readJSONFile(FILENAME);
        help.validateIPAddress(allDevices);
    }



    @Test
    public void testComponentsNumber(){
        allSwitches = help.numberOfSwitches(FILENAME);
        allRouters = help.numberOfRouters(FILENAME);
        allAPs = help.numberOfAPs(FILENAME);
        help.validateComponentsNumber(allSwitches.size(),allRouters.size(),allAPs.size());
    }

}
