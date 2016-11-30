package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class ScrapeHyperlinks {
	 
 
  public static void main(String[] args) throws FileNotFoundException {
	  HSSFWorkbook workbook = new HSSFWorkbook();
	  HSSFSheet sheet = workbook.createSheet("Sample sheet");
	  
	 int k=0;
    try {
    	
      String [] cin={
    		  
    		  "U70101DL1998PTC096126",
    		  "U29199DL2003PTC121741",
    		  "U15494DL2011PTC220014",
    		  "U45209DL2008PTC183478",
    		  "U28998DL2005PTC133974",
    		  "U72900DL2009PTC196974",
    		  "U29199DL2003PTC122262",
    		  "U22122DL2003PTC123741",
    		  "U51101DL2014PTC271288",
    		  "U74899DL1987PTC029491",
    		  "U74899DL1995PTC065176",
    		  "U74899DL1996PTC079445",
    		  "U45204DL2011PTC222207",
    		  "U70102DL2006PTC149577",
    		  "U74899DL1973PTC006927",
    		  "U70102DL2013PTC262102",
    		  "U70109DL2013PTC248564",
    		  "U74899DL1992PTC049991",
    		  "U74899DL1995PLC065809",
    		  "U74140DL2000PTC103929",
    		  "U74899DL1986PTC025963",
    		  "U74899DL1995PTC065651",
    		  "U72200DL2010PTC199008",
    		  "U72200DL2005PTC144131",
    		  "U51909DL2010PTC209406",
    		  "U30007DL2003PTC122544",
    		  "U45400DL2011PTC229207",
    		  "U74899DL1994PTC057383",
    		  "U74120DL2008PTC178576",
    		  "U36912DL2014PTC264236",
    		  "U23201DL2012PTC236165",
    		  "U74899DL1998PTC097147",
    		  "U72300DL2006PTC155188",
    		  "U19201DL2005PTC139617",
    		  "U74899DL1992PTC050526",
    		  "U74899DL1987PTC029533",
    		  "U74899DL1990PLC039861",
    		  "U51500DL2006PTC155685",
    		  "U92412DL2011PTC224221",
    		  "U74899DL1981PTC012174",
    		  "U29253DL2007PTC157303",
    		  "U72400DL2008PTC175783",
    		  "U74899DL1989PTC036343",
    		  "U74899DL1959PTC003018",
    		  "U74899DL1993PTC055150",
    		  "U74999DL2011PTC216315",
    		  "U74899DL1986PTC024961",
    		  "U93000DL2011PTC225532",
    		  "U20200DL2010PTC199919",
    		  "U74999DL2004PTC125819"

    		  
      };
      
      
      
      String[] companyname={
    		  
    		  "A P M BUILDCON PRIVATE LIMITED",
    		  "A P M FOOD MACHINERY PRIVATE LIMITED",
    		  "A P MADHAV SWEETS & FOOD PRIVATE LIMITED",
    		  "A P MANAGEMENT FACILITIES PRIVATE LIMITED",
    		  "A P METACIL PRIVATE LIMITED",
    		  "A P MULTI SERVICES PRIVATE LIMITED",
    		  "A P MULTITECH (INDIA) PRIVATE LIMITED",
    		  "A P OFFSET PRIVATE LIMITED",
    		  "A P OVERSEAS PRIVATE LIMITED",
    		  "A P POLYPLAST PRIVATE LIMITED",
    		  "A P PROPERTIES PRIVATE LIMITED",
    		  "A P R DEVELOPERS PRIVATE LIMITED",
    		  "A P REALTECH PRIVATE LIMITED",
    		  "A P S BUILDCON PRIVATE LIMITED",
    		  "A P S CROWNS INDUSTRIES PRIVATE LIMITED",
    		  "A P S HEIGHTS PRIVATE LIMITED",
    		  "A P S INFRASTRUCTURES PRIVATE LIMITED",
    		  "A P S MEDICAL AND RESEARCH CENTRE PVT LTD",
    		  "A P S SECURITIES LIMITED",
    		  "A P SECURITAS INDIA PRIVATE LIMITED",
    		  "A P SECURITAS PRIVATE LIMITED",
    		  "A P SECURITIES PRIVATE LIMITED",
    		  "A P SOFTECH PRIVATE LIMITED",
    		  "A P SOLUTION PRIVATE LIMITED",
    		  "A P U TRADERS & BUILDERS PRIVATE LIMITED",
    		  "A PAUL INSTRUMENTS PRIVATE LIMITED",
    		  "A PLUS BUILDTECH PRIVATE LIMITED",
    		  "A PLUS COMPONENTS PRIVATE LIMITED",
    		  "A PLUS FINANCIAL SOLUTIONS PRIVATE LIMITED",
    		  "A PLUS INDUSTRIES PRIVATE LIMITED",
    		  "A PLUS LUBRICANTS PRIVATE LIMITED",
    		  "A PLUS SECURITY SERVICE AND TRAINING INSTITUTE PRIVATE LIMITED",
    		  "A PLUS SOLUTIONS PRIVATE LIMITED",
    		  "A R A LEATHERS PRIVATE LIMITED",
    		  "A R AGRO INDUSTRIES PRIVATE LIMITED",
    		  "A R ASSOCIATES PRIVATE LIMITED",
    		  "A R B BEARINGS LIMITED",
    		  "A R B R EXIM PRIVATE LIMITED",
    		  "A R BIOTECH HERBALS PRIVATE LIMITED",
    		  "A R BROTHERS PRIVATE LIMITED",
    		  "A R C A ENGINEERING AND DESIGN CENTRE PRIVATE LIMITED",
    		  "A R C DATASYNC PRIVATE LIMITED",
    		  "A R C OVERSEAS PRIVATE LIMITED",
    		  "A R CHADHA AND CO INDIA PVT LTD",
    		  "A R CO-EXTRUDED FILMS PRIVATE LIMITED",
    		  "A R CONTRACTS (DELHI) PRIVATE LIMITED",
    		  "A R CUBE DESIGNERS PRIVATE LIMITED",
    		  "A R D JOBS ALERT PRIVATE LIMITED",
    		  "A R DECOR LIVING PRIVATE LIMITED",
    		  "A R DIAMOND AND GEM GRADING SERVICES PRIVATE LIMITED"

     };
      
      FileOutputStream out = 
				new FileOutputStream(new File("D:\\companyemails.xls"));
      Cell cell=null;
      Row row = sheet.createRow(0);
      Map<String, Object[]> data = new HashMap<String, Object[]>();
      for(int i=0;i< (companyname.length);i++){
    	 
    	  String getcomapnyname=companyname[i];
    	  String replacenameby=	getcomapnyname.replaceAll(" ","-");
    	  Document doc = Jsoup.connect("https://www.zaubacorp.com/company/"+replacenameby+"/"+cin[i]+"").get();
          
          // get the page title
          //String title = doc.title();
         
          
          // get all links in page
          Elements links = doc.select("div[class=col-lg-6 col-md-6 col-sm-12 col-xs-12] p:eq(0)");
         
          
          
          
          String s=null;
         for (Element link : links) {
            s+=link.text();
        	}
         
       String emailis=s.split("Email ID: ")[1];
      System.out.println(emailis);
      data.put(cin[i],  new Object[]{cin[i],companyname[i],emailis});
    //Create a new cell in current row
   }
    
     App d= new App();
     d.entrydata(data);
    
    } catch (IOException e) {
    e.printStackTrace();
    }
    finally {
    	System.out.println("excle write");
	}
  }
}