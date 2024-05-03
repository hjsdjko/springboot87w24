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


import com.dao.YonghujiankangmaDao;
import com.entity.YonghujiankangmaEntity;
import com.service.YonghujiankangmaService;
import com.entity.vo.YonghujiankangmaVO;
import com.entity.view.YonghujiankangmaView;

@Service("yonghujiankangmaService")
public class YonghujiankangmaServiceImpl extends ServiceImpl<YonghujiankangmaDao, YonghujiankangmaEntity> implements YonghujiankangmaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghujiankangmaEntity> page = this.selectPage(
                new Query<YonghujiankangmaEntity>(params).getPage(),
                new EntityWrapper<YonghujiankangmaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghujiankangmaEntity> wrapper) {
		  Page<YonghujiankangmaView> page =new Query<YonghujiankangmaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghujiankangmaVO> selectListVO(Wrapper<YonghujiankangmaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghujiankangmaVO selectVO(Wrapper<YonghujiankangmaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghujiankangmaView> selectListView(Wrapper<YonghujiankangmaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghujiankangmaView selectView(Wrapper<YonghujiankangmaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
