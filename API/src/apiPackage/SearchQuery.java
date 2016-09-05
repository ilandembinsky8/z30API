package apiPackage;

public class SearchQuery
{
	private int index;
	private int blockSize;
	private String author;
	private String genre;
	private int startYear;
	private int endYear;
	private String title;
	private String subject;
	
	private final String scope  = "http://primo.nli.org.il/PrimoWebServices/xservice/search/brief?json=true&query_inc=facet_tlevel,exact,NoRestrictions&institution=NNL&loc=local,scope:(NNL_Ephemera)&query_inc=rtype,exact,sheet";
	
	private final String[] queries = {"&query_inc=facet_lang,exact,"
									 ,"&query_inc=facet_creator,exact,"
									 ,"&query_inc=facet_creationdate,exact,"
									 ,"&query_inc=facet_genre,exact,"
									 ,"&query_inc=facet_topic,exact,"};

	public SearchQuery()
	{
		this.index = -1;
		this.blockSize = -1;
		this.author = "any";
		this.genre = "any";
		this.startYear = -1;
		this.endYear = -1;
		this.title = "any";
		this.subject = "any";
		throw new UnsupportedOperationException();
	}

	public String createQuery()
	{
		// TODO - implement SheetSearchQuery.createQuery
		throw new UnsupportedOperationException();
	}
	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public int getIndex()
	{
		return this.index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public int getBlockSize()
	{
		return this.blockSize;
	}

	public void setBlockSize(int blockSize)
	{
		this.blockSize = blockSize;
	}

	public String getAuthor()
	{
		return this.author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public int getStartYear()
	{
		return this.startYear;
	}

	public void setStartYear(int startYear)
	{
		this.startYear = startYear;
	}

	public int getEndYear()
	{
		return this.endYear;
	}

	public void setEndYear(int endYear)
	{
		this.endYear = endYear;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String[] getQueries()
	{
		return queries;
	}

	public String getScope()
	{
		return scope;
	}
}