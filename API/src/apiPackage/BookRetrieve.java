package apiPackage;

public class BookRetrieve
{
	private String recordID;
	private Book book;
	private String[] pages;
	
	public BookRetrieve(String recordID)
	{
		String url = createURL(recordID);
		HTTPConnection con = new HTTPConnection(url);
		
	}
	
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
}
