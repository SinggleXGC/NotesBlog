package com.xgc.notesblog.Entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "xgc")
@PropertySource(value = "application.properties")
@Data
public class GlobalProperties {

    private String baseurl;
}
