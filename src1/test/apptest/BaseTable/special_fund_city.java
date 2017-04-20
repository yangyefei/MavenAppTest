package test.apptest.BaseTable;

import java.sql.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class special_fund_city {
	private Integer id;
	private Integer city_id;
	private String city_name;
	private Integer city_sort;
	private Date creat_time;
	private Date update_time;
	private String qusetion_endorse;
	private Integer from_type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public Integer getCity_sort() {
		return city_sort;
	}

	public void setCity_sort(Integer city_sort) {
		this.city_sort = city_sort;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getQusetion_endorse() {
		return qusetion_endorse;
	}

	public void setQusetion_endorse(String qusetion_endorse) {
		this.qusetion_endorse = qusetion_endorse;
	}

	public Integer getFrom_type() {
		return from_type;
	}

	public void setFrom_type(Integer from_type) {
		this.from_type = from_type;
	}

	@Override
	public String toString() {
		return "special_fund_city [id=" + id + ", city_id=" + city_id + ", city_name=" + city_name + ", city_sort="
				+ city_sort + ", creat_time=" + creat_time + ", update_time=" + update_time + ", qusetion_endorse="
				+ qusetion_endorse + ", from_type=" + from_type + "]";
	}

}
