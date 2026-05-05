#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.velocity.tools.view.tools.ViewTool;

public class MyViewTool implements ViewTool {

	@Override
	public void init(Object initData) {
	}

	public String getHelloMessage() {
		return "Hello dotCMS World";
	}

	public String getHelloMessage(String name) {
		return "Hello " + name;
	}

}
