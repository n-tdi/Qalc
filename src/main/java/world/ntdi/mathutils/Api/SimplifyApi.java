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

public class SimplifyApi {
    public static String simpApiResult(String expression) throws IOException, ParseException {
        String json = "{\"simp\":\"" + expression + "\"}";
        HttpURLConnection http = mathApiPost(json);
        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }

        JSONParser parse = new JSONParser();
        JSONObject data_obj = (JSONObject) parse.parse(sb.toString());

        String obj = (String) data_obj.get("result");
        return obj;
    }

    public static HttpURLConnection mathApiPost(String json) throws IOException, ParseException {
        URL url = new URL("http://localhost:3000/api/simp"); // https://github.com/professional-tdi/Math-Api
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
