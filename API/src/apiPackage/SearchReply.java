package apiPackage;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchReply
{
	private int totalHits;
	private Sheet[] docs;
	
	public SearchReply(int totalHits, int arrSize)
	{
		this.totalHits = totalHits;
		this.docs = new Sheet[arrSize];
	}
	public int getTotalHits()
	{
		return this.totalHits;
	}
	public void setTotalHits(int totalHits)
	{
		this.totalHits = totalHits;
	}
	public Sheet[] getDocs()
	{
		return this.docs;
	}
	public void setDocs(Sheet[] docs)
	{
		this.docs = docs;
	}
	
	public SearchReply(String url) throws Exception
	{
		HTTPConnection con = new HTTPConnection(url);
		JSONObject obj = con.sendGet();
		
		this.totalHits = Integer.parseInt(obj.get("@TOTALHITS").toString());
		JSONArray arr  = (JSONArray)obj.get("DOC");
		
		docs = new Sheet[arr.length()];
		
		System.out.println();
		System.out.println("Total Hits of this request is: " + totalHits);
		System.out.println("Result Array length is: " + arr.length());
		System.out.println();
		
		for (int i = 0; i < arr.length(); i++)
		{
			JSONObject JSONdoc = (JSONObject) arr.get(i);
			JSONObject PrimoNMBib = (JSONObject) JSONdoc.get("PrimoNMBib");
			JSONObject record = (JSONObject) PrimoNMBib.get("record");
			JSONObject control = (JSONObject) record.get("control");
			JSONObject display = (JSONObject) record.get("display");
			
			Sheet sheet = new Sheet();
			
			if (display.has("lds03"))
				sheet.setAuthor(display.get("lds03").toString());
			
			if (display.has("creationdate"))
				sheet.setCreationdate(display.get("creationdate").toString());
			
			if (display.has("lds21"))
				sheet.setLibWebLink(display.get("lds21").toString());
			
			if (display.has("lds42"))
				sheet.setPage(display.get("lds42").toString());
			
			if (display.has("publisher"))
				sheet.setPublisher(display.get("publisher").toString());
			
			if (control.has("recordid"))
				sheet.setRecordId(control.get("recordid").toString());
			
			if (display.has("source"))
				sheet.setSource(display.get("source").toString());
			
			if (display.has("subject"))
				sheet.setSubject(display.get("subject").toString());
			
			if (display.has("lds41"))
				sheet.setThumbnail(display.get("lds41").toString());
			
			if (display.has("title"))
				sheet.setTitle(display.get("title").toString());
			
			this.docs[i] = sheet;
		}
		printDocs();
	}
	
	public void printDocs()
	{
		for (int i=0; i<this.docs.length; i++)
		{
			System.out.println("Sheet Number: " + (i+1));
			this.docs[i].printSheet();
		}
	}
}