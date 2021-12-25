package com.dw.controller.mysql;

import com.dw.model.mysql.ResultVo;
import com.dw.service.mysql.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/day")
public class DayController {
    @Autowired
    DayService dayService;
    @RequestMapping(value = "/time")
    public ResultVo getCountByTime(@RequestParam String time, @RequestParam String type, @RequestParam String than) {
        List result= new ArrayList();
        long resulttime=0;
        String[] ymd = time.split("-");
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);
        int season = (month-1) / 4 + 1;
        switch (type) {
            case "year": {
                result = dayService.yearCount(year, than);
                resulttime=dayService.yeartime();
                break;
            }
            case "month": {
                result = dayService.monthCount(year, month, than);
                resulttime=dayService.monthtime();
                break;
            }
            case "day": {
                result = dayService.dayCount(year, month, day, than);
                resulttime=dayService.daytime();
                break;
            }
            case "season": {
                result = dayService.seasonCount(year, season);
                resulttime=dayService.seasontime();
                break;
            }
        }
        List<Integer> list =result;
        List<HashMap<String, String>> resultfinal = new ArrayList<>();
        for(Integer item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            temp1.put("count",item.toString());
            resultfinal.add(temp1);
        }
        return new ResultVo(resultfinal,resulttime);
    }
}
