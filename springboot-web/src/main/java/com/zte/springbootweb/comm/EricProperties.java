package com.zte.springbootweb.comm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@ConfigurationProperties(prefix = "eric")
@Data
public class EricProperties {
    private String title;
    private String description;
}
