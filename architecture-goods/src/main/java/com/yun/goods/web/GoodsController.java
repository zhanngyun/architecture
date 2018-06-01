package com.yun.goods.web;

import com.yun.common.utils.json.JsonHelper;
import com.yun.common.utils.pageUtils.Page;
import com.yun.goods.service.IGoodsService;
import com.yun.goods.vo.GoodsModel;
import com.yun.goods.vo.GoodsQueryModel;
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
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private IGoodsService igoodsService = null;


    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "goods/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("goodsModel") GoodsModel goodsModel) {
        igoodsService.create(goodsModel);
        return "goods/success";
    }

    @RequestMapping(value = "/toUpdate/{goodsUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("goodsUuid") int goodsUuid) {
        GoodsModel goodsModel = igoodsService.getByUuid(goodsUuid);
        model.addAttribute("m", goodsModel);
        return "goods/update";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("goodsModel") GoodsModel goodsModel) {
        igoodsService.update(goodsModel);
        return "goods/success";
    }

    @RequestMapping(value = "/toDelete/{goodsUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("goodsUuid") int goodsUuid) {
        GoodsModel goodsModel = igoodsService.getByUuid(goodsUuid);
        model.addAttribute("m", goodsModel);
        return "goods/delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int goodsUuid) {
        igoodsService.delete(goodsUuid);
        return "goods/success";
    }


    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("queryJsonStr") String queryJsonStr,@ModelAttribute("page") Page page, Model model) {
        GoodsQueryModel cqm = null;
        if (queryJsonStr == null || queryJsonStr.trim().length() == 0) {
            cqm = new GoodsQueryModel();
        } else {
            cqm = JsonHelper.readValue(queryJsonStr, GoodsQueryModel.class);
        }
        cqm.setPage(page);

        Page<GoodsModel> pageList = igoodsService.getByConditionPage(cqm);
        model.addAttribute("queryJsonStr", queryJsonStr);
        model.addAttribute("page", pageList);
        return "goods/list";
    }

    @RequestMapping(value = "/toQuery", method = RequestMethod.GET)
    public String query() {
        return "goods/query";
    }


}
