
public class NOT_gate extends Gate{

	public NOT_gate(String gate_name,String gate_type){
		Gate_name= gate_name;
		type= gate_type;
		input_port2.is_input_port=true;
		input_port2.value=false;
		
    }
	
	
	@Override
	public boolean evaluate() {
		return Different_Evaluation.Evaluate(input_port1.Get_value(),input_port2.Get_value(),type);
	}

}
