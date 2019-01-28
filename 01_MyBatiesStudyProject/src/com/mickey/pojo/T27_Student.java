package com.mickey.pojo;

public class T27_Student {
	private int id;
	private String name;
	private int age;
	private int tid;
	private T27_Teacher teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public T27_Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(T27_Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		result = prime * result + tid;
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
		T27_Student other = (T27_Student) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		if (tid != other.tid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "T27_Student [id=" + id + ", name=" + name + ", age=" + age + ", tid=" + tid + ", teacher=" + teacher
				+ "]";
	}

	public T27_Student(int id, String name, int age, int tid, T27_Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.tid = tid;
		this.teacher = teacher;
	}

	public T27_Student() {
		super();
	}

}
