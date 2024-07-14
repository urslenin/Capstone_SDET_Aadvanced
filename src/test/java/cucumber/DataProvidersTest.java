package cucumber;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testbase.BaseClass;
import utils.ConfigFileReader;

import java.util.HashMap;
import java.util.Map;


public class DataProvidersTest extends BaseClass {

    Logger logger = Logger.getLogger(DataProvidersTest.class);


    @Test(dataProvider = "userCredentials")
    public void setCredentials(String username, String password){
        logger.info("DataProvider Collection Started ");
        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put(username,password);
        credentials.add(credentialsMap);
        logger.info("DataProvider Collection Completed "+ credentials);
    }

    @DataProvider(name = "userCredentials")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {"standard_user", "secret_sauce"} //*It can be retrieved form Json or Excel or Text File using separate Reader
        };

    }
}
