package com.cloudnote;

import com.cloudnote.util.DBUtil;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class TestDB {

    // 使用日誌工廠類 紀錄日誌
    private  Logger logger = LoggerFactory.getLogger(TestDB.class);

    /**
     *  單元測試方法
     *  1. 方法的返回值，建議使用 void，一般沒有返回值
     *  2. 參數列表，建議空參，一般是沒有參數
     *  3. 方法上記得需要設置 @Test 註解
     *  4. 每個方法都可以獨立運行
     */

    @Test
    public void testDB(){
        System.out.println(DBUtil.getConnection());
        // 使用日誌
        logger.info("使用數據庫連接" + DBUtil.getConnection());

    }
}
