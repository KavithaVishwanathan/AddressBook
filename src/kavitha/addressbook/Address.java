package kavitha.addressbook;

/**
 * This Class Address is to create an object for address which can contain 
 * either Address line 1/ address line 2/city/State/Zip or different combinations.
 * @author Kavitha
 *
 */
public class Address {
  private final String addressLine1;
  private final String addressLine2;
  private final String city;
  private final String state;
  private final String zipCode;
  private final String country;
  
  public static class Builder {
    
    //Optional Parameters - initialized to default values
    private String addressLine1 = "";
    private String addressLine2 = "";
    private String city = "";
    private String state = "";
    private String zipCode = "";
    private String country = "";
    
    /**
     * This method to set the optional parameter "Address Line 1"
     */
    public Builder addressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
      return this;
    }
    
    /**
     * This method to set the optional parameter "Address Line 2"
     */
    public Builder addressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
      return this;
    }
    
    /**
     * This method to set the optional parameter "city"
     */
    public Builder city(String city) {
      this.city = city;
      return this;
    }

    /**
     * This method to set the optional parameter "state"
     */
    public Builder state(String state) { 
      this.state = state;
      return this;
    }
    
    /**
     * This method to set the optional parameter "ZipCode"
     */
    public Builder zipCode(String zipCode) { 
      this.zipCode = zipCode;
      return this;
    }
    
    /**
     * This method to set the optional parameter "country"
     */
    public Builder country(String country) { 
      this.country = country;
      return this;
    }
    
    /**
     * this method initiates the constructor of outer class
     */
     public Address build(){
       return new Address(this);
     }
     
  }
  
  private Address(Builder builder){
    addressLine1 = builder.addressLine1;
    addressLine2 = builder.addressLine2;
    city = builder.city;
    state = builder.state;
    country = builder.country;
    zipCode = builder.zipCode;
  }
  
  boolean search(String searchContent){
    searchContent = searchContent.toLowerCase();
    return addressLine1.toLowerCase().contains(searchContent) || addressLine2.toLowerCase().
        contains(searchContent) || city.toLowerCase().contains(searchContent) || 
        city.toLowerCase().contains(searchContent) || state.toLowerCase().contains(searchContent) 
        || country.toLowerCase().contains(searchContent) || 
        zipCode.toLowerCase().contains(searchContent);
  }
  
  @Override
  public String toString() {
    return addressLine1 + "," + addressLine2 + "," + city + "," + state + "," + zipCode + "," + 
        country;
  }

  /**
   * @return the addressLine1
   */
  public String getAddressLine1() {
    return addressLine1;
  }

  /**
   * @return the addressLine2
   */
  public String getAddressLine2() {
    return addressLine2;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @return the zipCode
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }
  
  /**
   * @return combined string of phone numbers appended with quotes and separated by commas
   */
  String getAddress(){
    return "\"" + addressLine1 + "\",\"" + addressLine2 + "\",\"" + city + "\",\"" + state + "\",\""
            + zipCode + "\",\"" + country + "\",";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
    result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
    Address other = (Address) obj;
    if (addressLine1 == null) {
      if (other.addressLine1 != null)
        return false;
    } else if (!addressLine1.equals(other.addressLine1))
      return false;
    if (addressLine2 == null) {
      if (other.addressLine2 != null)
        return false;
    } else if (!addressLine2.equals(other.addressLine2))
      return false;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    if (zipCode == null) {
      if (other.zipCode != null)
        return false;
    } else if (!zipCode.equals(other.zipCode))
      return false;
    return true;
  }
  
}
