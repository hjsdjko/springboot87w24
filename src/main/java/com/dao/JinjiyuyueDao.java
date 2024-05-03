package com.dao;

import com.entity.JinjiyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JinjiyuyueVO;
import com.entity.view.JinjiyuyueView;


/**
 * 紧急预约
 * 
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface JinjiyuyueDao extends BaseMapper<JinjiyuyueEntity> {
	
	List<JinjiyuyueVO> selectListVO(@Param("ew") Wrapper<JinjiyuyueEntity> wrapper);
	
	JinjiyuyueVO selectVO(@Param("ew") Wrapper<JinjiyuyueEntity> wrapper);
	
	List<JinjiyuyueView> selectListView(@Param("ew") Wrapper<JinjiyuyueEntity> wrapper);

	List<JinjiyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<JinjiyuyueEntity> wrapper);
	
	JinjiyuyueView selectView(@Param("ew") Wrapper<JinjiyuyueEntity> wrapper);
	
}
