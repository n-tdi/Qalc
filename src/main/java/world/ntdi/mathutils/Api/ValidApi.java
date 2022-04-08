package world.ntdi.mathutils.Api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class ValidApi {
    public static ArrayList<String> checkIfValid(String expression) throws IOException, ParseException {
        String json = "{\"eval\":\"" + expression + "\"}";
        HttpURLConnection http = validApiPost(json);
        int responseCode = http.getResponseCode();
        if (responseCode == 200) {
            ArrayList<String> result = new ArrayList<String>();
            result.add("Valid");
            return result;
        } else {
            ArrayList<String> result = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(sb.toString());

            String obj = (String) data_obj.get("result");
            result.add("Invalid");
            result.add(obj);
            return result;
        }
    }

    public static HttpURLConnection validApiPost(String json) throws IOException, ParseException {
        URL url = new URL("http://localhost:3000/api/valid"); // https://github.com/professional-tdi/Math-Api
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);
        String outt = json;
        byte[] out = outt.getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        return http;
    }
}
