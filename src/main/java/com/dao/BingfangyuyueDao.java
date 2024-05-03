package com.dao;

import com.entity.BingfangyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BingfangyuyueVO;
import com.entity.view.BingfangyuyueView;


/**
 * 病房预约
 * 
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public interface BingfangyuyueDao extends BaseMapper<BingfangyuyueEntity> {
	
	List<BingfangyuyueVO> selectListVO(@Param("ew") Wrapper<BingfangyuyueEntity> wrapper);
	
	BingfangyuyueVO selectVO(@Param("ew") Wrapper<BingfangyuyueEntity> wrapper);
	
	List<BingfangyuyueView> selectListView(@Param("ew") Wrapper<BingfangyuyueEntity> wrapper);

	List<BingfangyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<BingfangyuyueEntity> wrapper);
	
	BingfangyuyueView selectView(@Param("ew") Wrapper<BingfangyuyueEntity> wrapper);
	
}
