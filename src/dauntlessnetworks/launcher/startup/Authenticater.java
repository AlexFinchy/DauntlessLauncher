package dauntlessnetworks.launcher.startup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Authenticater {
	
	public static final String MojangURL = "https://authserver.mojang.com/authenticate";
	
	public static int TimeOut = 10000; //TIME OUT
	
	String Username;
	
	String Password;
	
	public Authenticater(String Username, String Password) {
	    this.Username = Username;
	    this.Password = Password;
		
	}
	
	public JSONObject Authenticate() throws IOException, JSONException  {
		
		URL url = new URL(MojangURL);
		
		HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(TimeOut);
		connection.setReadTimeout(TimeOut);
		connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	    connection.setRequestProperty("Accept", "application/json");
	    connection.setDoOutput(true);
		
	    JSONObject Agent = new JSONObject();
	    Agent.put("name", "minecraft");
	    Agent.put("version", 1);
	    JSONObject MainObject = new JSONObject();
	    MainObject.put("agent", Agent);
	    MainObject.put("username", Username);
	    MainObject.put("password", Password);
	    MainObject.put("requestUser", true);
	    
	    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());  
	    out.write(MainObject.toString());
	    out.flush();
	    out.close(); 
	    System.out.println("Attempting to Login");
	    
	    int res = connection.getResponseCode();
	    System.out.println(res);
	    if(res == 403) {
			InputStream is = connection.getErrorStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			JSONObject jsonObject = new JSONObject(br.readLine());
			return jsonObject;
	    }

	    InputStream is = connection.getInputStream();
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    JSONObject jsonObject = new JSONObject(br.readLine());
	    connection.disconnect();
	    
	    return jsonObject;
		
	}

	
}
