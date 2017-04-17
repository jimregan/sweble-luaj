package io.github.jimregan.sweble_luaj.scribunto.mw;

import junit.framework.Assert;

import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.junit.Test;

public class UStringLibTest {

	@Test
	public void test_rep() {
		LuaString expected = LuaString.valueOf("t\u0119\u015btt\u0119\u015btt\u0119\u015bt");
		Varargs rep = LuaValue.varargsOf(LuaString.valueOf("t\u0119\u015bt"), LuaInteger.valueOf(3));
		Assert.assertEquals(expected, UStringLib.rep(rep));
		Assert.assertEquals("t\u0119\u015btt\u0119\u015btt\u0119\u015bt", UStringLib.rep(rep).tojstring());
	}

	@Test
	public void test_lower() {
		Assert.assertEquals("tęśt", UStringLib.lower(LuaString.valueOf("TĘŚT")).tojstring());
	}

	@Test
	public void test_toNFD() {
		Assert.assertEquals("\u0065\u0301", UStringLib.toNFD(LuaString.valueOf("\u00e9")).tojstring());
	}
	
	@Test
	public void test_len() {
		Assert.assertEquals(5, UStringLib.len(LuaString.valueOf("a\000bc\000")).toint());
	}
}
