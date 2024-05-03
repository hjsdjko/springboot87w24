package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JinjiyuyueEntity;
import com.entity.view.JinjiyuyueView;

import com.service.JinjiyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 紧急预约
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
@RestController
@RequestMapping("/jinjiyuyue")
public class JinjiyuyueController {
    @Autowired
    private JinjiyuyueService jinjiyuyueService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JinjiyuyueEntity jinjiyuyue, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jinjiyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JinjiyuyueEntity> ew = new EntityWrapper<JinjiyuyueEntity>();
		PageUtils page = jinjiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinjiyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JinjiyuyueEntity jinjiyuyue, HttpServletRequest request){
        EntityWrapper<JinjiyuyueEntity> ew = new EntityWrapper<JinjiyuyueEntity>();
		PageUtils page = jinjiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinjiyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JinjiyuyueEntity jinjiyuyue){
       	EntityWrapper<JinjiyuyueEntity> ew = new EntityWrapper<JinjiyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jinjiyuyue, "jinjiyuyue")); 
        return R.ok().put("data", jinjiyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JinjiyuyueEntity jinjiyuyue){
        EntityWrapper< JinjiyuyueEntity> ew = new EntityWrapper< JinjiyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jinjiyuyue, "jinjiyuyue")); 
		JinjiyuyueView jinjiyuyueView =  jinjiyuyueService.selectView(ew);
		return R.ok("查询紧急预约成功").put("data", jinjiyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JinjiyuyueEntity jinjiyuyue = jinjiyuyueService.selectById(id);
        return R.ok().put("data", jinjiyuyue);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JinjiyuyueEntity jinjiyuyue = jinjiyuyueService.selectById(id);
        return R.ok().put("data", jinjiyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JinjiyuyueEntity jinjiyuyue, HttpServletRequest request){
    	jinjiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinjiyuyue);
        jinjiyuyueService.insert(jinjiyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JinjiyuyueEntity jinjiyuyue, HttpServletRequest request){
    	jinjiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinjiyuyue);
        jinjiyuyueService.insert(jinjiyuyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JinjiyuyueEntity jinjiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jinjiyuyue);
        jinjiyuyueService.updateById(jinjiyuyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jinjiyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JinjiyuyueEntity> wrapper = new EntityWrapper<JinjiyuyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jinjiyuyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
