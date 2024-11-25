package com.itwill.project.model;

import java.time.LocalDateTime;

public class Animal {

	public static final class Eentity {

		public static final String TBL_ANIMAL = "ANIMAL";
		public static final String COL_ID = "ID";
		public static final String COL_NAME = "ANIMAL_NAME";
		public static final String COL_TYPE = "ANIMAL_TYPE";
		public static final String COL_AGE = "AGE";
		public static final String COL_GENDER = "GENDER";
		public static final String COL_WEIGHT = "WEIGHT";
		public static final String COL_MEMO = "MEMO";
		public static final String COL_CREATED_TIME = "CREATED_TIME";
		public static final String COL_MODIFIED_TIME = "MODIFIED_TIME";
		public static final String COL_OWNER_ID = "OWNER_ID";
		public static final String COL_DOCTOR_ID = "DOCTOR_ID";
		
		
	}
	
	private Integer id;
	private String animalName;
	private String animalType;
	private Integer age;
	private String gender;
	private Double weight;
	private String memo;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	private Integer ownerId;
	private Integer doctorId;
	
	public Animal()	{}

	public Animal(Integer id, String animalName, String animalType, Integer age, String gender, Double weight,
			String memo, LocalDateTime createdTime, LocalDateTime modifiedTime, Integer ownerId, Integer doctorId) {
		super();
		this.id = id;
		this.animalName = animalName;
		this.animalType = animalType;
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.memo = memo;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.ownerId = ownerId;
		this.doctorId = doctorId;
	}
	
	public Integer getId() {
		return id;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", animalName=" + animalName + ", animalType=" + animalType + ", age=" + age
				+ ", gender=" + gender + ", weight=" + weight + ", memo=" + memo + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", ownerId=" + ownerId + ", doctorId=" + doctorId + "]";
	}
	
	public static AnimalBuilder builder() {
		return new  AnimalBuilder();
	}
	
	public static class AnimalBuilder {
		
		private Integer id;
		private String animalName;
		private String animalType;
		private Integer age;
		private String gender;
		private Double weight;
		private String memo;
		private LocalDateTime createdTime;
		private LocalDateTime modifiedTime;
		private Integer ownerId;
		private Integer doctorId;
		
		public AnimalBuilder() {}

		public AnimalBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public AnimalBuilder animalName(String animalName) {
			this.animalName = animalName;
			return this;
		}

		public AnimalBuilder animalType(String animalType) {
			this.animalType = animalType;
			return this;
		}


		public AnimalBuilder age(Integer age) {
			this.age = age;
			return this;
		}


		public AnimalBuilder gender(String gender) {
			this.gender = gender;
			return this;
		}


		public AnimalBuilder weight(Double weight) {
			this.weight = weight;
			return this;
		}


		public AnimalBuilder memo(String memo) {
			this.memo = memo;
			return this;
		}


		public AnimalBuilder createdTime(LocalDateTime createdTime) {
			this.createdTime = createdTime;
			return this;
		}

		public AnimalBuilder modifiedTime(LocalDateTime modifiedTime) {
			this.modifiedTime = modifiedTime;
			return this;
		}

		public AnimalBuilder ownerId(Integer ownerId) {
			this.ownerId = ownerId;
			return this;
		}

		public AnimalBuilder doctorId(Integer doctorId) {
			this.doctorId = doctorId;
			return this;
		}
		
		public Animal build() {
			return new Animal(id, animalName, animalType, age, gender, weight, memo, createdTime, modifiedTime, ownerId, doctorId);
		}
	}
	
}
