package com.yun.cart.web;

import com.yun.cart.service.ICartService;
import com.yun.cart.vo.CartModel;
import com.yun.cart.vo.CartQueryModel;
import com.yun.common.utils.json.JsonHelper;
import com.yun.common.utils.pageUtils.Page;
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
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private ICartService icartService = null;


    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "cart/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("cartModel") CartModel cartModel) {
        icartService.create(cartModel);
        return "cart/success";
    }

    @RequestMapping(value = "/toUpdate/{cartUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("cartUuid") int cartUuid) {
        CartModel cartModel = icartService.getByUuid(cartUuid);
        model.addAttribute("m", cartModel);
        return "cart/update";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("cartModel") CartModel cartModel) {
        icartService.update(cartModel);
        return "cart/success";
    }

    @RequestMapping(value = "/toDelete/{cartUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("cartUuid") int cartUuid) {
        CartModel cartModel = icartService.getByUuid(cartUuid);
        model.addAttribute("m", cartModel);
        return "cart/delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int cartUuid) {
        icartService.delete(cartUuid);
        return "cart/success";
    }


    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("queryJsonStr") String queryJsonStr,@ModelAttribute("page") Page page, Model model) {
        CartQueryModel cqm = null;
        if (queryJsonStr == null || queryJsonStr.trim().length() == 0) {
            cqm = new CartQueryModel();
        } else {
            cqm = JsonHelper.readValue(queryJsonStr, CartQueryModel.class);
        }
        cqm.setPage(page);

        Page<CartModel> pageList = icartService.getByConditionPage(cqm);
        model.addAttribute("queryJsonStr", queryJsonStr);
        model.addAttribute("page", pageList);
        return "cart/list";
    }

    @RequestMapping(value = "/toQuery", method = RequestMethod.GET)
    public String query() {
        return "cart/query";
    }


}
