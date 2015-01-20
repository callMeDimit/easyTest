package esayTest;

import org.springframework.beans.factory.annotation.Autowired;

import com.dimit.anno.Test;
import com.dimit.excel.service.ExcelServiceImpl;

/**
 * Dimit 2015年1月17日
 */
public class Test2 {
	@Autowired
	private ExcelServiceImpl excelServiceImpl;

	@Test
	public void test() {
		System.out.println("测试注入是否完成" + excelServiceImpl);
	}

}

