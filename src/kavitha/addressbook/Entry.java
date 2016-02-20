package kavitha.addressbook;

/**
 * This Class contains the method to create entries that will add in AddressBook Object
 * @author Kavitha
 */
public class Entry {
  private final Name name;
  private final PhoneNumber phoneNumber;
  private final Address address;
  private final EmailAddress emailAddress;
  private final String note;
  
  /** 
   * This inner class is to set the required parameters needed for an entry
   */
  public static class Builder {
    //Required Parameter
    private Name name;

    //Optional Parameters - initialized to default values
    private PhoneNumber phoneNumber;
    private Address address;
    private EmailAddress emailAddress;
    private String note = "";
    
    /**
     * This method to set the required parameter "Name"
     * @param object name
     */
    public Builder(Name name) {
      this.name = name;
    }
    
    /**
     * This method to set the optional parameter "phone Number"
     * @param object phone number
     */
    public Builder phoneNumber(PhoneNumber phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }
    
    /**
     * This method to set the required parameter "address"
     * @param object address
     */
    public Builder address(Address address) {
    	this.address = address;
    	return this;
    }
    
    /**
     * This method to set the required parameter "emailAddress"
     * @param object emailAddress
     */
    public Builder emailAddress(EmailAddress emailAddress) {
    	this.emailAddress = emailAddress;
    	return this;
    }
    
    /**
     * This method to set the required parameter "Name"
     * @param string note
     */
    public Builder note(String note) {
    	this.note = note;
    	return this;
    }
    
    /**
     * this method initiates the constructer of outer class
     */
    public Entry build(){
      if (phoneNumber == null) {
        phoneNumber = new PhoneNumber.Builder().build();
      }
      if (emailAddress == null) {
        emailAddress = new EmailAddress.Builder().build();
      }
      if (address == null){
        address = new Address.Builder().build();
      }
  	  return new Entry(this);
    }
  }
  
  private Entry(Builder builder) {
    name = builder.name;
  	phoneNumber = builder.phoneNumber;
  	emailAddress = builder.emailAddress;
  	address = builder.address;
    note = builder.note;
  }
  
  boolean search(String searchContent) {
    return name.search(searchContent) || phoneNumber.search(searchContent) || 
            emailAddress.search(searchContent) || address.search(searchContent) || 
            note.contains(searchContent);
  }
  
  /**
   * @return the name
   */
  public Name getName() {
    return name;
  }

  /**
   * @return the phoneNumber
   */
  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @return the address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * @return the emailAddress
   */
  public EmailAddress getEmailAddress() {
    return emailAddress;
  }

  /**
   * @return the note
   */
  public String getNote() {
    return note;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
    Entry other = (Entry) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address)) {
      return false;
    }
    
    if (emailAddress == null) {
      if (other.emailAddress != null)
        return false;
    } else if (!emailAddress.equals(other.emailAddress))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (note == null) {
      if (other.note != null)
        return false;
    } else if (!note.equals(other.note))
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    } else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    return true;
  }

  
  @Override
  public String toString() {
    return name + "," + phoneNumber + "," + address + "," + emailAddress + "," + note + "";
  }
	
}
