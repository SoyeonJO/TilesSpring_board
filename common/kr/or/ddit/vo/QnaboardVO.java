package kr.or.ddit.vo;

import java.util.List;

public class QnaboardVO {
	private String qa_no        ;
	private String qa_title     ;
	private String qa_content   ;
	private String qa_hit       ;
	private String qa_reg_date  ;
	private String qa_pwd       ;
	private String qa_status    ;
	private String qa_seq       ;
	private String qa_group     ;
	private String qa_depth     ;
	private String qa_mem_id    ;
	private String rnum;
	private List<FileItemVO> items;
	
	
	public List<FileItemVO> getItems() {
		return items;
	}
	public void setItems(List<FileItemVO> items) {
		this.items = items;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getQa_no() {
		return qa_no;
	}
	public void setQa_no(String qa_no) {
		this.qa_no = qa_no;
	}
	public String getQa_title() {
		return qa_title;
	}
	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public String getQa_hit() {
		return qa_hit;
	}
	public void setQa_hit(String qa_hit) {
		this.qa_hit = qa_hit;
	}
	public String getQa_reg_date() {
		return qa_reg_date;
	}
	public void setQa_reg_date(String qa_reg_date) {
		this.qa_reg_date = qa_reg_date;
	}
	public String getQa_pwd() {
		return qa_pwd;
	}
	public void setQa_pwd(String qa_pwd) {
		this.qa_pwd = qa_pwd;
	}
	public String getQa_status() {
		return qa_status;
	}
	public void setQa_status(String qa_status) {
		this.qa_status = qa_status;
	}
	public String getQa_seq() {
		return qa_seq;
	}
	public void setQa_seq(String qa_seq) {
		this.qa_seq = qa_seq;
	}
	public String getQa_group() {
		return qa_group;
	}
	public void setQa_group(String qa_group) {
		this.qa_group = qa_group;
	}
	public String getQa_depth() {
		return qa_depth;
	}
	public void setQa_depth(String qa_depth) {
		this.qa_depth = qa_depth;
	}
	public String getQa_mem_id() {
		return qa_mem_id;
	}
	public void setQa_mem_id(String qa_mem_id) {
		this.qa_mem_id = qa_mem_id;
	}
	
	
}
