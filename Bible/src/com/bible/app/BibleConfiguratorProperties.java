package com.bible.app;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BibleConfiguratorProperties
{
	String mailTo;
	String newInputPath;
	String oldInputPath;
	String nivInputPath;
	String configFilePath;
	String rejectFilePath;

	public void setMailTo( String mailTo )
	{
		this.mailTo = mailTo;
	}
	
	public String getMailTo()
	{
		return mailTo;
	}
	
	public void setNewInputPath( String newInputPath )
	{
		this.newInputPath = newInputPath;
	}
	
	public String getNewInputPath()
	{
		return newInputPath;
	}

	public void setOldInputPath( String oldInputPath )
	{
		this.oldInputPath = oldInputPath;
	}

	public String getOldInputPath()
	{
		return oldInputPath;
	}

	public void setNivInputPath( String nivInputPath )
	{
		this.nivInputPath = nivInputPath;
	}

	public String getNivInputPath()
	{
		return nivInputPath;
	}

	public void setConfigFilePath( String configFilePath )
	{
		this.configFilePath = configFilePath;
	}

	public String getConfigFilePath()
	{
		return configFilePath;
	}

	public void setRejectFilePath( String rejectFilePath )
	{
		this.rejectFilePath = rejectFilePath;
	}

	public String getRejectFilePath()
	{
		return rejectFilePath;
	}
}
