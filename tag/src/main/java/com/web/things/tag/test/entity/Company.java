package com.web.things.tag.test.entity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 公司
 * 
 * @author songjz
 * @time 2013年7月31日
 */
public class Company {

	private Integer id;

	private String name;

	private Collection<Contact> contactList = new ArrayList<Contact>();

	public void addContact(Contact contact) {
		contactList.add(contact);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the contactList
	 */
	public Collection<Contact> getContactList() {
		return contactList;
	}

	/**
	 * @param contactList
	 *            the contactList to set
	 */
	public void setContactList(Collection<Contact> contactList) {
		this.contactList = contactList;
	}

}
