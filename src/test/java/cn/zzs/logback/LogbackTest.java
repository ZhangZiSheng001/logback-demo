package cn.zzs.logback;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: LogbackTest
 * @Description: 测试logback
 * @author: zzs
 * @date: 2019年9月1日 下午7:18:08
 */
public class LogbackTest {
	private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	/**
	 * 测试logback
	 */
	@Test
	public void test01() {
		logger.debug("输出DEBUG级别的日志");
		logger.info("输出INFO级别的日志");
		logger.warn("输出WARN级别的日志");
		logger.error("输出ERROR级别的日志");
	}
}
