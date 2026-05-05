#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

public enum AppKeys {
        CHECKBOX("checkbox"),
        VARIABLE_ONE("variableOne"),
        VARIABLE_TWO("variableTwo"),
        SELECT_VARIABLE("selectVariable");


       final public String key;
        
       AppKeys(String key){
            this.key=key;
        }
        
    
       public final static String APP_KEY = "dotAppExample";
       
       public final static String APP_YAML_NAME = APP_KEY + ".yml";
       
       
       
}
