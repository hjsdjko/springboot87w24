package com.dao;

import com.entity.YiyuanbingfangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YiyuanbingfangVO;
import com.entity.view.YiyuanbingfangView;


/**
 * 医院病房
 * 
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface YiyuanbingfangDao extends BaseMapper<YiyuanbingfangEntity> {
	
	List<YiyuanbingfangVO> selectListVO(@Param("ew") Wrapper<YiyuanbingfangEntity> wrapper);
	
	YiyuanbingfangVO selectVO(@Param("ew") Wrapper<YiyuanbingfangEntity> wrapper);
	
	List<YiyuanbingfangView> selectListView(@Param("ew") Wrapper<YiyuanbingfangEntity> wrapper);

	List<YiyuanbingfangView> selectListView(Pagination page,@Param("ew") Wrapper<YiyuanbingfangEntity> wrapper);
	
	YiyuanbingfangView selectView(@Param("ew") Wrapper<YiyuanbingfangEntity> wrapper);
	
}
