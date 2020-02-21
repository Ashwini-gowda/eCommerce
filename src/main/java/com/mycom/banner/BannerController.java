package com.mycom.banner;

import act.controller.Controller;
import act.controller.annotation.UrlContext;
import act.db.morphia.MorphiaAdaptiveRecord;
import act.db.morphia.MorphiaDao;
import act.db.morphia.MorphiaModel;
import act.db.DbBind;
import org.mongodb.morphia.annotations.Entity;
import org.osgl.mvc.annotation.*;
import org.osgl.mvc.annotation.PutAction;
import java.util.*;
import javax.inject.Inject;
import static act.controller.Controller.Util.notFoundIfNull;



@UrlContext("/banners")
public class BannerController extends MorphiaDao<Banner> {

  @Inject
  private MorphiaDao<Banner> dao = Banner.dao();

    @PostAction("/banners")
    public Banner create(Banner banner) {
      return dao.save(banner);
    }

    @GetAction("/banners")
    public Iterable<Banner> list() {
      return dao.findAll();
    }

    @GetAction("/banners/{id}")
    public Banner show(@DbBind("id") Banner banner) {
      return banner;
    }

    @PutAction("/banners/{id}")
    public Banner update(String id, Map<String, Object> data) {
      Banner banner = findById(id);
      notFoundIfNull(banner);
      return dao.save(banner.mergeValues(data));
    }

    @DeleteAction("/banners/{id}")
    public void delete(String id) {
      dao.deleteById(id);
    }
}

