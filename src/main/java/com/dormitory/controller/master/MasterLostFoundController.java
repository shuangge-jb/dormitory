package com.dormitory.controller.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.LostFoundController;
import com.dormitory.entity.LostFound;
import com.dormitory.entity.Master;
import com.dormitory.service.LostFoundService;
import com.dormitory.service.MasterService;

@Controller("masterLostFoundController")
@RequestMapping(value = "/master")
public class MasterLostFoundController extends LostFoundController {
	@Resource
	private MasterService masterService;

	/**
	 * 查看本楼的明信片
	 * 
	 * @param masterId
	 * @return
	 */
	@RequestMapping(value = "listLostFoundByMasterId.do")
	@ResponseBody
	public String listLostFoundByMasterId(@RequestParam(value = "masterId") Integer masterId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		Master master = masterService.get(masterId);
		Integer buildingId = master.getBuildingId();
		List<LostFound> list = lostFoundService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total = lostFoundService.getSizeByBuildingId(buildingId);
		Integer count = getTotalPages(total, pageSize);
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("data", list);
		map.put("total", total);
		map.put("totalPages", count);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		map.put("result", list!=null);
		return toJSON(map);
	}

}
