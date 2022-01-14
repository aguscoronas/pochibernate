package ar.com.dcc.pochibernate;

public class Permission {
	private int permissionId;
	private Group groupId;
	private Operation operationId;
	
	public Permission() {}	
	
	public Permission(Group groupId, Operation operationId) {
		this.groupId = groupId;
		this.operationId = operationId;
	}


	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public Group getGroupId() {
		return groupId;
	}
	public void setGroupId(Group groupId) {
		this.groupId = groupId;
	}
	public Operation getOperationId() {
		return operationId;
	}
	public void setOperationId(Operation operationId) {
		this.operationId = operationId;
	}
}
