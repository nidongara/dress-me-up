package com.docusign;

import com.docusign.interfaces.CommandsProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DressMeUpTests {


	@Autowired
	CommandsProcessor commandsProcessor;

	@Test
	public void test1() {
		String expectedValue = "Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house";
		String actualValue = commandsProcessor.process("HOT 8, 6, 4, 2, 1, 7");
		assertEquals(expectedValue,actualValue);
	}


	@Test
	public void test2() {
		String expectedValue = "Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house";
		String actualValue = commandsProcessor.process("COLD 8, 6, 3, 4, 2, 5, 1, 7");
		assertEquals(expectedValue,actualValue);
	}

	@Test
	public void test3() {
		String expectedValue = "Removing PJs, shorts, fail";
		String actualValue = commandsProcessor.process("HOT 8, 6, 6");
		assertEquals(expectedValue,actualValue);
	}

	@Test
	public void test4() {
		String expectedValue = "Removing PJs, shorts, fail";
		String actualValue = commandsProcessor.process("HOT 8, 6, 3");
		assertEquals(expectedValue,actualValue);
	}


	@Test
	public void test5() {
		String expectedValue = "Removing PJs, pants, socks, shirt, hat, jacket, fail";
		String actualValue = commandsProcessor.process("COLD 8, 6, 3, 4, 2, 5, 7");
		assertEquals(expectedValue,actualValue);
	}


	@Test
	public void test6() {
		String expectedValue = "fail";
		String actualValue = commandsProcessor.process("COLD 6");
		assertEquals(expectedValue,actualValue);
	}

	@Test
	public void test7() {
		String expectedValue = "Removing PJs, pants, socks, shirt, hat, jacket, fail";
		String actualValue = commandsProcessor.process("COLD 8, 6, 3, 4, 2, 5, 9, 1, 7");
		assertEquals(expectedValue,actualValue);
	}


}
