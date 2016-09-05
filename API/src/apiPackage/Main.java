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
	private static String url1 = "http://primo.nli.org.il/PrimoWebServices/xservice/search/brief?json=true"
							   + "&institution=NNL&loc=local,scope:(NNL)"
							   + "&query=facet_rtype,exact,manuscripts"
							   + "&query=facet_tlevel,exact,online_resources"
							   + "&query=any,contains,Ms.%20Ar&query=creator,exact,\"حافظ،\""
							   + "&query_exc=facet_lang,exact,heb"
							   + "&indx=1"
							   + "&bulkSize=50";
	
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
	public static JSONObject convertToJson(BookRetrieve reply) throws JSONException
	{
		JSONObject jsonObj = new JSONObject(reply);

		return jsonObj;
	}
	public static void main(String[] args) throws Exception
	{				
		try
		{
			SearchReply reply = new SearchReply(url2);
			JSONObject replyJSON = convertToJson(reply);
			File fileDir = new File("C:\\Users\\sQasim\\Desktop\\SheetsJSON-UTF.json");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF8"));
			out.append(replyJSON.toString());
			out.flush();
			out.close();
			
			BookSearchReply bookReply = new BookSearchReply(url1);
			JSONObject bookReplyJSON = convertToJson(bookReply);
			File fileDir1 = new File("C:\\Users\\sQasim\\Desktop\\BooksJSON-UTF.json");
			Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir1), "UTF8"));
			out1.append(bookReplyJSON.toString());
			out1.flush();
			out1.close();
			
			BookRetrieve bookR = new BookRetrieve("NNL_ALEPH003157499");
			JSONObject bookRJSON = convertToJson(bookR);
			File fileDir2 = new File("C:\\Users\\sQasim\\Desktop\\BooksRETRIEVEJSON-UTF.json");
			Writer out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir2), "UTF8"));
			out2.append(bookRJSON.toString());
			out2.flush();
			out2.close();
		        
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
