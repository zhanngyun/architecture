package com.yun.order.web;

import com.yun.common.utils.json.JsonHelper;
import com.yun.common.utils.pageUtils.Page;
import com.yun.order.service.IOrderDetailService;
import com.yun.order.vo.OrderDetailModel;
import com.yun.order.vo.OrderDetailQueryModel;
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
@RequestMapping("/orderDetail")
public class OrderDetailController {


    @Autowired
    private IOrderDetailService orderDetailService = null;


    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "orderDetail/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("orderDetailModel") OrderDetailModel orderDetailModel) {
        orderDetailService.create(orderDetailModel);
        return "orderDetail/success";
    }

    @RequestMapping(value = "/toUpdate/{orderUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("orderUuid") int orderUuid) {
        OrderDetailModel orderDetailModel = orderDetailService.getByUuid(orderUuid);
        model.addAttribute("m", orderDetailModel);
        return "orderDetail/update";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("orderDetailModel") OrderDetailModel orderDetailModel) {
        orderDetailService.update(orderDetailModel);
        return "orderDetail/success";
    }

    @RequestMapping(value = "/toDelete/{orderUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("orderUuid") int orderUuid) {
        OrderDetailModel orderDetailModel = orderDetailService.getByUuid(orderUuid);
        model.addAttribute("m",orderDetailModel);
        return "orderDetail/delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int orderUuid) {
        orderDetailService.delete(orderUuid);
        return "orderDetail/success";
    }


    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("queryJsonStr") String queryJsonStr,@ModelAttribute("page") Page page, Model model) {
        OrderDetailQueryModel cqm = null;
        if (queryJsonStr == null || queryJsonStr.trim().length() == 0) {
            cqm = new OrderDetailQueryModel();
        } else {
            cqm = JsonHelper.readValue(queryJsonStr, OrderDetailQueryModel.class);
        }
        cqm.setPage(page);

        Page<OrderDetailModel> pageList = orderDetailService.getByConditionPage(cqm);
        model.addAttribute("queryJsonStr", queryJsonStr);
        model.addAttribute("page", pageList);
        return "orderDetail/list";
    }

    @RequestMapping(value = "/toQuery", method = RequestMethod.GET)
    public String query() {
        return "orderDetail/query";
    }


}
