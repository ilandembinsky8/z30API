package apiPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLog
{

	private static int i = 1; /* for line nmber */

	public static void writeToLog(String content, String status)
	{
		File file = new File("C:\\Users\\untitled\\Desktop\\output.txt");

		try
		{
			// if file doesn't exists, then create it
			if (!file.exists())
			{
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			Date d = new Date();
			String msg = i + "- Method: " + content + " Time invoked: " + d + " Status: " + status;
			i++;
			bw.write(msg);
			bw.newLine();
			bw.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

//	//hai bekaffe tkon marra w7de awwal kol function feha logger!
//	StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
//	StackTraceElement e = stacktrace[1];//coz 0th will be getStackTrace so 1st
//	String methodName = e.getMethodName();
//	//hai al kre2ah
//	FileLog.writeToLog(methodName,"Success");/*call*/
}
