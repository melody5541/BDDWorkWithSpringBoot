package io.cucumber.samples.dw.steps;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.并且;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import io.cucumber.samples.dw.helpers.KnowsCard;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by stlv for developerworks article
 */
public class CardApiStepdefs {

    @Autowired
    private KnowsCard cardHelper;

    @假如("^卡号为([^\"]*)的银行卡数据已经存在$")
    public void 卡号为_的银行卡数据已经存在(String cardNum) throws Throwable {
        cardHelper.assertThatCardWithNumberHadBeenExisted(cardNum);
    }

    @当("^小明查询卡号为([^\"]*)的银行卡数据$")
    public void 小明查询卡号为_的银行卡数据(String cardNum) throws Throwable {
        cardHelper.assertThatRepliedCardDataIsNotNullOrEmpty(cardNum);
    }

    @那么("^数据满足([^\"]*)所要求的格式$")
    public void 数据满足_所要求的格式(String schemaFile) throws Throwable {
        cardHelper.assertThatRepliedCardDataMetSchemaDefinedSpecs(schemaFile);
    }

    @并且("^小明获取到的卡号为([^\"]*)的银行卡数据应有(\\d+)条$")
    public void 小明获取到的卡号为_的银行卡数据仅应_条(String cardNum, int expectedCardCount) throws Throwable {
        cardHelper.assertThatFetchedCardDataCountAsExpected(cardNum, expectedCardCount);
    }


    @假如("^卡号为([^\"]*)的银行卡数据不存在$")
    public void 卡号为CardNum的银行卡数据不存在(String cardNum) throws Throwable {
        cardHelper.assertThatCardWithNumberDoesNotExisted(cardNum);
    }
}
