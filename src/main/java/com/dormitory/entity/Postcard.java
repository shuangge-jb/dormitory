package com.dormitory.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Postcard {
    protected Integer postcardId;
@NotNull
@NotEmpty
    protected String name;

    protected Integer buildingId;

    protected Date createTime;

    protected Integer state;

    public Integer getPostcardId() {
        return postcardId;
    }

    public void setPostcardId(Integer postcardId) {
        this.postcardId = postcardId;
    }

    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postcardId=").append(postcardId);
        sb.append(", name=").append(name);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", createTime=").append(createTime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}