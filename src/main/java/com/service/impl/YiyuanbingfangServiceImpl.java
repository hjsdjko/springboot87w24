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


import com.dao.YiyuanbingfangDao;
import com.entity.YiyuanbingfangEntity;
import com.service.YiyuanbingfangService;
import com.entity.vo.YiyuanbingfangVO;
import com.entity.view.YiyuanbingfangView;

@Service("yiyuanbingfangService")
public class YiyuanbingfangServiceImpl extends ServiceImpl<YiyuanbingfangDao, YiyuanbingfangEntity> implements YiyuanbingfangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiyuanbingfangEntity> page = this.selectPage(
                new Query<YiyuanbingfangEntity>(params).getPage(),
                new EntityWrapper<YiyuanbingfangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiyuanbingfangEntity> wrapper) {
		  Page<YiyuanbingfangView> page =new Query<YiyuanbingfangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YiyuanbingfangVO> selectListVO(Wrapper<YiyuanbingfangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YiyuanbingfangVO selectVO(Wrapper<YiyuanbingfangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiyuanbingfangView> selectListView(Wrapper<YiyuanbingfangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiyuanbingfangView selectView(Wrapper<YiyuanbingfangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
