package com.bible.exceptions;

public class BibleException extends Exception
{
	private static final long serialVersionUID = 6554771916224287762L;
	private String message = null;
	
	public BibleException()
	{
		super();
	}
	
	public BibleException( String message )
	{
		super( message );
		this.message = message;
	}
	
	public BibleException( Throwable cause )
	{
		super( cause );
	}
	
	@Override
	public String toString()
	{
		return message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
}
