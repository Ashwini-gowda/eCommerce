package com.ecommerce.models;

import com.ecommerce.models.Category;
import com.ecommerce.models.Organisation;

import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import org.mongodb.morphia.annotations.Entity;
import java.util.Map;
import java.util.List;
import java.util.*;
import javax.persistence.*;


@Entity("product")
public class Product extends MorphiaAdaptiveRecord<Product> {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Integer id;
  public String name;
  public String code;
  public String caption;
  public String gift_type;
  public Boolean active;
  public Organisation organisation_id;

  @Embedded 
  private List<Category> categories = new ArrayList<Category>();
  public List<Organisation> organisations = new ArrayList<Organisation>();

  public static class Dao extends MorphiaDao<Product> {
    }
}
