import java.io.*;
import java.util.*; 
import java.nio.file.*;
import java.time.*;
class pplq1 
{
	public List<String> readTextFileByLines(String fileName) throws IOException
        {
		List<String> lines = Files.readAllLines(Paths.get(fileName));return lines;
	}
	public void writeToTextFile(String fileName, String content) throws IOException
        {
		Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
	}
	public void connect( boy []b, girl []g) throws IOException
        {
		int boy_counter=0;
                                
		DataOutputStream ds_cont = new DataOutputStream(new FileOutputStream("logfile.txt")); 
		
                for (int girl_counter=0; girl_counter<g.length; girl_counter++) 
                {
			if ( b[boy_counter].maintainencebudget > g[girl_counter].maintainencebudget && g[girl_counter].committed == false && b[boy_counter].committed == false) 
                        {
				g[girl_counter].boyfriend = b[boy_counter].name;g[girl_counter].committed = true;
				b[boy_counter].girlfriend = g[girl_counter].name;b[boy_counter].committed = true;				
				ds_cont.writeBytes(g[girl_counter].name+" got committed to "+b[boy_counter].name+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");      
				boy_counter++;
			} 
                        else if (  b[boy_counter].maintainencebudget < g[girl_counter].maintainencebudget && g[girl_counter].committed == false && b[boy_counter].committed == false) 
                        {
				boy_counter++;girl_counter--;
			}			
		}
	}
	public static void main(String args[]) throws IOException
        {
		int boy_cnt = 7;
                int girl_cnt = 5;
                int k = 0;int z = 0; 
		boy b[] = new boy[boy_cnt];girl g[] = new girl[girl_cnt];		
		pplq1 FilesUtil = new pplq1();		
		
                List<String> total_b = FilesUtil.readTextFileByLines("b_inf.txt");
		Object arrb[] = total_b.toArray(); 
		
                for (int i=0; i<arrb.length; i++) 
                {
			String str = arrb[i].toString();
			if (str.length() == 0) 	continue;
			String strarr[] = str.split(",");
			b[k++] = new boy(strarr);
		}	
		
                List<String> total_girl = FilesUtil.readTextFileByLines("Girls_data.txt");
		Object arrg[] = total_girl.toArray();
		
                for (int i=0; i<arrg.length; i++) 
                {
			String str = arrg[i].toString();
			if (str.length() == 0)	continue;
			String strarr[] = str.split(",");g[z++] = new girl(strarr);
		}
		FilesUtil.connect(b, g);
	}
}