package kavitha.addressbook;

/**
 * This Class is to create an object email which can contain either one or multiple email addresses
 * @author Kavitha
 */
public class EmailAddress {
  private final String homeEmail;
  

  private final String workEmail;
  private final String additionalEmail;
  
  public static class Builder {
    
    //Optional Parameters - initialized to default values
    private String homeEmail = "";
    private String workEmail = "";
    private String additionalEmail = "";
    
    /**
     * This method to set the optional parameter "email address"
     */
    public Builder homeEmail(String homeEmail) {
      this.homeEmail = homeEmail;
      return this;
    }
    
    /**
     * This method to set the optional parameter "another email address"
     */
    public Builder workEmail(String workEmail) {
      this.workEmail = workEmail;
      return this;
    }

    /**
     * This method to set the optional parameter "yet another email address"
     */
    public Builder additionalEmail(String additionalEmail) { 
      this.additionalEmail = additionalEmail;
      return this;
    }
    
    /**
     * this method initiates the constructor of outer class
     */
     public EmailAddress build(){
       return new EmailAddress(this);
     }
     
  }
  
  private EmailAddress(Builder builder){
    homeEmail = builder.homeEmail;
    workEmail = builder.workEmail;
    additionalEmail = builder.additionalEmail;
  }
  
  boolean search(String searchContent){
    searchContent = searchContent.toLowerCase();
    return homeEmail.toLowerCase().contains(searchContent) || workEmail.toLowerCase().
            contains(searchContent) || additionalEmail.toLowerCase().contains(searchContent);
  }
  
  @Override
  public String toString() {
    return homeEmail + "," + workEmail + "," + additionalEmail;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((homeEmail == null) ? 0 : homeEmail.hashCode());
    result = prime * result + ((workEmail == null) ? 0 : workEmail.hashCode());
    result = prime * result + ((additionalEmail == null) ? 0 : additionalEmail.hashCode());
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
    EmailAddress other = (EmailAddress) obj;
    if (homeEmail == null) {
      if (other.homeEmail != null)
        return false;
    } else if (!homeEmail.equals(other.homeEmail))
      return false;
    if (workEmail == null) {
      if (other.workEmail != null)
        return false;
    } else if (!workEmail.equals(other.workEmail))
      return false;
    if (additionalEmail == null) {
      if (other.additionalEmail != null)
        return false;
    } else if (!additionalEmail.equals(other.additionalEmail))
      return false;
    return true;
  }

  /**
   * @return the homeEmail
   */
  public String getHomeEmail() {
    return homeEmail;
  }

  /**
   * @return the workEmail
   */
  public String getWorkEmail() {
    return workEmail;
  }

  /**
   * @return the additionalEmail
   */
  public String getAdditionalEmail() {
    return additionalEmail;
  }
  
  /**
   * @return combined string of email address appended with quotes and seperated by commas
   */
  String getEmailAddress(){
    return "\"" + homeEmail + "\",\"" + workEmail + "\",\"" + additionalEmail + "\"," ;
  }
  
}
