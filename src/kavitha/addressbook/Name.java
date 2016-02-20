package kavitha.addressbook;

/**
 * This Class PhoneNumber is to create an object name which can contain either 
 * first name or middle name or last name or combination of two or all three.
 * @author Kavitha
 */
public class Name {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  
  public static class Builder {
    //Required Parameter
    private String firstName;
    
    //Optional Parameters - initialized to default values
    private String middleName = "";
    private String lastName = "";
    
    /**
     * This method to set the required parameter "first Name"
     */
    public Builder(String firstName){
      this.firstName = firstName;
    }
    
    /**
     * This method to set the optional parameter "middle Name"
     */
    public Builder middleName(String middleName){
      this.middleName = middleName;
      return this;
    }
    
    /**
     * This method to set the optional parameter "last Name"
     */
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }
    
    /**
     * this method initiates the constructor of outer class
     */
    public Name build(){
      return new Name(this);
    }
     
  }
  
  private Name(Builder builder){
    firstName = builder.firstName;
    middleName = builder.middleName;
    lastName = builder.lastName;
  }
  
  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the middleName
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }
 
  boolean search(String searchContent){
    searchContent = searchContent.toLowerCase();
    return firstName.toLowerCase().contains(searchContent) || middleName.toLowerCase().
            contains(searchContent) || lastName.toLowerCase().contains(searchContent);
  }
  
  @Override
  public String toString() {
    return firstName + "," + middleName + "," + lastName;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
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
    Builder other = (Builder) obj;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (middleName == null) {
      if (other.middleName != null)
        return false;
    } else if (!middleName.equals(other.middleName))
      return false;
    return true;
  }
}
