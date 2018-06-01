package com.yun.store.web;

import com.yun.common.utils.json.JsonHelper;
import com.yun.common.utils.pageUtils.Page;
import com.yun.store.service.IStoreService;
import com.yun.store.vo.StoreModel;
import com.yun.store.vo.StoreQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author yzhang
 * @date 2018/5/28 21:50
 * @desc
 */
@Controller
@RequestMapping("/store")
public class StoreController {


    @Autowired
    private IStoreService istoreService = null;


    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "store/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("storeModel") StoreModel storeModel) {
        istoreService.create(storeModel);
        return "store/success";
    }

    @RequestMapping(value = "/toUpdate/{storeUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("storeUuid") int storeUuid) {
        StoreModel storeModel = istoreService.getByUuid(storeUuid);
        model.addAttribute("m", storeModel);
        return "store/update";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("storeModel") StoreModel storeModel) {
        istoreService.update(storeModel);
        return "store/success";
    }

    @RequestMapping(value = "/toDelete/{storeUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("storeUuid") int storeUuid) {
        StoreModel storeModel = istoreService.getByUuid(storeUuid);
        model.addAttribute("m", storeModel);
        return "store/delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int storeUuid) {
        istoreService.delete(storeUuid);
        return "store/success";
    }


    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("queryJsonStr") String queryJsonStr,@ModelAttribute("page") Page page, Model model) {
        StoreQueryModel cqm = null;
        if (queryJsonStr == null || queryJsonStr.trim().length() == 0) {
            cqm = new StoreQueryModel();
        } else {
            cqm = JsonHelper.readValue(queryJsonStr, StoreQueryModel.class);
        }
        cqm.setPage(page);

        Page<StoreModel> pageList = istoreService.getByConditionPage(cqm);
        model.addAttribute("queryJsonStr", queryJsonStr);
        model.addAttribute("page", pageList);
        return "store/list";
    }

    @RequestMapping(value = "/toQuery", method = RequestMethod.GET)
    public String query() {
        return "store/query";
    }


}
