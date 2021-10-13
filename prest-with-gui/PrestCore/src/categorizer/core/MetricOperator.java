/**
 * 
 */
package categorizer.core;

/**
* @author secil.karagulle
* @author ovunc.bozcan
*/
public enum MetricOperator {

	ADD("+", false), SUB("-", false), MUL("*", false), DIV("/", false), 
	NOT("-",true), LOG("log", true), POW("pow", false), EXP("exp", true);	
	
    private final String operator;  
    private final boolean unary;
    
    MetricOperator(String operator,boolean unary) {
        this.operator = operator;
        this.unary = unary; 
    }

    public String operator()
    {
    	return operator;
    }
    
    public boolean isUnary()
    {
    	return this.unary;
    }

}
