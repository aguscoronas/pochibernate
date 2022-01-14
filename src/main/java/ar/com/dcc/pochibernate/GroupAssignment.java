package ar.com.dcc.pochibernate;

public class GroupAssignment {
	private int groupAssignmentId;
	private Group groupId;
	private User userId;
	

	public GroupAssignment() {}
	public GroupAssignment(Group groupId, User userId) {
		this.groupId = groupId;
		this.userId = userId;
	}
	
	public int getGroupAssignmentId() {
		return groupAssignmentId;
	}
	public void setGroupAssignmentId(int groupAssignmentId) {
		this.groupAssignmentId = groupAssignmentId;
	}
	public Group getGroupId() {
		return groupId;
	}
	public void setGroupId(Group groupId) {
		this.groupId = groupId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userid) {
		this.userId = userid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + groupAssignmentId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupAssignment other = (GroupAssignment) obj;
		if (groupAssignmentId != other.groupAssignmentId)
			return false;
		return true;
	}
}
