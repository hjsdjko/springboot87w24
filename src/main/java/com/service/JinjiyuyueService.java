package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinjiyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinjiyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinjiyuyueView;


/**
 * 紧急预约
 *
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface JinjiyuyueService extends IService<JinjiyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinjiyuyueVO> selectListVO(Wrapper<JinjiyuyueEntity> wrapper);
   	
   	JinjiyuyueVO selectVO(@Param("ew") Wrapper<JinjiyuyueEntity> wrapper);
   	
   	List<JinjiyuyueView> selectListView(Wrapper<JinjiyuyueEntity> wrapper);
   	
   	JinjiyuyueView selectView(@Param("ew") Wrapper<JinjiyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinjiyuyueEntity> wrapper);
   	
}

