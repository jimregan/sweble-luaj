package io.github.jimregan.sweble_luaj.scribunto.mw;

import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OneArgFunction;

public class Text extends OneArgFunction {

	@Override
	public LuaValue call(LuaValue arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * See: https://www.mediawiki.org/wiki/Extension:Scribunto/Lua_reference_manual#mw.text.listToText
	 * @param args
	 * @return
	 */
	static Varargs _listToText(Varargs args) {
		String sep = ","; 
		String conj = " and ";
		String out = "";
		if (args.narg() == 3) {
			sep = args.checkjstring(1);
			conj = args.checkjstring(2);
		}
		LuaTable t = args.checktable(0);
		if (t.length() == 1) {
			return t.get(0);
		}
		if (t.length() == 2) {
			out = t.get(0).tojstring() + conj + t.get(1).tojstring();
			return LuaString.valueOf(out);
		}
		for (int i = 0; i < t.length()-1; i++) {
			out += t.get(i);
			out += sep;
		}
		out += conj;
		out += t.get(t.length());
		return LuaString.valueOf(out);
	}
}
