package com.yun.front;

import com.yun.cart.service.ICartService;
import com.yun.cart.vo.CartModel;
import com.yun.cart.vo.CartQueryModel;
import com.yun.common.utils.format.DateFormatHelper;
import com.yun.common.utils.pageUtils.Page;
import com.yun.goods.service.IGoodsService;
import com.yun.goods.vo.GoodsModel;
import com.yun.goods.vo.GoodsQueryModel;
import com.yun.order.service.IOrderDetailService;
import com.yun.order.service.IOrderService;
import com.yun.order.vo.OrderDetailModel;
import com.yun.order.vo.OrderModel;
import com.yun.store.service.IStoreService;
import com.yun.store.vo.StoreModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yzhang
 * @date 2018/6/2 11:21
 * @desc
 */
@Controller
@RequestMapping("/")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IGoodsService igs = null;
    @Autowired
    private ICartService ics = null;
    @Autowired
    private IOrderService ios = null;
    @Autowired
    private IOrderDetailService iods = null;
    @Autowired
    private IStoreService iss = null;

    @RequestMapping(value="/toIndex",method=RequestMethod.GET)
    public String toIndex(Model model){
        GoodsQueryModel gqm = new GoodsQueryModel();
        gqm.getPage().setPageShow(100);

        Page<GoodsModel> page = igs.getByConditionPage(gqm);

        model.addAttribute("page",page);


        return "index";
    }

    @RequestMapping(value="/toGoodsDesc/{goodsUuid}",method=RequestMethod.GET)
    public String toGoodsDesc(Model model,@PathVariable("goodsUuid")int goodsUuid){
        GoodsModel gm = igs.getByUuid(goodsUuid);

        model.addAttribute("m",gm);
        return "goods/desc";
    }

    @RequestMapping(value="/addToCart/{goodsUuid}",method=RequestMethod.GET)
    public String addToCart(Model model,@PathVariable("goodsUuid")int goodsUuid,@CookieValue("MyLogin")String myLogin){
        int customerUuid = Integer.parseInt( myLogin.split(",")[0]);

        CartModel cm = new CartModel();
        cm.setBuyNum(1);
        cm.setCustomerUuid(customerUuid);
        cm.setGoodsUuid(goodsUuid);

        ics.create(cm);
        ///////////////////////////
        CartQueryModel cqm = new CartQueryModel();
        cqm.getPage().setPageShow(1000);
        cqm.setCustomerUuid(customerUuid);


        Page<CartModel>  page = ics.getByConditionPage(cqm);

        model.addAttribute("page",page);

        return "cart/myCart";
    }
    @RequestMapping(value="/toCart",method=RequestMethod.GET)
    public String toCart(Model model,@CookieValue("MyLogin")String myLogin){
        int customerUuid = Integer.parseInt( myLogin.split(",")[0]);

        CartQueryModel cqm = new CartQueryModel();
        cqm.getPage().setPageShow(1000);
        cqm.setCustomerUuid(customerUuid);

        Page<CartModel>  page = ics.getByConditionPage(cqm);

        model.addAttribute("page",page);

        return "cart/myCart";
    }
    @RequestMapping(value="/order",method=RequestMethod.GET)
    public String order(@CookieValue("MyLogin") String myLogin){
        //1:查出这个人购物车所有的信息
        int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
        CartQueryModel cqm = new CartQueryModel();
        cqm.getPage().setPageShow(1000);
        cqm.setCustomerUuid(customerUuid);
        Page<CartModel>  page = ics.getByConditionPage(cqm);
        List<CartModel> result = page.getResult();
        //2.保存信息到住订单
        OrderModel order = new OrderModel();
        order.setCustomerUuid(customerUuid);
        order.setOrderTime(DateFormatHelper.long2str(System.currentTimeMillis()));
        order.setSaveMoney(new BigDecimal(0));
        order.setState("1");
        order.setTotalMoney(new BigDecimal("23.56"));
        ios.create(order);
        //3.保存信息到子订单
        for(CartModel cart:result){
            OrderDetailModel detail = new OrderDetailModel();
            detail.setGoodsUuid(cart.getGoodsUuid());
            detail.setMoney(new BigDecimal(10.00));
            detail.setOrderNum(2);
            detail.setOrderUuid(order.getUuid());
            detail.setPrice(new BigDecimal(10.67));
            detail.setSaveMoney(new BigDecimal(0.67));
            iods.create(detail);
            //4.修改库存
            StoreModel storeModel = iss.getStoreByGoodsUuid(cart.getGoodsUuid());
            if(storeModel.getStoreNum()<cart.getBuyNum()){
                log.error("当前库存不足剩{},需要{}",storeModel.getStoreNum(),cart.getBuyNum());
                return "error";
            }
            storeModel.setStoreNum(storeModel.getStoreNum()-cart.getBuyNum());
            iss.update(storeModel);
            //清空购物车
            ics.delete(cart.getUuid());
        }
        return "success";
    }
}
