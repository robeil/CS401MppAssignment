package CS401MppAssignment.Univerisity_src_Previous_orig.main.java;

import java.util.List;

public class Course {

	private String name;
	private String id;
	private String notes;
	private Long credit;

	private List<Grade> grades;

	public Long getCredit() {
		return credit;
	}

	public void setCredit(Long credit) {
		this.credit = credit;
	}

	public Course(String name , String id, String notes) {
		this.name = name;
		this.id = id;
		this.notes = notes;
    }

	public void setName(String name) {
    	this.name = name;
	}

	public String getName() {
    	return name;
	}

	public void setId(String id) {
    	this.id = id;
	}

	public String getId() {
    	return id;
	}

	public void setNotes(String notes) {
    	this.notes = notes;
	}

	public String getNotes() {
    	return notes;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
}
