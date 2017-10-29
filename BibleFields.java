package com.bible.processors;

public class BibleFields
{
	String book;
	String chapter;
	String verse;
	String text;
	int rowId;

	public String getBook()
	{
		return book;
	}

	public void setBook( String book )
	{
		this.book = book;
	}

	public String getChapter()
	{
		return chapter;
	}

	public void setChapter( String chapter )
	{
		this.chapter = chapter;
	}

	public String getVerse()
	{
		return verse;
	}

	public void setVerse( String verse )
	{
		this.verse = verse;
	}

	public String getText()
	{
		return text;
	}

	public void setText( String text )
	{
		this.text = text;
	}

	public int getRowId()
	{
		return rowId;
	}

	public void setRowId( int rowId )
	{
		this.rowId = rowId;
	}
}
