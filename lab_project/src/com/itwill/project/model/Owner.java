package com.itwill.project.model;

public class Owner {
	
	public static final class Eantity{
		
		public static final String TBL_OWNER = "OWNER";
		public static final String COL_ID = "ID";
		public static final String COL_NAME = "OWNER_NAME";
		public static final String COL_PHONE_NUMBER = "PHONE_NUMBER";
		public static final String COL_ADDRESS = "ADDRESS";
		public static final String COL_MEMO = "MEMO";	
	}
	
	private Integer id;
	private String ownerName;
	private String phoneNumber;
	private String address;
	private String memo;
	
	public Owner() {}

	public Owner(Integer id, String ownerName, String phoneNumber, String address, String memo) {
		this.id = id;
		this.ownerName = ownerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.memo = memo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", ownerName=" + ownerName + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", memo=" + memo + "]";
	}
	
	
	public static OwnerBuilder builder() {
		return new OwnerBuilder();
	}
	
	public static class OwnerBuilder {
		
		private Integer id;
		private String ownerName;
		private String phoneNumber;
		private String address;
		private String memo;
		
		public OwnerBuilder() {}
		
		public OwnerBuilder id(Integer id) {
			this.id = id;
			return this;
		}
		
		public OwnerBuilder ownerName(String ownerName) {
			this.ownerName = ownerName;
			return this;
		}
		
		public OwnerBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public OwnerBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public OwnerBuilder memo(String memo) {
			this.memo = memo;
			return this;
		}
		
		public Owner build() {
			return new Owner(id, ownerName, phoneNumber, address, memo);
		}
	}
}
