package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 医院病房
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-02-24 10:50:22
 */
@TableName("yiyuanbingfang")
public class YiyuanbingfangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YiyuanbingfangEntity() {
		
	}
	
	public YiyuanbingfangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 病房号
	 */
					
	private String bingfanghao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：病房号
	 */
	public void setBingfanghao(String bingfanghao) {
		this.bingfanghao = bingfanghao;
	}
	/**
	 * 获取：病房号
	 */
	public String getBingfanghao() {
		return bingfanghao;
	}
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
