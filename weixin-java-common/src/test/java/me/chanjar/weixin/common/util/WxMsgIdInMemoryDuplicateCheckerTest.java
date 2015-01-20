package me.chanjar.weixin.common.util;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by qianjia on 15/1/20.
 */
@Test
public class WxMsgIdInMemoryDuplicateCheckerTest {

  public void test() throws InterruptedException {
    Long[] msgIds = new Long[] { 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l };
    WxMsgIdInMemoryDuplicateChecker checker = new WxMsgIdInMemoryDuplicateChecker(2000l, 1000l);

    // 第一次检查
    for (Long msgId : msgIds) {
      boolean result = checker.isDuplicate(msgId);
      Assert.assertFalse(result);
    }

    // 过1秒再检查
    Thread.sleep(1000l);
    for (Long msgId : msgIds) {
      boolean result = checker.isDuplicate(msgId);
      Assert.assertTrue(result);
    }

    // 过1.5秒再检查
    Thread.sleep(1500l);
    for (Long msgId : msgIds) {
      boolean result = checker.isDuplicate(msgId);
      Assert.assertFalse(result);
    }

  }

}