package design.factory.store.impl;

import com.alibaba.fastjson.JSON;
import design.factory.card.IQiYiCardService;
import design.factory.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author：HeHongyi
 * @date: 2023/9/2
 * @description: 卡片奖品接口
 */
public class CardCommodityService implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);
    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
