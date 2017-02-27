public class boy 
{
        int attractiveness;double maintainencebudget;
	int intelligencelevel;String name;
        int m_a_req;boolean committed;
        String girlfriend;
	boy(String str[])
        {	
                name = str[0];committed = false;girlfriend = "";
		m_a_req = Integer.parseInt(str[4]);
                attractiveness = Integer.parseInt(str[1]);maintainencebudget = Integer.parseInt(str[2]);
		intelligencelevel = Integer.parseInt(str[3]);
	}
	public void display() 
        {
	   System.out.println(name+"\n"+attractiveness+"\n"+maintainencebudget+"\n"+intelligencelevel+"\n"+m_a_req+"\n"+committed+"\n"+girlfriend+"\n");
	}
}