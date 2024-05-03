package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BingfangyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BingfangyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BingfangyuyueView;


/**
 * 病房预约
 *
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface BingfangyuyueService extends IService<BingfangyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BingfangyuyueVO> selectListVO(Wrapper<BingfangyuyueEntity> wrapper);
   	
   	BingfangyuyueVO selectVO(@Param("ew") Wrapper<BingfangyuyueEntity> wrapper);
   	
   	List<BingfangyuyueView> selectListView(Wrapper<BingfangyuyueEntity> wrapper);
   	
   	BingfangyuyueView selectView(@Param("ew") Wrapper<BingfangyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BingfangyuyueEntity> wrapper);
   	
}

