package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghujiankangmaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghujiankangmaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghujiankangmaView;


/**
 * 用户健康码
 *
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface YonghujiankangmaService extends IService<YonghujiankangmaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghujiankangmaVO> selectListVO(Wrapper<YonghujiankangmaEntity> wrapper);
   	
   	YonghujiankangmaVO selectVO(@Param("ew") Wrapper<YonghujiankangmaEntity> wrapper);
   	
   	List<YonghujiankangmaView> selectListView(Wrapper<YonghujiankangmaEntity> wrapper);
   	
   	YonghujiankangmaView selectView(@Param("ew") Wrapper<YonghujiankangmaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghujiankangmaEntity> wrapper);
   	
}

