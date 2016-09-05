package apiPackage;

import org.json.JSONArray;
import org.json.JSONObject;

public class BookRetrieve
{
	private String recordID;
	private Book book = new Book();
	private String[] pages;
	
	private String createURL(String recordID)
	{
		return "http://iiif.nli.org.il/IIIF/DOCID/" + recordID + "/manifest";
	}
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}
	public String[] getPages()
	{
		return pages;
	}
	public void setPages(String[] pages)
	{
		this.pages = pages;
	}
	public String getRecordID()
	{
		return recordID;
	}
	public void setRecordID(String recordID)
	{
		this.recordID = recordID;
	}
	
	public BookRetrieve(String recordID) throws Exception
	{
		this.recordID = recordID;
		String url = createURL(this.recordID);
		HTTPConnection con = new HTTPConnection(url);
		JSONObject manifest = con.sendGetManifest();
		
		JSONArray metadata = (JSONArray) manifest.get("metadata");
		JSONArray structures = (JSONArray) manifest.get("structures");
		JSONObject structuresObj = (JSONObject) structures.get(0);
		JSONArray canvases = (JSONArray) structuresObj.get("canvases");
		
		pages = new String[canvases.length() + 2];
		pages[0] = "http://iiif.nli.org.il/IIIF/";
		pages[canvases.length()+1] = "/full/250,/0/default.jpg";
		
		for (int i = 1; i <= canvases.length(); i++)
		{
			pages[i] = canvases.get(i-1).toString();
		}
		
		JSONObject author = (JSONObject) metadata.get(0);
		JSONObject title = (JSONObject) metadata.get(5);
		JSONObject publisher = (JSONObject) metadata.get(7);
		JSONObject subject = (JSONObject) metadata.get(8);
		JSONObject source = (JSONObject) metadata.get(9);
		
		book.setAuthor(author.get("value").toString());
		book.setPublisher(publisher.get("value").toString());
		book.setSource(source.get("value").toString());
		book.setSubject(subject.get("value").toString());
		book.setTitle(title.get("value").toString());
		book.setWebLink(manifest.get("related").toString());
	}
}
