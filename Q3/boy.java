public class boy
{
        int intelligencelevel;
	int m_a_req;boolean committed;
	String type;double happiness;
	String name;String girlfriend;
	int attractiveness;double maintainencebudget;
	boy(String str[])
        {	
		name = str[0];
		attractiveness = Integer.parseInt(str[1]);
		maintainencebudget = Integer.parseInt(str[2]);
		intelligencelevel = Integer.parseInt(str[3]);
		m_a_req = Integer.parseInt(str[4]);
		committed = false;
		girlfriend = "";
		type = str[5];
	}
	public void display()
        {
	  System.out.println(name+"\n"+attractiveness+"\n"+maintainencebudget+"\n"+intelligencelevel+"\n"+m_a_req+"\n"+committed+"\n"+girlfriend+"\n");
	}
}

