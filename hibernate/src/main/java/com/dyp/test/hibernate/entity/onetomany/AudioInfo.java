package com.dyp.test.hibernate.entity.onetomany;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "audio_info")
@DynamicInsert @DynamicUpdate
public class AudioInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String rid;			           // 每个音频唯一ID，例如《虎妈猫爸第1集》的ID 注意和AudioGroupInfo表中titleRid区别
	private String name; 	        	   // 每个音频唯一名称，例如《虎妈猫爸第1集》 注意和AudioGroupInfo表中titleName区别
	private Date createTime;	    	   // 创建时间
	private String messageType; 		   // Queue中消息类型
	private String type; 		    	   // 如果是视频音源，视频类型如Serial、move 等
	private String description;     	   // 描述
	private String s3StoragePath;		   // oss访问路径
	private String inputPath; 	    	   // 音频bdt文件所在OSS路径
	private Integer accessNum=0;      	   // 音频数据访问次数
	private Integer videoDuration;         // 音频总时长
	private AudioGroupInfo audioGroupInfo; // 所属组，对系例局有剧，比如电视连续剧，例《虎妈猫爸第集》
	
	@Id
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getMessageType() {
		return messageType;
	}
	
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getS3StoragePath() {
		return s3StoragePath;
	}
	public void setS3StoragePath(String s3StoragePath) {
		this.s3StoragePath = s3StoragePath;
	}
	
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public Integer getAccessNum() {
		return accessNum;
	}
	public void setAccessNum(Integer accessNum) {
		this.accessNum = accessNum;
	}
	
	public Integer getVideoDuration() {
		return videoDuration;
	}
	public void setVideoDuration(Integer videoDuration) {
		this.videoDuration = videoDuration;
	}
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="titleRid")
	public AudioGroupInfo getAudioGroupInfo() {
		return audioGroupInfo;
	}
	public void setAudioGroupInfo(AudioGroupInfo audioGroupInfo) {
		this.audioGroupInfo = audioGroupInfo;
	}
}
