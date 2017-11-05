package core.java.collections.model;

public class Student implements Comparable<Student> {

	private Integer id;
	private String name;

	public Student() {
	}

	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "(id=" + id + ", name=" + name + ")";
	}

}
