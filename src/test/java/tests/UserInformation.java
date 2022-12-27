package tests;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class UserInformation {
    Object obj;
    {
        try {
            obj = new JSONParser().parse(new FileReader("src/test/userInformation.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    JSONObject jo = (JSONObject) obj;
    public String ReturnEmail(){
        return (String) jo.get("email");
    }

    public String ReturnPassword(){
        return (String) jo.get("password");
    }

    public String GenerateRandomEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username"+ randomInt +"@gmail.com";
    }
}
