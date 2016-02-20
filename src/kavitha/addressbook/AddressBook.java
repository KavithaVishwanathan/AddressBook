package kavitha.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * This class AddressBook performs operations on the whole addressbook such as create, add entries,
 * remove, save it as csv file and retrieve as the same etc
 * @author Kavitha
 * version: 1.0
 */
public class AddressBook {
  private List<Entry> listOfEntries;
  
  /**
  * The Constructor to create a arraylist for AddressBookEntries Object
  */
  public AddressBook() {
    listOfEntries = new ArrayList<Entry>();
  }
	
  /**
   * Adds the entry into to the addressbook
   * @param object entryItem
   */
	public void addEntry(Entry entryItem) {
		listOfEntries.add(entryItem);
	}
	
	/**
	 * removes the specified entry from the addressbook
	 * @param object entry
	 */
	public void removeEntry(Entry entry) {
	  listOfEntries.remove(entry);    
  }
  
	public List<Entry> searchEntry(String searchContent) {
	  List<Entry> foundEntries = new ArrayList<Entry>();
	  for(Entry entry : listOfEntries) {
	    if (entry.search(searchContent)) {
	      foundEntries.add(entry);
	    }
	  }
	  return foundEntries;
	}

	
	/**
	 * @param addressBookNameWithPath path you want to save the csv file, along with the file name 
	 * and csv extension (eg., c:/myaddressbook.csv)
	 * @version 1.0
	 */
	public void saveAsCSV(String addressBookNameWithPath) {
	  String new_line_seperator = "\n";
	  
	  String file_header = "FirsName, MiddleName, LastName, HomePhone, WorkPhone, AdditionalPhone,"
	          + "AddressLine1,AddressLine2,City,State,ZipCode,Country,EmailAddress1,EmailAddress2,"
	          + "EmailAddress3,Note";
	  
	  BufferedWriter addressFile =null;
    try {
      FileWriter fw = new FileWriter(addressBookNameWithPath);
      addressFile = new BufferedWriter(fw);
  
      addressFile.append(file_header);
      addressFile.append(new_line_seperator);
      
      for (Entry entry : listOfEntries) {
        addressFile.append(entry.toString());
        addressFile.append(new_line_seperator);
      }    
      addressFile.flush();
      addressFile.close();
    } catch (IOException ie) {
      ie.printStackTrace();
    }
 }
	
	/**
   * Reads the previously saved file and add the contents back to address
   * @throws error if any of the column is deleted from the file
   * @param addressBookNameWithPath give the path of the saved csv file, along with the file name 
   * and csv extension (eg., c:/myaddressbook.csv)
   * @version 1.0
   */
	 public void readCSV(String addressBookNameWithPath) {
	  String comma_delimiter = ",";
	  String[] file_header = {"firsName","middleName","lastName","homePhone","workPhone",
	      "additionalPhone","homeEmail","workEmail","additionalEmail","addressLine1","addressLine2",
	      "city","state","zipCode","country","note"};
   
	  BufferedReader fileReader = null;
	  try {
	    fileReader = new BufferedReader(new FileReader(addressBookNameWithPath));
	    String line="";
	    fileReader.readLine();

	    while ((line = fileReader.readLine()) != null) {  
        String[] tokens = line.split(comma_delimiter,-1);
        Map<String, String> mapFile = new HashMap<>();
        
        for (int i=0; i < Math.min(file_header.length, tokens.length); i++) {
          mapFile.put(file_header[i], tokens[i]);
        }
        
        fileToAddressBook(mapFile, file_header);
      } 
      fileReader.close();
    } catch (IOException ie) {
      ie.printStackTrace();
    }
	 }
	 
	 private void fileToAddressBook(Map<String,String> mapFile, String[] file_header) {
	   String firstName = mapFile.get(file_header[0]);
     String middleName = mapFile.get(file_header[1]);
     String lastName = mapFile.get(file_header[2]);
     Name name = new Name.Builder(firstName).middleName(middleName).lastName(lastName).build();
     
     String homePhone = mapFile.get(file_header[3]);
     String workPhone = mapFile.get(file_header[4]);
     String additionalPhone = mapFile.get(file_header[5]);
     PhoneNumber phoneNumber = new PhoneNumber.Builder().homePhone(homePhone).workPhone(workPhone)
         .additionalPhone(additionalPhone).build();
    
     String homeEmail = mapFile.get(file_header[6]);
     String workEmail = mapFile.get(file_header[7]);
     String additionalEmail = mapFile.get(file_header[8]);
     EmailAddress emailAddress = new EmailAddress.Builder().homeEmail(homeEmail).
         workEmail(workEmail).additionalEmail(additionalEmail).build();
     
     String addressLine1 = mapFile.get(file_header[9]);
     String addressLine2 = mapFile.get(file_header[10]);
     String city = mapFile.get(file_header[11]);
     String state = mapFile.get(file_header[12]);
     String country = mapFile.get(file_header[13]);
     String zipCode = mapFile.get(file_header[14]);
     Address address = new Address.Builder().addressLine1(addressLine1).addressLine2(addressLine2)
         .city(city).state(state).zipCode(zipCode).country(country).build();
     
     String note = mapFile.get(file_header[15]);
       
     Entry entry = new Entry.Builder(name).phoneNumber(phoneNumber).address(address).
         emailAddress(emailAddress).note(note).build();
     this.addEntry(entry);
	 }
}
