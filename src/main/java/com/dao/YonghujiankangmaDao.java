package com.dao;

import com.entity.YonghujiankangmaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghujiankangmaVO;
import com.entity.view.YonghujiankangmaView;


/**
 * 用户健康码
 * 
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface YonghujiankangmaDao extends BaseMapper<YonghujiankangmaEntity> {
	
	List<YonghujiankangmaVO> selectListVO(@Param("ew") Wrapper<YonghujiankangmaEntity> wrapper);
	
	YonghujiankangmaVO selectVO(@Param("ew") Wrapper<YonghujiankangmaEntity> wrapper);
	
	List<YonghujiankangmaView> selectListView(@Param("ew") Wrapper<YonghujiankangmaEntity> wrapper);

	List<YonghujiankangmaView> selectListView(Pagination page,@Param("ew") Wrapper<YonghujiankangmaEntity> wrapper);
	
	YonghujiankangmaView selectView(@Param("ew") Wrapper<YonghujiankangmaEntity> wrapper);
	
}
