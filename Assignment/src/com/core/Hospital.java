package com.core;

public class Hospital {
	private String hospitalName;
	private String address;
	private Disease disease;

	public Hospital(String hospitalName, String address, Disease disease) {
		super();
		this.hospitalName = hospitalName;
		this.address = address;
		this.disease = disease;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getAddress() {
		return address;
	}

	public Disease getDisease() {
		return disease;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Hospital) {
			return this.getHospitalName().equals(((Hospital) o).getHospitalName());
		} else
			return false;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", address=" + address + ", disease=" + disease + "]";
	}

}
