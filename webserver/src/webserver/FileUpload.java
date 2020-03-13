package webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

 
@WebServlet("/upload")
@MultipartConfig(location="/tmp",
				 fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class FileUpload extends HttpServlet {
 
    private static final long serialVersionUID = 205242440643911308L;
    private static final String UPLOAD_DIR = "uploads";
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
    	response.setContentType("text/html;charset=UTF-8");
        // Pasta dos arquivos subidos ao servidor
        
        final String uploadFolderPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        
        new File(uploadFolderPath).mkdir();

        // Create path components to save the fi
        
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);
   

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new 
            		File(uploadFolderPath
                    ,fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
        
        String result = null;
        try 
        {
        	result = getValidationResult(request.getServletContext().getRealPath("") ,uploadFolderPath + File.separator + fileName);
        }
        catch (IOException e)
        {
        	
        }

        System.out.println("RESULTADO: " + result);
        /*
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print(result); 
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
        */
    }

    private String getFileName(final Part part) {
    	for (String content : part.getHeader("content-disposition").split(";")) {
        	if (content.trim().startsWith("filename")) {
        		return content.substring(
            	content.indexOf('=') + 1).trim().replace("\"", "");
        	}
    	}
    	return null;
	}
    
    private String getValidationResult(String appFolder, String filePath) throws IOException 
    {
    	String[] cmdArray = new String[4];
		cmdArray[0] = "java";
		cmdArray[1] = "-jar";
		cmdArray[2] = "pdfmodule.jar";
		cmdArray[3] = filePath;
		
		final String pathToLib = "WEB-INF" + File.separator + "lib" + File.separator;
		final String libFolderPath = appFolder + File.separator + pathToLib;
		
		Process proc = Runtime.getRuntime().exec(cmdArray ,null, new File(libFolderPath));	
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line = null;
		
		while((line = reader.readLine()) != null)
		{
			builder.append(line);
			builder.append(System.getProperty("line.separator"));
		}
		String result = builder.toString();
		
		try {
			proc.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
    }
}
