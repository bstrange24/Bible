package com.bible.config;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BibleConfiguratorProperties
{
	String mailTo;
	String inputFilePath;
	String configFilePath;
	String rejectFilePath;

	public String getMailTo()
	{
		return mailTo;
	}

	public void setMailTo( String mailTo )
	{
		this.mailTo = mailTo;
	}

	public String getInputFilePath()
	{
		return inputFilePath;
	}

	public void setInputFilePath( String inputFilePath )
	{
		this.inputFilePath = inputFilePath;
	}

	public String getConfigFilePath()
	{
		return configFilePath;
	}

	public void setConfigFilePath( String configFilePath )
	{
		this.configFilePath = configFilePath;
	}

	public String getRejectFilePath()
	{
		return rejectFilePath;
	}

	public void setRejectFilePath( String rejectFilePath )
	{
		this.rejectFilePath = rejectFilePath;
	}
}
