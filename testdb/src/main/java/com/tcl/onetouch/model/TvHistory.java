package com.tcl.onetouch.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name ="tvhistory",uniqueConstraints={@UniqueConstraint(columnNames={"username","stype", "vtype","media_id"})})
public class TvHistory implements Serializable {
	private static final long serialVersionUID = -3944432087476701972L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@NotNull
    @Size(min = 1, max = 100)
    @Column(name="username",length = 100, unique = true, nullable = false)
    private String username;
   
	//@NotNull
    @Size(min = 1, max = 200)
    @Column(name="media_id",length = 200, unique = true, nullable = false)
    private String mediaId;
	
    @Size(min=1,max=50)
	//@NotNull
    @Column(name="stype")
    private String stype;

    @Size(min=1,max=50)
	//@NotNull
    @Column(name="vtype")
    private String vtype;
    
    @Column(name = "ver")
    private Integer ver;
   
    @Column(name = "extra")
    private String extra;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "starting_time", nullable = true)
    private Date startingtime;
    
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time", nullable = true)
    private Date endtime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp 
    @Column(name="timestamp")
    private Date timestamp;
    
    public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getVtype() {
		return vtype;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public Integer getVer() {
		return ver;
	}

	public void setVer(Integer ver) {
		this.ver = ver;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Date getStartingtime() {
		return startingtime;
	}

	public void setStartingtime(Date startingtime) {
		this.startingtime = startingtime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TvHistory tvhistory = (TvHistory) o;
        if(tvhistory.username == null || username == null) {
            return false;
        }
        return Objects.equals(username, tvhistory.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "TvHistory{" +
            "id=" + id +
            ", username=" + username +
            ", mediaId=" + mediaId +
            ", stype=" + stype +
            ", vtype=" + vtype +
//            ", timestamp='" + timestamp + "'" +
            '}';
    }
}
