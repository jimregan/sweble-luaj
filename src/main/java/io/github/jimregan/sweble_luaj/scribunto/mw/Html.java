package io.github.jimregan.sweble_luaj.scribunto.mw;

import java.util.HashMap;

import org.luaj.vm2.LuaDouble;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OneArgFunction;

public class Html extends OneArgFunction {

	private class HtmlText extends LuaValue {
		HashMap<String, String> attributes = new HashMap<String, String>();
		String tagName;
		HtmlText () {
			
		}
		// methodtable._build = function( t, ret )	
		// methodtable.node = function( t, builder )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:node
		// methodtable.wikitext = function( t, ... )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:wikitext
		// methodtable.newline = function( t )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:newline
		// methodtable.tag = function( t, tagName, args )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:tag
		// methodtable.attr = function( t, name, val )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:attr
		// methodtable.getAttr = function( t, name )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:getAttr
		// methodtable.addClass = function( t, class )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:addClass
		// methodtable.css = function( t, name, val )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:css
		// methodtable.cssText = function( t, css )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:cssText
		// methodtable.done = function( t )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:done
		// methodtable.allDone = function( t )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html:allDone
		// subclass ?
		// function HtmlBuilder.create( tagName, args )
		// https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.html.create
		@Override
		public int type() {
			return LuaValue.TUSERDATA;
		}
		@Override
		public String typename() {
			return "userdata";
		}
		
	}
	@Override
	public LuaValue call(LuaValue arg0) {
		LuaTable t = new LuaTable(0,30);
		// TODO Auto-generated method stub
		return null;
	}

	static Varargs _testf(Varargs args0) {
		LuaValue obj = args0.arg1();
		int a = obj.checkint();
		a += 1;
		return obj;
	}
	
	/**
	 * Basic version of PHP's <code>htmlspecialchars()</code>
	 * @param s The string being converted 
	 * @return
	 */
	static String specialchars(String s) {
		String ret = "";
		for(char c : s.toCharArray()) {
			switch(c) {
			case '&':
				ret += "&amp;";
				break;
			case '<':
				ret += "&lt;";
				break;
			case '>':
				ret += "&gt;";
				break;
			case '"':
				ret += "&quot;";
				break;
			default:
				ret += c;
			}
		}
		return ret;
	}
	
	static boolean isValidTag(String s) {
		if(s.length() == 0)
			return false;
		for(char c : s.toCharArray()) {
			if ((c < 'A') || (c > 'z') || ((c > 'Z') && (c < 'a'))) {
				return false;
			}
		}
		return true;
	}
}
