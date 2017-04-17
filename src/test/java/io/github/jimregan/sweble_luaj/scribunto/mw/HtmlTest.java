/**
 * 
 */
package io.github.jimregan.sweble_luaj.scribunto.mw;

import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.Assert;

/**
 * @author jimregan
 *
 */
public class HtmlTest extends TestCase {

	@Test
	public void test_specialchars() throws Exception {
		Assert.assertEquals("no change", Html.specialchars("no change"));
		Assert.assertEquals("&lt;a&gt; &quot;change&amp;", Html.specialchars("<a> \"change&"));
	}
	
	@Test
	public void test_isValidTag() throws Exception {
		Assert.assertEquals(true, Html.isValidTag("azAZ"));
		Assert.assertEquals(true, Html.isValidTag("TESTtest"));
		Assert.assertEquals(false, Html.isValidTag(""));
		Assert.assertEquals(false, Html.isValidTag("a-"));
	}
}
