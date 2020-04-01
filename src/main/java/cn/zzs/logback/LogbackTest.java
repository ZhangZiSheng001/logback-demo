package cn.zzs.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>测试logback</p>
 * @author: zzs
 * @date: 2020年1月14日 上午9:11:44
 */
public class LogbackTest {

    public static void main(String[] args) throws InterruptedException {

        Logger logger = LoggerFactory.getLogger(LogbackTest.class);
        // Logger logger = LoggerFactory.getLogger(String.class);
        // Logger logger = LoggerFactory.getLogger("cn.zzs.logback.LogbackTest");
        // Logger logger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);

        logger.debug("输出DEBUG级别日志");
        logger.info("输出INFO级别日志");
        logger.warn("输出WARN级别日志");
        logger.error("输出ERROR级别日志");

        // Thread.sleep(30*60*1000);
        // System.err.println(System.getProperty("slf4j.detectLoggerNameMismatch"));
    }
}
