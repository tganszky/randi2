package de.randi2.install.tab;

import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.component.paneltabset.TabChangeListener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import java.io.Serializable;

/**
 * 
 * @author Thomas Ganszky
 * 
 */
public class StaticTabSetBean implements TabChangeListener, Serializable,
		ValueChangeListener {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * First name of Admin
	 */
	private String firstname;
	/**
	 * Last name of Admin
	 */
	private String lastname;

	private String email;
	private String phone;
	private String mobile;
	private String fax;
	private String title;
	private String[] titleItems = { "", "Dr.", "Prof.", "Prof. Dr." };
	private String[] sexArr = { "", "male", "female" };
	private String sex;

	// selected tab index
	private String nextIndex = "0";

	private String selectedIndex = "0";

	/**
	 * Tabbed placement, possible values are "top" and "bottom", the default is
	 * "bottom".
	 */
	private String tabPlacement = "top";
	/**
	 * Maximum number of Tabs allowed
	 */
	private int maxTabs = 4;

	/**
	 * 
	 */
	public String getTabPlacement() {
		return tabPlacement;
	}

	/**
	 * 
	 * @param tabPlacement
	 */
	public void setTabPlacement(String tabPlacement) {
		this.tabPlacement = tabPlacement;
	}

	/**
	 * 
	 * @return
	 */
	public String getSelectedIndex() {
		return selectedIndex;
	}

	/**
	 * 
	 * @param selectedIndex
	 */
	public void setSelectedIndex(String selectedIndex) {
		this.selectedIndex = selectedIndex;
		this.nextIndex = Integer
				.toString((Integer.parseInt(selectedIndex)) + 1);
		if (nextIndex == null) {
			System.out.println("wurde null bei set sel index(string)");
		}
	}

	/**
	 * 
	 * @param selectedIndex
	 */
	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = String.valueOf(selectedIndex);
		this.nextIndex = Integer.toString(selectedIndex + 1);
		if (nextIndex == null) {
			System.out.println("wurde null bei set sel index(int)");
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getNext() {
		return Integer.toString(getFocusIndex() + 1);
	}

	/**
	 * 
	 * @return
	 */
	public int getFocusIndex() {
		int focusIndex = 0;
		try {
			focusIndex = Integer.parseInt(selectedIndex);
		} catch (NumberFormatException nfe) {
			// do nothing
		}
		return focusIndex;
	}

	/**
	 * 
	 * @param index
	 */
	public void setFocusIndex(int index) {
		selectedIndex = String.valueOf(index);
	}

	public void setFocusIndex() {
		selectedIndex = getNext();
	}

	/**
	 * Called when the table binding's tab focus changes.
	 * 
	 * @param tabChangeEvent
	 *            used to set the tab focus.
	 * @throws AbortProcessingException
	 *             An exception that may be thrown by event listeners to
	 *             terminate the processing of the current event.
	 */
	public void processTabChange(TabChangeEvent tabChangeEvent)
			throws AbortProcessingException {
		// only used to show TabChangeListener usage.
		System.out.println("only used to show TabChangeListener usage.");
		System.out.println("Selected is " + selectedIndex);
	}

	/**
	 * 
	 * @param e
	 */
	public void switchGroup(ActionEvent e) {
		if (nextIndex == null || Integer.parseInt(nextIndex) < 0
				|| Integer.parseInt(nextIndex) > maxTabs - 1) {
			this.selectedIndex = "0";
		} else {
			if (Integer.parseInt(this.selectedIndex) < maxTabs - 1) {
				System.out.println("in switch grp " + selectedIndex);
				this.selectedIndex = getNext();
			}
		}

	}

	/**
	 * 
	 * @param nextIndex
	 */
	public void setNextIndex(String nextIndex) {
		this.nextIndex = nextIndex;
	}

	/**
	 * 
	 * @return
	 */
	public String getNextIndex() {
		return nextIndex;
	}

	/**
	 * 
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * 
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * 
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setTitleItems(String[] titleItems) {
		this.titleItems = titleItems;
	}

	public String[] getTitleItems() {
		return titleItems;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void processValueChange(ValueChangeEvent arg0)
			throws AbortProcessingException {

	}

	public void valueChangeListener(ValueChangeEvent arg0)
			throws AbortProcessingException {

	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setSexArr(String[] sexArr) {
		this.sexArr = sexArr;
	}

	public String[] getSexArr() {
		return sexArr;
	}

}