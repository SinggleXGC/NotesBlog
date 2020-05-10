package com.xgc.notesblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private Integer status;
    private String msg;
    private Object data;

}
