package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JinjiyuyueDao;
import com.entity.JinjiyuyueEntity;
import com.service.JinjiyuyueService;
import com.entity.vo.JinjiyuyueVO;
import com.entity.view.JinjiyuyueView;

@Service("jinjiyuyueService")
public class JinjiyuyueServiceImpl extends ServiceImpl<JinjiyuyueDao, JinjiyuyueEntity> implements JinjiyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinjiyuyueEntity> page = this.selectPage(
                new Query<JinjiyuyueEntity>(params).getPage(),
                new EntityWrapper<JinjiyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinjiyuyueEntity> wrapper) {
		  Page<JinjiyuyueView> page =new Query<JinjiyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JinjiyuyueVO> selectListVO(Wrapper<JinjiyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinjiyuyueVO selectVO(Wrapper<JinjiyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinjiyuyueView> selectListView(Wrapper<JinjiyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinjiyuyueView selectView(Wrapper<JinjiyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
