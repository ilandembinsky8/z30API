package apiPackage;

public class Sheet
{
	private String recordId;
	private String title;
	private String publisher;
	private String creationdate;
	private String subject;
	private String source;
	private String thumbnail;
	private String author;
	private String page;
	private String libWebLink;

	public String getRecordId()
	{
		return this.recordId;
	}

	public void setRecordId(String recordId)
	{
		this.recordId = recordId;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public String getCreationdate()
	{
		return this.creationdate;
	}

	public void setCreationdate(String creationdate)
	{
		this.creationdate = creationdate;
	}

	public String getSubject()
	{
		return this.subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getSource()
	{
		return this.source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getThumbnail()
	{
		return this.thumbnail;
	}

	public void setThumbnail(String thumbnail)
	{
		this.thumbnail = thumbnail;
	}

	public String getAuthor()
	{
		return this.author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getPage()
	{
		return this.page;
	}

	public void setPage(String page)
	{
		this.page = page;
	}

	public String getLibWebLink()
	{
		return this.libWebLink;
	}

	public void setLibWebLink(String libWebLink)
	{
		this.libWebLink = libWebLink;
	}

	public void printSheet()
	{
		System.out.println("Title: " + getTitle());
		System.out.println("Author: " + getAuthor());
		System.out.println("Creation Date: " + getCreationdate());
		System.out.println("Web Link: " + getLibWebLink());
		System.out.println("Page Link: " + getPage());
		System.out.println("Publisher: " + getPublisher());
		System.out.println("Record ID: " + getRecordId());
		System.out.println("Source: " + getSource());
		System.out.println("Thumbnail: " + getThumbnail());
		System.out.println("******************************************************************");
		System.out.println();
	}
}