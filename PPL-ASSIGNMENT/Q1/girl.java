public class girl
{
	String name;
        String crit; 
	boolean committed;
	String boyfriend;
	int attractiveness;
	double maintainencebudget;
	int intelligencelevel;
	girl(String str[])
        {	
		name = str[0];crit = str[4];
		committed = false;boyfriend = "";
                attractiveness = Integer.parseInt(str[1]);
		maintainencebudget = Double.parseDouble(str[2]);
		intelligencelevel = Integer.parseInt(str[3]);
	}
	public void display()
        {
		System.out.println(name+"\n"+attractiveness+"\n"+maintainencebudget+"\n"+intelligencelevel+"\n"+crit+"\n"+committed+"\n"+boyfriend+"\n");
	}
}