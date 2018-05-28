package com.yun.customer.web;

import com.yun.common.utils.format.DateFormatHelper;
import com.yun.common.utils.json.JsonHelper;
import com.yun.common.utils.pageUtils.Page;
import com.yun.customer.service.ICustomerService;
import com.yun.customer.vo.CustomerModel;
import com.yun.customer.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

/**
 * @author yzhang
 * @date 2018/5/28 21:50
 * @desc
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private ICustomerService iCustomerService = null;


    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "customer/add";
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@ModelAttribute("customerModel") CustomerModel customerModel){
        customerModel.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
        iCustomerService.create(customerModel);
        return "customer/success";
    }

    @RequestMapping(value = "/toUpdate/{customerUuid}",method = RequestMethod.GET)
    public String toUpdate(Model model,@PathVariable("customerUuid") int customerUuid){
        CustomerModel customerModel = iCustomerService.getByUuid(customerUuid);
        model.addAttribute("cm",customerModel);
        return "customer/update";
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@ModelAttribute("customerModel") CustomerModel customerModel){
        iCustomerService.update(customerModel);
        return "customer/success";
    }

    @RequestMapping(value = "/toDelete/{customerUuid}",method = RequestMethod.GET)
    public String toDelete(Model model,@PathVariable("customerUuid") int customerUuid){
        CustomerModel customerModel = iCustomerService.getByUuid(customerUuid);
        model.addAttribute("cm",customerModel);
        return "customer/delete";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int customerUuid){
        iCustomerService.delete(customerUuid);
        return "customer/success";
    }


    @RequestMapping(value = "/toList",method = RequestMethod.GET)
    public String toList(@RequestParam(value = "queryJsonStr",defaultValue = "") String queryJsonStr, @ModelAttribute("page") Page page,Model model){
        CustomerQueryModel cqm = null;
        if(queryJsonStr == null || queryJsonStr.trim().length()==0){
            cqm = new CustomerQueryModel();
        }else {
            cqm = JsonHelper.readValue(queryJsonStr,CustomerQueryModel.class);
        }
        cqm.getPage().setPageShow(page.getPageShow());
        cqm.getPage().setNowPage(page.getNowPage());

        Page<CustomerModel> pageList = iCustomerService.getByConditionPage(cqm);
        model.addAttribute("queryJsonStr",queryJsonStr);
        model.addAttribute("page",pageList);
        return "customer/list";
    }

    @RequestMapping(value = "/toQuery",method = RequestMethod.GET)
    public String query(){
        return "customer/query";
    }


}
