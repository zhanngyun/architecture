package com.yun.order.web;

import com.yun.common.utils.json.JsonHelper;
import com.yun.common.utils.pageUtils.Page;
import com.yun.order.service.IOrderService;
import com.yun.order.vo.OrderModel;
import com.yun.order.vo.OrderQueryModel;
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
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private IOrderService iorderService = null;


    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "order/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("orderModel") OrderModel orderModel) {
        iorderService.create(orderModel);
        return "order/success";
    }

    @RequestMapping(value = "/toUpdate/{orderUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("orderUuid") int orderUuid) {
        OrderModel orderModel = iorderService.getByUuid(orderUuid);
        model.addAttribute("m", orderModel);
        return "order/update";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("orderModel") OrderModel orderModel) {
        iorderService.update(orderModel);
        return "order/success";
    }

    @RequestMapping(value = "/toDelete/{orderUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("orderUuid") int orderUuid) {
        OrderModel orderModel = iorderService.getByUuid(orderUuid);
        model.addAttribute("m", orderModel);
        return "order/delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int orderUuid) {
        iorderService.delete(orderUuid);
        return "order/success";
    }


    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("queryJsonStr") String queryJsonStr,@ModelAttribute("page") Page page, Model model) {
        OrderQueryModel cqm = null;
        if (queryJsonStr == null || queryJsonStr.trim().length() == 0) {
            cqm = new OrderQueryModel();
        } else {
            cqm = JsonHelper.readValue(queryJsonStr, OrderQueryModel.class);
        }
        cqm.setPage(page);

        Page<OrderModel> pageList = iorderService.getByConditionPage(cqm);
        model.addAttribute("queryJsonStr", queryJsonStr);
        model.addAttribute("page", pageList);
        return "order/list";
    }

    @RequestMapping(value = "/toQuery", method = RequestMethod.GET)
    public String query() {
        return "order/query";
    }


}
