import java.util.ArrayList;
import java.util.List;

//Abstract class base class. 
public abstract class Command {
	
	public String Command_name; 
	public List<String> Input_cmd_string= new ArrayList<String>();						//The input command: add line E START not
	
	public String get_command_name(){
		return null;
	}
	
	public void Set_input_cmd_str(List<String> str){					//To set the user's input command line. like: add line E START not
		Input_cmd_string.clear();
		for(int i= 0;i< str.size();i++)
		{
			Input_cmd_string.add(str.get(i));
		}
		int check= 0;
			
	}
	public abstract void Response();
	public abstract void execute();					// to let the subclass to do the specific thing. 
	public void Error(){
		System.out.println("Input command error. Please follow the rule.");
		
	};
}
