package com.test;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itextpdf.text.DocumentException;


@Controller
public class HtmlToPdfController {

	@RequestMapping(value="createpdf",method = RequestMethod.GET)
	public void getPage(HttpServletRequest request, 
            HttpServletResponse response) throws DocumentException, IOException{
		
		System.out.println(new File("").getAbsolutePath());
		/*Document document = new Document();
    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,new FileInputStream("D:\\Software\\eclipse\\htmttopdf.html"));	
        document.close();
        System.out.println( "PDF Created!" );

		
        
        
    
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
        Path file = Paths.get("pdf.pdf");
        if (Files.exists(file)) 
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename=test.pdf");
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }*/
        
	
			
}
}
