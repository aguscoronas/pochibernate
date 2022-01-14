package ar.com.dcc.pochibernate;


public class Operation {
	private int operationId;
	private String name;
	private String description;
	private Character type;
	
	public Operation() {};
	public Operation(String name, String description, Character type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}
	public int getOperationId() {
		return operationId;
	}
	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Character getType() {
		return type;
	}
	public void setType(Character type) {
		this.type = type;
	}

}
