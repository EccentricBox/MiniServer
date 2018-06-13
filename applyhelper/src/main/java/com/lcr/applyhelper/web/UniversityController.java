package com.lcr.applyhelper.web;

import com.lcr.applyhelper.entity.*;
import com.lcr.applyhelper.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private RecommendService recommendService;
    @Autowired
    private RemajorService remajorService;
    @Autowired
    private UnimajorService unimajorService;

    @RequestMapping(value = "/findbyid",method = RequestMethod.POST)
    private Map<String,Object> findbyid(@RequestParam(value = "uniID")Integer uniID){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("user",universityService.selectByID(uniID));
        return modelMap;
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    private Map<String,Object> findAll(){
        System.out.println("大学：findAll");
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<University> list=universityService.findAll();
        modelMap.put("alluniversity",list);
        return modelMap;
    }
    @RequestMapping(value = "/findbyprovince",method = RequestMethod.POST)
    private Map<String,Object> findbyprovince(@RequestParam(value = "province")String province){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("user",universityService.findByProvince(province));
        return modelMap;
    }
    @RequestMapping(value = "/findbyrank",method = RequestMethod.POST)
    private Map<String,Object> findbyrank(@RequestParam(value = "rank")int rank){
        System.out.println("大学：rank"+rank);
        Map<String,Object> modelMap = new HashMap<>();
        switch (rank){
            case 0:
                modelMap.put("university",universityService.findByRank(1,30));
                break;
            case 1:
                modelMap.put("university",universityService.findByRank(31,60));
                break;
            case 2:
                modelMap.put("university",universityService.findByRank(61,90));
                break;
            case 3:
                modelMap.put("university",universityService.findByRank(91,120));
                break;
            case 4:
                modelMap.put("university",universityService.findByRank(121,150));
                break;
            case 5:
                modelMap.put("university",universityService.findByRank(151,180));
                break;
            case 6:
                modelMap.put("university",universityService.findByRank(181,210));
                break;
            default:
                modelMap.put("university","The rank is wrong!");
                break;
        }
        return modelMap;
    }

    @RequestMapping(value = "/recommend",method = RequestMethod.GET)
    private Map<String,Object> recommend(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Recommend> list=recommendService.findAll();
        List<University> universities=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Recommend recommend=list.get(i);
            University university=universityService.selectByID(recommend.getUniID());
            universities.add(university);
        }
        modelMap.put("recommend",list);
        modelMap.put("university",universities);
        return modelMap;
    }

    @RequestMapping(value = "/findmajor",method = RequestMethod.GET)
    private Map<String,Object> findMajor(){
        System.out.println("推荐：major");
        Map<String,Object> modelMap = new HashMap<>();
        List<Remajor> list = remajorService.findAll();
        modelMap.put("major",list);
        for (int i=0;i<list.size();i++){
            Integer integer=list.get(i).getMajorID();
            List<Integer> uniIDs=unimajorService.findUni(integer);
            List<University> universities=new ArrayList<University>();
            for (int j=0;j<uniIDs.size();j++){
                University university = universityService.selectByID(uniIDs.get(j));
                universities.add(university);
            }
            modelMap.put(list.get(i).getMajorName().replaceAll(" ", ""),universities);
        }
        return modelMap;
    }

    @RequestMapping(value = "/selectMajorByUniID",method = RequestMethod.POST)
    private Map<String,Object> selectMajorByUniID(@RequestParam(value = "uniID")Integer uniID){
        Map<String,Object> modelMap = new HashMap<>();
        List<Major> list=majorService.selectByUniID(uniID);
        modelMap.put("major",list);
        return modelMap;
    }
}
