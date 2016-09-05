package apiPackage;

import org.json.JSONArray;
import org.json.JSONObject;

public class BookSearchReply
{

	private int totalHits;
	private Book[] docs;

	public BookSearchReply(String url) throws Exception
	{
		HTTPConnection con = new HTTPConnection(url);
		JSONObject reply = con.sendGet();
		
		this.totalHits = Integer.parseInt(reply.get("@TOTALHITS").toString());
		JSONArray arr  = (JSONArray)reply.get("DOC");
		
		docs = new Book[arr.length()];
		
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
			JSONObject LINKS = (JSONObject) JSONdoc.get("LINKS");
			Object thumbnailObj = LINKS.get("thumbnail");
			
			Book book = new Book();
			
			if (display.has("creator"))
				book.setAuthor(display.get("creator").toString());
			
			if (display.has("creationdate"))
				book.setCreationdate(display.get("creationdate").toString());
			
			if (display.has("lds21"))
				book.setWebLink(display.get("lds21").toString());
			
			if (display.has("publisher"))
				book.setPublisher(display.get("publisher").toString());
			
			if (control.has("recordid"))
				book.setRecordId(control.get("recordid").toString());
			
			if (display.has("source"))
				book.setSource(display.get("source").toString());
			
			if (display.has("subject"))
				book.setSubject(display.get("subject").toString());
			
			if (display.has("title"))
				book.setTitle(display.get("title").toString());
			
			if (thumbnailObj instanceof JSONArray)
			{
				JSONArray linksArray = (JSONArray) thumbnailObj;
				book.setThumbnail(linksArray.get(0).toString());
			}
			else
			{
				book.setThumbnail(LINKS.get("thumbnail").toString());
			}
			
			this.docs[i] = book;
		}
	
		printDocs();
	}
	public BookSearchReply(int totalHits, int arrSize)
	{
		this.totalHits = totalHits;
		this.docs = new Book[arrSize];
	}
	
	public BookSearchReply(int num)
	{
		docs = new Book[num];
	}

	public BookSearchReply(int totalHits, Book[] docs)
	{
		super();
		this.totalHits = totalHits;
		this.docs = docs;
	}

	public Book[] getDocs()
	{
		return docs;
	}

	public void setDocs(Book[] docs)
	{
		this.docs = docs;
	}

	public int getTotalHits()
	{
		return this.totalHits;
	}

	public void setTotalHits(int totalHits)
	{
		this.totalHits = totalHits;
	}
	
	public void printDocs()
	{
		for (int i=0; i<this.docs.length; i++)
		{
			System.out.println("Book Number: " + (i+1));
			this.docs[i].printBook();
		}
	}
}
