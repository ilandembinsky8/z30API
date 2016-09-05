package apiPackage;

public class SearchQuery
{	
	private final String sheetScope  = "http://primo.nli.org.il/PrimoWebServices/xservice/search/brief?json=true"
									 + "&query_inc=facet_tlevel,exact,NoRestrictions"
									 + "&institution=NNL"
									 + "&loc=local,scope:(NNL_Ephemera)";
	
	private final String BookScope   = "http://primo.nli.org.il/PrimoWebServices/xservice/search/brief?institution=NNL&json=true"
									 + "&loc=local,scope:(NNL)&query=facet_tlevel,exact,online_resources";
	
	private final String[] queries = {"&query_inc=facet_lang,exact,"//0
									 ,"&query_inc=creator,exact,"//author 1
									 ,"&query_inc=creationdate,exact,"//2 
									 ,"&query_inc=genre,exact,"//3
									 ,"&query_inc=topic,exact,"//4
									 ,"&query_inc=title,exact,"//5
									 ,"&indx="//6
									 ,"&bulkSize="};//7

	private String type;
	private int index;
	private int blockSize;
	private String author;
	private String genre;
	private int startYear;
	private int endYear;
	private String title;
	private String subject;

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
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getSheetScope()
	{
		return sheetScope;
	}
	public String getBookScope()
	{
		return BookScope;
	}

	public String URLQuery()
	{
		String scope;
		if (this.type == "book")
			scope = BookScope;
		else if (this.type == "sheet")
			scope = sheetScope;
		else
			scope = "any";
		
		StringBuffer URLquery = new StringBuffer(scope);
		
		// URLquery.append(this.queries[0]);
		if (!this.author.equals("any"))
		{
			URLquery.append(this.queries[1]);
			URLquery.append(this.author);
		}

		// URLquery.append(this.queries[2]);
		if (!this.genre.equals("any"))
		{
			URLquery.append(this.queries[3]);
			URLquery.append(genre);
		}
		// URLquery.append(this.queries[4]);
		if (!this.title.equals("any"))
		{
			URLquery.append(this.queries[5]);
			URLquery.append(title);
		}
		if (this.index != -1)
		{
			if (this.index >= 1)
			{
				URLquery.append(this.queries[6]);
				URLquery.append(this.index);
			}
		}
		if (this.blockSize != -1)
		{
			if (this.index >= 1)
			{
				URLquery.append(this.queries[7]);
				URLquery.append(blockSize);
			}
		}
		System.out.println(URLquery);
		
		return URLquery.toString();
	}
}