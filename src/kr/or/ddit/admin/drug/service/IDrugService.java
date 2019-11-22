package kr.or.ddit.admin.drug.service;

import java.util.List;

import kr.or.ddit.vo.DrugSaveVO;

public interface IDrugService {
	public List<DrugSaveVO> getDrugName();
	
	public String countDrug(String md_ct_name);
	
	public void insertDrugInfo(DrugSaveVO drugInfo);
}
