package apiPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

public class HTTPConnection
{
	private String url;

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public HTTPConnection(String url)
	{
		this.url = url;
	}

	private final String USER_AGENT = "Mozilla/5.0";

	// HTTP GET request
	public JSONObject sendGet() throws Exception
	{
		URL obj = new URL(this.url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		System.out.println(url);
		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF8"));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null)
		{
			response.append(inputLine);
		}
		in.close();

		JOptionPane.showMessageDialog(null, "Receipt Saved!");

		JSONObject jsonObject = new JSONObject(response.toString());
		
		System.out.println("Got jsonObject");
		String newstr;
		JSONArray arr;

		if (jsonObject.has("SEGMENTS"))
		{
			newstr = jsonObject.get("SEGMENTS").toString();
			jsonObject = new JSONObject(newstr);
		}
		else
		{
			System.out.println("SEGMENTS does not exist!");
		}
 
		System.out.println("Got SEGMENTS");

		if (jsonObject.has("JAGROOT"))
		{
			newstr = jsonObject.get("JAGROOT").toString();
			jsonObject = new JSONObject(newstr);
		}
		else
		{
			System.out.println("JAGROOT does not exist!");
		}
 
		System.out.println("Got JAGROOT");

		if (jsonObject.has("RESULT"))
		{
			newstr = jsonObject.get("RESULT").toString();
			jsonObject = new JSONObject(newstr);
		}
		else
		{
			System.out.println("RESULT does not exist!");
		}
 
		System.out.println("Got RESULT");

		if (jsonObject.has("DOCSET"))
		{
			newstr = jsonObject.get("DOCSET").toString();
			jsonObject = new JSONObject(newstr);
		}
		else
		{
			System.out.println("DOCSET does not exist!");
		}
 
		System.out.println("Got DOCSET");

		if (jsonObject.has("DOC"))
		{
			arr = (JSONArray) jsonObject.get("DOC");
			System.out.print("Got an ARRAY!,  Array Length is: " + arr.length());
		}
		else
		{
			System.out.println("DOC does not exist!");
		}
 
		System.out.println();

		return jsonObject;
	}
}