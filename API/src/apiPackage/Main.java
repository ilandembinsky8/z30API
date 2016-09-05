package apiPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.json.JSONException;
import org.json.JSONObject;

public class Main
{
	private static String url1 = "http://primo.nli.org.il/PrimoWebServices/xservice/search/brief?institution=NNL"
							  + "&loc=local,scope:(NNL)" 
							  + "&query=creator,exact,حافظ" 
							  + "&indx=1"  
							  + "&bulkSize=50"
							  + "&json=true";
	
	private static String url2 = "http://primo.nli.org.il/PrimoWebServices/xservice/search/brief?json=true"
			 				  + "&institution=NNL&loc=local,scope:(NNL_Ephemera)" 
							  + "&query_inc=facet_lang,exact,ara"
							  + "&query_inc=facet_tlevel,exact,NoRestrictions" 
							  + "&indx=1"
							  + "&bulkSize=50";
	
	public static JSONObject convertToJson(SearchReply reply) throws JSONException
	{
		JSONObject jsonObj = new JSONObject(reply);

		return jsonObj;
	}
	
	public static JSONObject convertToJson(BookSearchReply reply) throws JSONException
	{
		JSONObject jsonObj = new JSONObject(reply);

		return jsonObj;
	}

	public static void main(String[] args) throws Exception
	{		
		SearchReply reply = new SearchReply(url2);
		BookSearchReply bookReply = new BookSearchReply(url1);
		
		JSONObject replyJSON = convertToJson(reply);
		JSONObject bookReplyJSON = convertToJson(bookReply);
		
		try
		{
			File fileDir = new File("C:\\Users\\sQasim\\Desktop\\SheetsJSON-UTF.txt");
			File fileDir1 = new File("C:\\Users\\sQasim\\Desktop\\BooksJSON-UTF.txt");
			
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF8"));
			Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir1), "UTF8"));
			
			out.append(replyJSON.toString());
			out1.append(bookReplyJSON.toString());
			
			out.flush();
			out1.flush();
			out.close();
			out1.close();
		        
		} 
		catch (UnsupportedEncodingException e) 
		{
		 	System.out.println(e.getMessage());
		} 
		catch (IOException e) 
		{
		   	System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
		   	System.out.println(e.getMessage());
		} 
	}
		
}
