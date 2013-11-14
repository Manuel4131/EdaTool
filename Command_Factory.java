
public class Command_Factory {
	
	public static Command Create_Concrete_Cmd(String cmd)
	{
		if(cmd.equals("create") )
		{
			return new Create();
		}
		else if(cmd.equals("add") )
		{
			return new Add();
		}
		else if(cmd.equals("delete") )
		{
			return new Delete();
		}
		else if(cmd.equals("list") )
		{
			return new List();
		}
		else if(cmd.equals("evaluate") )
		{
			return new Evaluate();
		}
		else if(cmd.equals("quit") )
		{
			return new Quit();
		}
		else if(cmd.equals("switch"))
		{
			return new Switch();
		}
		else						//Report error. Since the user input a nonexistent command.  
		{
			System.out.println("The user inputs a nonexistent command.");
			return null; 
		}
		
		
	}

}
