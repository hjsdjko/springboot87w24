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

import com.entity.BingfangyuyueEntity;
import com.entity.view.BingfangyuyueView;

import com.service.BingfangyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 病房预约
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
@RestController
@RequestMapping("/bingfangyuyue")
public class BingfangyuyueController {
    @Autowired
    private BingfangyuyueService bingfangyuyueService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BingfangyuyueEntity bingfangyuyue, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			bingfangyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BingfangyuyueEntity> ew = new EntityWrapper<BingfangyuyueEntity>();
		PageUtils page = bingfangyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bingfangyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BingfangyuyueEntity bingfangyuyue, HttpServletRequest request){
        EntityWrapper<BingfangyuyueEntity> ew = new EntityWrapper<BingfangyuyueEntity>();
		PageUtils page = bingfangyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bingfangyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BingfangyuyueEntity bingfangyuyue){
       	EntityWrapper<BingfangyuyueEntity> ew = new EntityWrapper<BingfangyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bingfangyuyue, "bingfangyuyue")); 
        return R.ok().put("data", bingfangyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BingfangyuyueEntity bingfangyuyue){
        EntityWrapper< BingfangyuyueEntity> ew = new EntityWrapper< BingfangyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bingfangyuyue, "bingfangyuyue")); 
		BingfangyuyueView bingfangyuyueView =  bingfangyuyueService.selectView(ew);
		return R.ok("查询病房预约成功").put("data", bingfangyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BingfangyuyueEntity bingfangyuyue = bingfangyuyueService.selectById(id);
        return R.ok().put("data", bingfangyuyue);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BingfangyuyueEntity bingfangyuyue = bingfangyuyueService.selectById(id);
        return R.ok().put("data", bingfangyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BingfangyuyueEntity bingfangyuyue, HttpServletRequest request){
    	bingfangyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bingfangyuyue);
        bingfangyuyueService.insert(bingfangyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BingfangyuyueEntity bingfangyuyue, HttpServletRequest request){
    	bingfangyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bingfangyuyue);
        bingfangyuyueService.insert(bingfangyuyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BingfangyuyueEntity bingfangyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bingfangyuyue);
        bingfangyuyueService.updateById(bingfangyuyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bingfangyuyueService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<BingfangyuyueEntity> wrapper = new EntityWrapper<BingfangyuyueEntity>();
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

		int count = bingfangyuyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
