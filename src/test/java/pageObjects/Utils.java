package pageObjects;

import java.io.*;
import java.net.*;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Utils {

	static String host = "https://staging.v2c.cloud/v2cservice/oauth/token";
	static String username = "admin@v2c.com";
	static String password = "V2CBox2020";
	static String token = "Basic YWRtaW5AdjJjLmNvbToxMjM0";
	//static String device_id = "NWAIB8V";
	static String device_id = "QY377MV";

	public static String getToken() throws IOException {
	    String url = host+"?grant_type=password&scope=admin&username="+ username + "&password=" + password;
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	    con.setRequestMethod("POST");
	    con.setRequestProperty("Authorization",token);
	    con.setRequestProperty("Content-type","application/json");
	    con.setDoOutput(true);

	    int responseCode = con.getResponseCode();
	    //System.out.println("POST Response Code :: " + responseCode);

	    if (responseCode == HttpURLConnection.HTTP_OK) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();

	        // print result
	       // System.out.println(response.toString());

	       
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode Data = objectMapper.readTree(response.toString());
	        String token = Data.get("access_token").asText();
	        //System.out.println(token);
	        return token;
	    } else {
	        return "";
	    }
	}

	public static String getReported(String device_id) throws IOException {
	    String token = getToken();

	    if(token.equals(""))
	    {
	        return "Error obtaining Token";
	    }else
	    {
	        String url = "https://v2c.cloud/v2cservice/api/v1/device/" + device_id + "/reported";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	        con.setRequestMethod("GET");
	        con.setRequestProperty("Authorization","Bearer " + token);
	        con.setRequestProperty("Content-type","application/json");

	        con.setDoOutput(false);

	        int responseCode = con.getResponseCode();
	        System.out.println("GET Response Code :: " + responseCode);

              

	        try {
	            BufferedReader br = new BufferedReader(
	                    new InputStreamReader(con.getInputStream(), "utf-8"));
	            StringBuilder response = new StringBuilder();
	            String responseLine = null;
	            while ((responseLine = br.readLine()) != null) {
	                response.append(responseLine.trim());
	            }
	            return response.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error in Reported";
	        }
	    }

	}
	
	public static String lockDevice(String device_id,boolean locked) throws IOException
	{
		String token = getToken();
		 String line;
		 String url;
         StringBuilder response = new StringBuilder();
		if(token.equals(""))
	    {
	        return "Error obtaining Token";
	    }else
	    {
	    	
	        
	        
	    	if(locked)
	    	{
	    		 url = "https://v2c.cloud/v2cservice/api/v1/device/" + device_id + "/locked/?value=1";
	    	}else
	    	{
	    		 url = "https://v2c.cloud/v2cservice/api/v1/device/" + device_id + "/locked/?value=0";
	    	}
	    	
	    	URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("Authorization","Bearer " + token);
	        con.setRequestProperty("Content-type","application/json");
	        con.setDoInput(true);
	        con.setDoOutput(true);
	       
	    	
	        
	       
	        
	        OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
 
         
            int responseCode=con.getResponseCode();
            System.out.println("Lock response code : "+responseCode);
           
            if (responseCode == HttpURLConnection.HTTP_OK) {
              
	        
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response.append(line);
                }
            }
            else {
                response.append("");

            }
	    }

		return response.toString();
	}
	
	
	
	
	public static String getConnected(String device_id) throws IOException {
	    String token = getToken();

	    if(token.equals(""))
	    {
	        return "Error obtaining Token";
	    }else
	    {
	        String url = "https://v2c.cloud/v2cservice/api/v1/device/" + device_id + "/connected";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	        con.setRequestMethod("GET");
	        con.setRequestProperty("Authorization","Bearer " + token);
	        con.setRequestProperty("Content-type","application/json");

	        con.setDoOutput(false);

	        int responseCode = con.getResponseCode();
	        System.out.println("getConnected GET Response Code :: " + responseCode);

            

	        try {
	            BufferedReader br = new BufferedReader(
	                    new InputStreamReader(con.getInputStream(), "utf-8"));
	            StringBuilder response = new StringBuilder();
	            String responseLine = null;
	            while ((responseLine = br.readLine()) != null) {
	                response.append(responseLine.trim());
	            }
	            return response.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error in getConnected";
	        }
	        
	    }

	}
	
	
	
	

	public static void main(String[] args) throws IOException {

		
		 
	  System.out.println(lockDevice(device_id,true));
	  System.out.println(lockDevice(device_id,false));
	    //System.out.println(getConnected(device_id));
	    
	    //System.out.println(getReported("NWAIB8V")); 
	  System.out.println(getReported(device_id));
	
	  
	}
}