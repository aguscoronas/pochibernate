package ar.com.dcc.pochibernate;

import java.util.Set;

public class Group {
	private int groupId;
	private String name;
	private String description;
	private Set<GroupAssignment> groupAssignments;
	private Set<Permission> permissions;
	
	public Group(){}
	public Group(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
	public Set<GroupAssignment> getGroupAssignments() {
		return groupAssignments;
	}
	public void setGroupAssignments(Set<GroupAssignment> groupAssignments) {
		this.groupAssignments = groupAssignments;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
