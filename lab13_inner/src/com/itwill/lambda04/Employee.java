package com.itwill.lambda04;

public class Employee {
	
    private int id; // 사번
    private String name; // 이름
    private String dept; // 부서(department) 이름
    private String jobTitle; // 직급(사원, 대리, 과장, ...)
    private double salary; // 급여
    
    
    // 생성자
    public Employee(int id, String name, String dept, String jobTitle, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
    
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id= " + id + ", name= " + name + ", dept= " + dept + ", jobTitle=" + jobTitle + ", salary="
				+ salary + "]";
	}
	
    
    // TODO: getters & setters, toString
    
}