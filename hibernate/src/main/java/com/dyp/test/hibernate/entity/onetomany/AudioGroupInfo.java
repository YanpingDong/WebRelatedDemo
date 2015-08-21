package com.dyp.test.hibernate.entity.onetomany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.google.common.collect.Lists;

@Entity  
@Table(name = "audio_group_info") 
@DynamicInsert @DynamicUpdate
public class AudioGroupInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String titleRid;		// 每个视频唯一ID, 例如《虎妈猫爸》的ID
	private String titleName; 	    // 连续剧名称，例如《虎妈猫爸》
	private Date createTime;	    // 资源最初创建时间
	private List<AudioInfo> childList = Lists.newArrayList();
	
	@Id
	public String getTitleRid() {
		return titleRid;
	}
	public void setTitleRid(String titleRid) {
		this.titleRid = titleRid;
	}
	public String getTitleName() {
		return titleName;
	}
	
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**/
	@CascadeDel
	@NotNull
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "audioGroupInfo",orphanRemoval=true, cascade = { CascadeType.ALL } )  
	@OrderBy("createTime ASC")
	public List<AudioInfo> getChildList() {
		return childList;
	}
	public void setChildList(List<AudioInfo> childList) {
		this.childList = childList;
	}
}
