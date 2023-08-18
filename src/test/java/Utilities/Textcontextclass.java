package Utilities;

import java.io.IOException;

import PageObjectfiles.PageObjectManager;

public class Textcontextclass {

	public TestBaseDriver testbase;
	public PageObjectManager pageobject;
	public Textcontextclass() throws IOException {
		testbase =new TestBaseDriver();
		pageobject = new PageObjectManager(testbase.WebDriverManager());
		
	}
}
