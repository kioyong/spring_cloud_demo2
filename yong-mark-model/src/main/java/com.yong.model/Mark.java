package com.yong.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

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
public class Mark {
    @Id private String id;
//    @NotNull
//    TODO
    private String title,type;
    private boolean isActivity,isLocked;
    private List<Item> item;
        private Date createdDate,lastModifiedDate;
    private String createdBy,lastModifiedBy;

    public static Mark updateMark(Mark oldRecord, Mark newRecord){
        oldRecord.setActivity(newRecord.isActivity());
        oldRecord.setItem(newRecord.getItem());
        oldRecord.setLocked(newRecord.isLocked());
        oldRecord.setTitle(newRecord.getTitle());
        oldRecord.setType(newRecord.getType());
        return oldRecord;
    }

    @Override
    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        return "id = " + id + ", type = "+ type + ", createdDate = " + simpleDateFormat.format(createdDate);
    }

}
