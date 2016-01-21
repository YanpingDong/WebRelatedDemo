package models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 停车场入口类
 * @author hzy
 *
 */
public class Peps {
	private Double[] pep_pt;

	private String pep_ppoint;

	private int pep_az;

	private Boolean pep_b_primary;

	private String pep_type;

	public void setPep_pt(Double[] pep_pt) {
		this.pep_pt = pep_pt;
	}

	public Double[] getPep_pt() {
		return this.pep_pt;
	}

	public void setPep_ppoint(String pep_ppoint) {
		this.pep_ppoint = pep_ppoint;
	}

	public String getPep_ppoint() {
		return this.pep_ppoint;
	}

	public void setPep_az(int pep_az) {
		this.pep_az = pep_az;
	}

	public int getPep_az() {
		return this.pep_az;
	}

	public void setPep_b_primary(Boolean pep_b_primary) {
		this.pep_b_primary = pep_b_primary;
	}

	public Boolean getPep_b_primary() {
		return this.pep_b_primary;
	}

	public void setPep_type(String pep_type) {
		this.pep_type = pep_type;
	}

	public String getPep_type() {
		return this.pep_type;
	}
	@Override
	public String toString()
	{
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
