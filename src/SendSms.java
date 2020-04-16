/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;

/**
 *
 * @author I.O.I
 */
public class SendSms {
    public static void main(String[] args) {
        System.out.println("HELLO HERE !!");
        try {
            // Construct data
            String apiKey = "apikey=" + "CloJL9vvZtg-o3uLfYL8TulyD4teSqI8lUjU4hg3Kh";
            String message = "&message=" + "You know nothing !!";
            String sender = "&sender=" + "morta";
            String numbers = "&numbers=" + "28606573";
            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                    //stringBuffer.append(line);
                    System.out.println("message = "+line);
            }
            rd.close();
            //return stringBuffer.toString();
        } catch (Exception e) {
                System.out.println("Error SMS "+e);
                //return "Error "+e;
        }

    }
}
