package ch.gmtech.ste.learning.html;

public class Div {
	
	private String _id;
	private String _label;
	private TypeEnum _type;
	
	public enum TypeEnum {
		text, number, date
	}
	
	Div(String id, String label, TypeEnum type) {
		_id = id;
		_label = label;
		_type = type;
	}
	
	public String create(){
		return "		<div class='form-group'>                                                                                                      "
				+ "					<label for='" + _id + "' class='col-sm-2 control-label'>"+ _label+ "</label>                                                  "
				+ "					<div class='col-sm-10'>                                                                                                   "
				+ "						<input type='" + _type + "' class='form-control' id='"+ _id +"' name='" + _id + "' placeholder='insert a "+ _id + "' value='" + _id + "'>  "
				+ "					</div>                                                                                                                    "
				+ "				</div>  ";
	}

}
