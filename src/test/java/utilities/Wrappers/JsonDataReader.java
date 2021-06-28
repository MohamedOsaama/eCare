package utilities.Wrappers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

import static utilities.CommonPaths.segmaTestDataFile;


public class JsonDataReader {
    public String serviceNumber, password;

    @DataProvider(name = "JsonReader")
    public Object[] JsonReader() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader srcFile = new FileReader(segmaTestDataFile);
        Object object = parser.parse(srcFile);
        JSONObject userLoginObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) userLoginObject.get("userLogins");
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject users = (JSONObject) jsonArray.get(i);
             serviceNumber = (String) users.get("serviceNumber");
             password = (String) users.get("password");
            String role=(String) users.get("Role");
            arr[i] = role +","+ serviceNumber + "," + password;
        }
        return arr;
    }
}

