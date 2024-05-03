package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiyuanbingfangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YiyuanbingfangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiyuanbingfangView;


/**
 * 医院病房
 *
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface YiyuanbingfangService extends IService<YiyuanbingfangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiyuanbingfangVO> selectListVO(Wrapper<YiyuanbingfangEntity> wrapper);
   	
   	YiyuanbingfangVO selectVO(@Param("ew") Wrapper<YiyuanbingfangEntity> wrapper);
   	
   	List<YiyuanbingfangView> selectListView(Wrapper<YiyuanbingfangEntity> wrapper);
   	
   	YiyuanbingfangView selectView(@Param("ew") Wrapper<YiyuanbingfangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiyuanbingfangEntity> wrapper);
   	
}

