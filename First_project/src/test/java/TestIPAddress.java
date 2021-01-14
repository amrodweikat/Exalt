
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.regex.*;


import java.io.FileReader;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TestIPAddress {

    public Pattern IPAddresspattern = Pattern.compile("\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b");
    public Matcher IPAddressmatcher;
    public String Filename = "C:\\Exalt\\First_project\\test.json";
    public Validate validate ;

    @Test
    public void testIPaddressValidate(){

        validate = new Validate();

        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader(Filename) ) {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject deviceList = (JSONObject) obj;

            //Validate all IPAddresses
            List<String> all_IPAddresses = validate.validateIPAddress(deviceList,IPAddresspattern,IPAddressmatcher);

            //Testing validate IPAddress if expected = actual
            for (String IPAddress : all_IPAddresses){
                IPAddressmatcher = IPAddresspattern.matcher(IPAddress);
                Assert.assertEquals(true,IPAddressmatcher.matches());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
