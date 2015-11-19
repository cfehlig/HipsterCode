package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;
	// private Book [] hipsterBooks;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
		setupArray();
		setupBooks();
	}
	
	
	private void setupBooks()
	{
		Book firstBook, secondBook, thirdBook;
		firstBook = new Book();
		firstBook.setAuthor("J.K. Rowling");
		firstBook.setTitle("Harry Potter and the Goblet of Fire");
		firstBook.setSubject("Fantasy");
		firstBook.setPageCount(636);
		firstBook.setPrice(17.97);
		
		secondBook = new Book();
		secondBook.setAuthor("Billy Bob");
		secondBook.setTitle("Home");
		secondBook.setSubject("Horror");
		secondBook.setPageCount(378);
		secondBook.setPrice(5.34);
		
		thirdBook = new Book(768,"Joe Johnson", "Learning Calculus", "Math", 150.32 );
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
	}
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream!";
		hipsterPhrases[1] = "I don't mean to sound like a hipster, but, I love vintage stuff";
		hipsterPhrases[2] = "Insert a sarcastic phrase here";
		hipsterPhrases[3] = "I was into that music before it was cool";
	}
	
	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPharses(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}

	public String getName()
	{
		return name;
	}

	public Book[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setHipsterBooks(Book[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}

	
	

}
