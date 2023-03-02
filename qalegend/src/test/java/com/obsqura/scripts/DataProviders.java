package com.obsqura.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	
	  @DataProvider(name="UserDatas")
	  public Object[][] getData()
	  {
		  Object[][] data = {{"Miss", "Pooja", "BA", "pooja@gmail.com", "123456", "123456", "90"}, {"Miss", "Pooja", "BA", "poojab@gmail.com", "123456", "123456", "90"}};
		  return data;
		  
	  }

}
