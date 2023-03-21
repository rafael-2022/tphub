package com.dieboldnixdorf.frentecaixa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Employee.
 */
@Entity
@Table
public class Employee {
	
	/** The empnmbr. */
	@Id
	@Column(name="empnmbr", columnDefinition="int8")
	private Long empnmbr;

	/** The empname. */
	@Basic
	@Column(name="empname", length=21)
	private String empname;

	/** The empprofile. */
	@Basic
	@Column(name="empprofile", columnDefinition="int2")
	private Short empprofile;

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {
	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param empnmbr the empnmbr
	 */
	public Employee(final Long empnmbr) {
		this.empnmbr = empnmbr;
	}

	/**
	 * Gets the empnmbr.
	 *
	 * @return the empnmbr
	 */
	public Long getEmpnmbr() {
		return empnmbr;
	}

	/**
	 * Sets the empnmbr.
	 *
	 * @param empnmbr the new empnmbr
	 */
	public void setEmpnmbr(final Long empnmbr) {
		this.empnmbr = empnmbr;
	}

	/**
	 * Gets the empname.
	 *
	 * @return the empname
	 */
	public String getEmpname() {
		return empname;
	}

	/**
	 * Sets the empname.
	 *
	 * @param empname the new empname
	 */
	public void setEmpname(final String empname) {
		this.empname = empname;
	}

	/**
	 * Gets the empprofile.
	 *
	 * @return the empprofile
	 */
	public Short getEmpprofile() {
		return empprofile;
	}

	/**
	 * Sets the empprofile.
	 *
	 * @param empprofile the new empprofile
	 */
	public void setEmpprofile(final Short empprofile) {
		this.empprofile = empprofile;
	}

}