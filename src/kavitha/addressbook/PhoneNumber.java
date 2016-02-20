package kavitha.addressbook;

/**
 * This Class PhoneNumber is to create an object phone number which can contain either 
 * home phone or work phone or additional phone or combination of two or all three.
 * @author Kavitha
 */
public class PhoneNumber {
  private final String homePhone;
  private final String workPhone;
  private final String additionalPhone;
  
  /** 
   * This inner class is to set the required parameters for phone number
   */
  public static class Builder {
    
    //Optional Parameters - initialized to default values
    private String homePhone = "";
    private String workPhone = "";
    private String additionalPhone = "";
    
    /**
     * This method to set the optional parameter "home phone"
     */
    public Builder homePhone(String homePhone) {
      this.homePhone = homePhone;
      return this;
    }
    
    /**
     * This method to set the optional parameter "work phone"
     */
    public Builder workPhone(String workPhone) {
      this.workPhone = workPhone;
      return this;
    }

    /**
     * This method to set the optional parameter "additional phone"
     */
    public Builder additionalPhone(String additionalPhone) { 
      this.additionalPhone = additionalPhone;
      return this;
    }
    
    /**
     * this method initiates the constructor of outer class
     */
     public PhoneNumber build(){
       
       return new PhoneNumber(this);
     }
     
  }
  
  private PhoneNumber(Builder builder){
    homePhone = builder.homePhone;
    workPhone = builder.workPhone;
    additionalPhone = builder.additionalPhone;
  }
  
  boolean search(String searchContent){
    searchContent = searchContent.toLowerCase();
    return homePhone.toLowerCase().contains(searchContent) || workPhone.toLowerCase().
            contains(searchContent) || additionalPhone.toLowerCase().contains(searchContent);
  }

  /**
   * @return the homePhone
   */
  public String getHomePhone() {
    return homePhone;
  }

  /**
   * @return the workPhone
   */
  public String getWorkPhone() {
    return workPhone;
  }

  /**
   * @return the additionalPhone
   */
  public String getAdditionalPhone() {
    return additionalPhone;
  }
  
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return homePhone + "," + workPhone + "," + additionalPhone;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((additionalPhone == null) ? 0 : additionalPhone.hashCode());
    result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
    result = prime * result + ((workPhone == null) ? 0 : workPhone.hashCode());
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
    PhoneNumber other = (PhoneNumber) obj;
    if (additionalPhone == null) {
      if (other.additionalPhone != null)
        return false;
    } else if (!additionalPhone.equals(other.additionalPhone))
      return false;
    if (homePhone == null) {
      if (other.homePhone != null)
        return false;
    } else if (!homePhone.equals(other.homePhone))
      return false;
    if (workPhone == null) {
      if (other.workPhone != null)
        return false;
    } else if (!workPhone.equals(other.workPhone))
      return false;
    return true;
  }
  
}
