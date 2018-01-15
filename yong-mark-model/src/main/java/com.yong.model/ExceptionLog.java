package com.yong.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * @acthor yong.a.liang
 * @date 2018/01/11
 */
@Data
@Document(collection = "exception_log")
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionLog extends BaseEntity{
    @Id
    private String id;
    private String message;
    private List<Map<String, String>> detail;
    private Map<String, String> firstDetail;
    private int count;

}
