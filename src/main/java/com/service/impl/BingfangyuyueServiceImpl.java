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


import com.dao.BingfangyuyueDao;
import com.entity.BingfangyuyueEntity;
import com.service.BingfangyuyueService;
import com.entity.vo.BingfangyuyueVO;
import com.entity.view.BingfangyuyueView;

@Service("bingfangyuyueService")
public class BingfangyuyueServiceImpl extends ServiceImpl<BingfangyuyueDao, BingfangyuyueEntity> implements BingfangyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BingfangyuyueEntity> page = this.selectPage(
                new Query<BingfangyuyueEntity>(params).getPage(),
                new EntityWrapper<BingfangyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BingfangyuyueEntity> wrapper) {
		  Page<BingfangyuyueView> page =new Query<BingfangyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BingfangyuyueVO> selectListVO(Wrapper<BingfangyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BingfangyuyueVO selectVO(Wrapper<BingfangyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BingfangyuyueView> selectListView(Wrapper<BingfangyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BingfangyuyueView selectView(Wrapper<BingfangyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
