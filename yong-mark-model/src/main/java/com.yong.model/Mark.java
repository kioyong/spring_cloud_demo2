package com.yong.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import javax.validation.constraints.NotNull;

/**
 * @acthor yong.a.liang
 * @date 2017/11/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Mark extends BaseEntity implements Comparable<Mark>{
    @Id private String id;
//    @NotNull
//    TODO
    private String title,type;
    private boolean isActivity,isLocked;
    private List<Item> item;

    public static Mark updateMark(Mark oldRecord, Mark newRecord){
        oldRecord.setActivity(newRecord.isActivity());
        oldRecord.setItem(newRecord.getItem());
        oldRecord.setLocked(newRecord.isLocked());
        oldRecord.setTitle(newRecord.getTitle());
        oldRecord.setType(newRecord.getType());
        return oldRecord;
    }

    @Override
    public int compareTo(Mark o) {
        return this.getCreatedDate().compareTo(o.getCreatedDate());
    }
}
