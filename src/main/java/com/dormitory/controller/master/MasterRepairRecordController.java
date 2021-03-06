package com.dormitory.controller.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.RepairRecordController;
import com.dormitory.entity.Master;
import com.dormitory.entity.RepairRecord;
import com.dormitory.service.MasterService;
import com.dormitory.service.RepairRecordService;

@Controller
@RequestMapping(value = "/master")
public class MasterRepairRecordController extends RepairRecordController {
	@Resource
	private MasterService masterService;
/**
 * 查看本楼的维修记录
 * @param masterId
 * @return
 */
	@RequestMapping(value="listRepairRecordByMasterId.do")
	@ResponseBody
public String listRepairRecordByMasterId(@RequestParam(value="masterId")Integer masterId,@RequestParam(value="pageIndex")Integer pageIndex,@RequestParam(value="pageSize")Integer pageSize){
	Master master=masterService.get(masterId);
	Integer buildingId=master.getBuildingId();
		List<RepairRecord> list=repairRecordService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total=repairRecordService.getSizeByBuildingId(buildingId);
		Integer totalPage = getTotalPages(total, pageSize);
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("data", list);
		map.put("total", total);
		map.put("totalPages", totalPage);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		map.put("result", list!=null);
		return toJSON(map);
}

}
