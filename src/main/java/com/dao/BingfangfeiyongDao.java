package com.dao;

import com.entity.BingfangfeiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BingfangfeiyongVO;
import com.entity.view.BingfangfeiyongView;


/**
 * 病房费用
 * 
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface BingfangfeiyongDao extends BaseMapper<BingfangfeiyongEntity> {
	
	List<BingfangfeiyongVO> selectListVO(@Param("ew") Wrapper<BingfangfeiyongEntity> wrapper);
	
	BingfangfeiyongVO selectVO(@Param("ew") Wrapper<BingfangfeiyongEntity> wrapper);
	
	List<BingfangfeiyongView> selectListView(@Param("ew") Wrapper<BingfangfeiyongEntity> wrapper);

	List<BingfangfeiyongView> selectListView(Pagination page,@Param("ew") Wrapper<BingfangfeiyongEntity> wrapper);
	
	BingfangfeiyongView selectView(@Param("ew") Wrapper<BingfangfeiyongEntity> wrapper);
	
}
