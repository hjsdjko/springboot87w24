package com.entity.vo;

import com.entity.YiyuanbingfangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 医院病房
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
public class YiyuanbingfangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 科室
	 */
	
	private String keshi;
		
	/**
	 * 提供设施
	 */
	
	private String tigongsheshi;
		
	/**
	 * 病房位置
	 */
	
	private String bingfangweizhi;
		
	/**
	 * 封面图片
	 */
	
	private String fengmiantupian;
		
	/**
	 * 床位号
	 */
	
	private String chuangweihao;
		
	/**
	 * 一日价格
	 */
	
	private Integer yirijiage;
				
	
	/**
	 * 设置：科室
	 */
	 
	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}
	
	/**
	 * 获取：科室
	 */
	public String getKeshi() {
		return keshi;
	}
				
	
	/**
	 * 设置：提供设施
	 */
	 
	public void setTigongsheshi(String tigongsheshi) {
		this.tigongsheshi = tigongsheshi;
	}
	
	/**
	 * 获取：提供设施
	 */
	public String getTigongsheshi() {
		return tigongsheshi;
	}
				
	
	/**
	 * 设置：病房位置
	 */
	 
	public void setBingfangweizhi(String bingfangweizhi) {
		this.bingfangweizhi = bingfangweizhi;
	}
	
	/**
	 * 获取：病房位置
	 */
	public String getBingfangweizhi() {
		return bingfangweizhi;
	}
				
	
	/**
	 * 设置：封面图片
	 */
	 
	public void setFengmiantupian(String fengmiantupian) {
		this.fengmiantupian = fengmiantupian;
	}
	
	/**
	 * 获取：封面图片
	 */
	public String getFengmiantupian() {
		return fengmiantupian;
	}
				
	
	/**
	 * 设置：床位号
	 */
	 
	public void setChuangweihao(String chuangweihao) {
		this.chuangweihao = chuangweihao;
	}
	
	/**
	 * 获取：床位号
	 */
	public String getChuangweihao() {
		return chuangweihao;
	}
				
	
	/**
	 * 设置：一日价格
	 */
	 
	public void setYirijiage(Integer yirijiage) {
		this.yirijiage = yirijiage;
	}
	
	/**
	 * 获取：一日价格
	 */
	public Integer getYirijiage() {
		return yirijiage;
	}
			
}
