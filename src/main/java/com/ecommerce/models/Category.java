package com.ecommerce.models;

import com.ecommerce.models.Product;
import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import org.mongodb.morphia.annotations.Entity;
import java.util.Map;
import java.util.List;
import java.util.*;
import javax.persistence.*;

@Entity("category")
public class Category extends MorphiaAdaptiveRecord<Category> {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Integer id;
  public String name;
  public String code;
  public Boolean active;
  @Embedded
  private Product product;

  public static class Dao extends MorphiaDao<Category> {
  }
}
