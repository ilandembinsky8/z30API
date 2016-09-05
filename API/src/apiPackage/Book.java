package apiPackage;

public class Book
{

	private String recordId;
	private String author;
	private String title;
	private String publisher;
	private String creationdate;
	private String subject;
	private String source;
	private String thumbnail;
	private String webLink;

	public String getWebLink()
	{
		return webLink;
	}

	public void setWebLink(String webLink)
	{
		this.webLink = webLink;
	}

	public String getRecordId()
	{
		return this.recordId;
	}

	public void setRecordId(String recordId)
	{
		this.recordId = recordId;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
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
		return creationdate;
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

	public void printBook()
	{
		System.out.println("Title: " + getTitle());
		System.out.println("Author: " + getAuthor());
		System.out.println("Creation Date: " + getCreationdate());
		System.out.println("Subject: " + getSubject());
		System.out.println("Publisher: " + getPublisher());
		System.out.println("Record ID: " + getRecordId());
		System.out.println("Source: " + getSource());
		System.out.println("Thumbnail: " + getThumbnail());
		System.out.println("WebLink: " + getWebLink());
		System.out.println("******************************************************************");
		System.out.println();

	}
}