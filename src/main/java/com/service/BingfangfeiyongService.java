package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BingfangfeiyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BingfangfeiyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BingfangfeiyongView;


/**
 * 病房费用
 *
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface BingfangfeiyongService extends IService<BingfangfeiyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BingfangfeiyongVO> selectListVO(Wrapper<BingfangfeiyongEntity> wrapper);
   	
   	BingfangfeiyongVO selectVO(@Param("ew") Wrapper<BingfangfeiyongEntity> wrapper);
   	
   	List<BingfangfeiyongView> selectListView(Wrapper<BingfangfeiyongEntity> wrapper);
   	
   	BingfangfeiyongView selectView(@Param("ew") Wrapper<BingfangfeiyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BingfangfeiyongEntity> wrapper);
   	
}

