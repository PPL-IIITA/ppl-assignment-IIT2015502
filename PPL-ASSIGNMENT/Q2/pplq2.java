import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.time.*;
public class pplq2
{
	public List<String> readTextFileByLines(String fileName) throws IOException
        {
		List<String> lines = Files.readAllLines(Paths.get(fileName));return lines;
	}
	public void writeToTextFile(String fileName, String content) throws IOException
        {
		Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
	}
	public void connect(boy []b,girl []g) throws IOException
        {
		int b_counter=0;
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("logfile.txt")); 
		for (int g_count=0; g_count<g.length; g_count++) {
			if (g[g_count].maintainencebudget < b[g_count].maintainencebudget && g[g_count].committed == false && b[b_counter].committed == false) 
                        {
				g[g_count].boyfriend = b[b_counter].name;g[g_count].committed = true;
				                                
                                b[b_counter].girlfriend = g[g_count].name;b[b_counter].committed = true;				
				dos.writeBytes(g[g_count].name+" got committed to "+b[b_counter].name+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
				b_counter++;
			} else if (g[g_count].maintainencebudget > b[b_counter].maintainencebudget && g[g_count].committed == false && b[b_counter].committed == false)
                        {
				b_counter++;g_count--;
			}
		}
	}
	int search(String girlfriend, girl []g) 
        {
		for (int i=0; i<g.length; i++)
                {
			if (g[i].name.equals(girlfriend))
                            return i;
		}
		return 0;
	}
	public void give_gift(boy []b,girl []g, Happyfii happinessarray[]) throws IOException
        {
		int i;
                int j=0;
		
                
                DataOutputStream ds_cont = new DataOutputStream(new FileOutputStream("log1file.txt")); 
		for (i=0; i<b.length; i++)
                {
			if (b[i].committed == true)
                        {
				double sumval = 0;
                                
                                double sumcost = 0;
				while (sumcost <= b[i].maintainencebudget) 
                                {
					List<String> gift = readTextFileByLines("Gifts.txt");
					Object arrgift[] = gift.toArray();
					
                                        
                                        for (int k=0; k<arrgift.length; k++)
                                        {
						String str = arrgift[k].toString();
						if (str.length() == 0)   continue;
						String strarr[] = str.split(",");
						sumval = sumval + Double.parseDouble(strarr[2]);sumcost = sumcost + Double.parseDouble(strarr[3]);
						ds_cont.writeBytes(b[i].name+" gifts "+strarr[4]+" to "+b[i].girlfriend+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
					}
				}
				int ind = search(b[i].girlfriend, g);
				
                                if (b[i].type.equals("miser")) b[i].happiness = b[i].maintainencebudget-sumcost;
				else if (b[i].type.equals("generous")) b[i].happiness = g[ind].happiness;
				else b[i].happiness = g[ind].intelligencelevel;
				if (g[ind].type.equals("normal")) g[ind].happiness = b[i].maintainencebudget-sumcost;
				else if (g[ind].type.equals("choosy")) g[ind].happiness = Math.log(sumcost);
				else g[ind].happiness = Math.exp(sumcost);
                                
                                happinessarray[j++] = new Happyfii(b[i].name, g[ind].name, b[i].happiness + g[ind].happiness);
			}}}
	public static void main(String args[]) throws IOException 
        {
		int nb = 7;
                int ng = 5;
                int k = 0;
                int z = 0;
                int h_couple = 3; 
		
                
                boy b[] = new boy[nb];girl g[] = new girl[ng];
		Happyfii happinessarray[] = new Happyfii[ng];		
		pplq2 FilesUtil = new pplq2();		
		List<String> alb = FilesUtil.readTextFileByLines("b_inf.txt"); 
		
                
                Object arrb[] = alb.toArray(); 
		for (int i=0; i<arrb.length; i++) 
                {
			String str = arrb[i].toString(); 
			if (str.length() == 0) continue;
			String strarr[] = str.split(",");b[k++] = new boy(strarr);
		}
		List<String> alg = FilesUtil.readTextFileByLines("g_inf.txt");
		
                Object arrg[] = alg.toArray();
		
                
                for (int i=0; i<arrg.length; i++) 
                {
			String str = arrg[i].toString();
			if (str.length() == 0) continue;
			String strarr[] = str.split(",");g[z++] = new girl(strarr);
		}
		FilesUtil.connect(b, g);FilesUtil.give_gift(b, g, happinessarray);
		
                
                for (int i=0; i<ng-1; i++)
                {
			for (int j=0; j<ng-1-i; j++)
                        {
				if (happinessarray[j].happiness < happinessarray[j+1].happiness)
                                {
					String tempbf = happinessarray[j].boyfriend;String tempgf = happinessarray[j].girlfriend;
					double temphap = happinessarray[j].happiness;
					happinessarray[j].boyfriend = happinessarray[j+1].boyfriend;happinessarray[j].girlfriend = happinessarray[j+1].girlfriend;
					happinessarray[j].happiness = happinessarray[j+1].happiness;happinessarray[j+1].boyfriend = tempbf;
					happinessarray[j+1].girlfriend = tempgf;happinessarray[j+1].happiness = temphap;
				}}}
                
                DataOutputStream ds_cont = new DataOutputStream(new FileOutputStream("logfile2.txt"));
		
                ds_cont.writeBytes("Happiest "+h_couple+" couples are\n");
		for (int i=0; i<h_couple; i++)
                {
			ds_cont.writeBytes(happinessarray[i].boyfriend+" and "+happinessarray[i].girlfriend+"\n");
		}}
}