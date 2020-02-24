package com.ecommerce.models;

import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import org.mongodb.morphia.annotations.Entity;
import java.util.Map;
import org.osgl.mvc.annotation.*;
import javax.persistence.*;

@Entity("banner")
public class Banner extends MorphiaAdaptiveRecord<Banner> {
  @Id
  public Integer id;
  public String name;
  public String deep_link;
  public Boolean active;

  public static class Dao extends MorphiaDao<Banner> {
    }
}
