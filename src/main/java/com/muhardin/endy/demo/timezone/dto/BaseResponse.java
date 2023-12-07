package com.muhardin.endy.demo.timezone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : demo-timezone2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/7/23
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> implements Serializable {
    private Date timestamp;
    private Integer statusCode;
    private String error;
    private Object message;
    private int ttlRecords;
    private int ttlPages;
    private int pageNo;
    private int pageRecords;
    private T data;
}
