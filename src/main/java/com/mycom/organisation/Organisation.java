package com.mycom.organisation;
import com.mycom.product.Product;
import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import org.mongodb.morphia.annotations.Entity;
import java.util.Map;

@Entity("organisation")
public class Organisation extends MorphiaAdaptiveRecord<Organisation> {

  public String full_name;
  public String abbreviation;
  public String official_email;
  public String official_contact;
  public String address;

  public String getFull_name() {
    return full_name;
  }
 
  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public String getOfficial_email() {
    return official_email;
  }

  public void setOfficial_email(String official_email) {
    this.official_email = official_email;
  }

  public String getOfficial_contact() {
    return official_contact;
  }

  public void setOfficial_contact(String official_contact) {
    this.official_contact = official_contact;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public static class Dao extends MorphiaDao<Organisation> {
  }
}
