package com.ecommerce;

import act.Act;
import act.inject.DefaultValue;
import act.util.Output;
import org.osgl.logging.LogManager;
import org.osgl.logging.Logger;
import org.osgl.mvc.annotation.GetAction;
import osgl.version.Version;
import osgl.version.Versioned;
import act.inject.util.LoadResource;
import act.job.OnAppStart;

@SuppressWarnings("unused")
@Versioned
public class AppEntry {

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
