package com.lcr.applyhelper.web;

import com.lcr.applyhelper.entity.*;
import com.lcr.applyhelper.service.JobCollectService;
import com.lcr.applyhelper.service.JobService;
import com.lcr.applyhelper.service.JobapplyService;
import com.lcr.applyhelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;
    @Autowired
    private JobapplyService jobapplyService;
    @Autowired
    private JobCollectService jobCollectService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    private Map<String,Object> findAll(@RequestParam(value = "city")String city){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Job> list=jobService.findAll(city);
        modelMap.put("Alljob",list);
        System.out.println("兼职：findAll");
        return modelMap;
    }

    @RequestMapping(value = "/findbyid",method = RequestMethod.POST)
    private Map<String,Object> queryUserById(@RequestParam(value = "jobId")Integer jobId){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("user",jobService.selectByPrimaryKey(jobId));
        return modelMap;
    }

    @RequestMapping(value = "/applyjob",method = RequestMethod.POST)
    private Map<String,Object> applyJob(@RequestParam(value = "jobId")Integer jobId,
                                        @RequestParam(value = "userId")String userId){
        Map<String,Object> modelMap = new HashMap<>();
        System.out.println("兼职:applyjob");
        User user=userService.selectByPrimaryKey(userId);
        if (user!=null){
            System.out.println("兼职:applyjob+1");
            if (user.getSex()==null||user.getUserCountry()==null
                    &&user.getMajor()==null||user.getGrade()==null||user.getCertificate()==null){
                modelMap.put("applyjob","fail");
                return modelMap;
            }
        }else {
            System.out.println("兼职:applyjob+2");
            modelMap.put("applyjob","fail");
            return modelMap;
        }

        JobApply jobApply=new JobApply(userId,jobId);
        jobApply.setApplystatus(1);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jobApply.setStartdate(df.format(day));
        int effect=jobapplyService.insert(jobApply);
        if(effect>0){
            modelMap.put("applyres","success");
        }else{
            modelMap.put("applyres","fail");
        }
        return modelMap;
    }

    @RequestMapping(value = "/findapplyjob",method = RequestMethod.POST)
    private Map<String,Object> findApplyJob(@RequestParam(value = "jobId")Integer jobId,
                                      @RequestParam(value = "userId")String userId){
        Map<String,Object> modelMap = new HashMap<>();
        System.out.println("兼职：findapplyjob");
        JobapplyKey jobApply=new JobapplyKey(userId,jobId);
        JobApply effect=jobapplyService.findById(jobApply);

        if(effect!=null){
            modelMap.put("findapplyjob","success");
        }else{
            modelMap.put("findapplyjob","fail");
        }

        return modelMap;
    }

    @RequestMapping(value = "/endjob",method = RequestMethod.POST)
    private Map<String,Object> endJob(@RequestParam(value = "jobId")Integer jobId,
                                        @RequestParam(value = "userId")String userId){
        Map<String,Object> modelMap = new HashMap<>();
        JobApply jobApply=new JobApply(userId,jobId);
        jobApply.setApplystatus(2);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jobApply.setStopdate(df.format(day));
        int effect=jobapplyService.updateByPrimaryKey(jobApply);
        if(effect>0){
            modelMap.put("endjob","success");
        }else{
            modelMap.put("endjob","fail");
        }
        return modelMap;
    }

    @RequestMapping(value = "collectjob",method = RequestMethod.POST)
    private Map<String,Object> collectJob(@RequestParam(value = "jobId")Integer jobId,
                                      @RequestParam(value = "userId")String userId){
        Map<String,Object> modelMap = new HashMap<>();
        JobCollectKey jobCollectKey=new JobCollectKey();
        jobCollectKey.setJobID(jobId);
        jobCollectKey.setUserID(userId);
        int effect=jobCollectService.insert(jobCollectKey);
        if(effect>0){
            modelMap.put("endjob","success");
        }else{
            modelMap.put("endjob","fail");
        }
        return modelMap;
    }

    @RequestMapping(value = "findcollectjob",method = RequestMethod.POST)
    private Map<String,Object> findCollectJob(@RequestParam(value = "jobId")Integer jobId,
                                              @RequestParam(value = "userId")String userId){
        Map<String,Object> modelMap = new HashMap<>();
        List<JobCollectKey>jobCollectKeys=jobCollectService.findByUserId(userId);
        List<Job> jobList=new ArrayList<Job>();
        List<JobApply> jobApplyList=new ArrayList<JobApply>();
        for (int i=0;i<jobCollectKeys.size();i++){
            Job job=jobService.selectByPrimaryKey(jobCollectKeys.get(i).getJobID());
            jobList.add(job);
            JobApply jobApply=jobapplyService.findById(new JobapplyKey(userId,jobId));
            jobApplyList.add(jobApply);
        }
        modelMap.put("joblist",jobList);
        modelMap.put("jobapplylist",jobApplyList);

        return modelMap;
    }
}
