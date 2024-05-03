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


import com.dao.BingfangfeiyongDao;
import com.entity.BingfangfeiyongEntity;
import com.service.BingfangfeiyongService;
import com.entity.vo.BingfangfeiyongVO;
import com.entity.view.BingfangfeiyongView;

@Service("bingfangfeiyongService")
public class BingfangfeiyongServiceImpl extends ServiceImpl<BingfangfeiyongDao, BingfangfeiyongEntity> implements BingfangfeiyongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BingfangfeiyongEntity> page = this.selectPage(
                new Query<BingfangfeiyongEntity>(params).getPage(),
                new EntityWrapper<BingfangfeiyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BingfangfeiyongEntity> wrapper) {
		  Page<BingfangfeiyongView> page =new Query<BingfangfeiyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BingfangfeiyongVO> selectListVO(Wrapper<BingfangfeiyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BingfangfeiyongVO selectVO(Wrapper<BingfangfeiyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BingfangfeiyongView> selectListView(Wrapper<BingfangfeiyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BingfangfeiyongView selectView(Wrapper<BingfangfeiyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
