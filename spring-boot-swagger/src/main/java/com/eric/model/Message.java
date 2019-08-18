package com.eric.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
/**
 * @author eric
 */
@Data
public class Message {
    private Long id;
    @ApiModelProperty(value = "消息体")
    private String text;
    @ApiModelProperty(value = "消息总结")
    private String summary;
    private Date createDate;
}
