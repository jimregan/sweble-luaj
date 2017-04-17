package io.github.jimregan.sweble_luaj.scribunto.mw;

import org.sweble.wikitext.engine.*;
import org.sweble.wikitext.engine.config.WikiConfig;
import org.sweble.wikitext.engine.utils.DefaultConfigEnWp;
import org.sweble.wikitext.parser.parser.LinkTargetException;

public class SwebleTest {
	SwebleTest() throws LinkTargetException {
		WikiConfig config = DefaultConfigEnWp.generate();
		WtEngineImpl engine = new WtEngineImpl(config);
		String fileTitle = "";
		PageTitle pageTitle = PageTitle.make(config, fileTitle);
		
	}
}
