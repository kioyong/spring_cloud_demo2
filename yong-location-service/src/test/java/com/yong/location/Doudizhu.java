package com.yong.location;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Doudizhu {

//    public List<Integer> d;
//    public List<Integer> n;

    public final String d = "dizhu";
    public final String n = "nongmin";
    public int logCount = 1;
//    @Test
//    public void demo1(){
//        d = Arrays.asList(4,5);
//        n = Arrays.asList(3,5);
//    }

    public List<Integer> OutOne(List<Integer> d,int i){
        Integer out = d.stream().filter(t -> t>i).sorted().findFirst().get();
        List<Integer> result = d.stream().filter(t -> t != out).collect(Collectors.toList());
        return result;
    }

    @Test
    public void demo2(){
        List<Integer> ownValues = new ArrayList<>();
        ownValues.add(6);
        ownValues.add(7);
        Map<String,List<String>> playLog = new HashMap<>();
        List<String> dlog = new ArrayList<>();
        dlog.add("4");
        playLog.put(d,dlog);
        playLog.put(n,new ArrayList<>());
        Map<Integer,Map<String,List<String>>>  allPlayLog = getAllPlayLog(4, ownValues, playLog, false, false);
        log.debug("getAllPlayLog = {}",allPlayLog);

    }

    /**
     * 给出所有符合逻辑的解法
     * @Param lastValue 上一个出的牌的值
     * @Param d 出牌人手上的牌
     * @Param playLog 记牌器
     * @Param play 当前是否是地主出牌
     * @Param lastPlay 上一次是否是地主出牌
     * @return allPlayLogs
     * **/
    public Map<Integer,Map<String,List<String>>> getAllPlayLog(Integer lastValue, List<Integer> ownValues, Map<String,List<String>> playLog, boolean play,boolean lastPlay){
        Map<Integer,Map<String,List<String>>> allPlayLogs = new HashMap<>();

        for(int i=0;i<ownValues.size();i++){
            Map<String,List<String>> copyLog = getCopyLog(playLog);
            log.debug("d.size = ",ownValues.size(),"d.value = ",ownValues.get(i));
            if(ownValues.get(i)>lastValue){
                if(play){
                    updatePlayLog(copyLog,d,ownValues.get(i));
                }else{
                    updatePlayLog(copyLog,n,ownValues.get(i));
                }
                allPlayLogs.put(logCount,copyLog);
                logCount++;
            }
        }
        if(!lastPlay){
            if(play){
                updatePlayLog(playLog,d,0);
            }else{
                updatePlayLog(playLog,n,0);
            }
            allPlayLogs.put(logCount,playLog);
            logCount++;
        }
        return allPlayLogs;
    }

    public void updatePlayLog(Map<String,List<String>> playLog,String player,Integer value){
        List<String> dlog = playLog.get(player);
        dlog.add(value.toString());
        playLog.put(player,dlog);
    }

    public Map<String,List<String>> getCopyLog(Map<String,List<String>> playLog){
        Set<String> k = playLog.keySet();
        Iterator<String> it = k.iterator();
        Map<String,List<String>> copyLog = new HashMap<>();
        while(it.hasNext()){
            String key = it.next().toString();
            List<String> value = playLog.get(key);
            copyLog.put(key,value);
        }
        return copyLog;
    }
}
