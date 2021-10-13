package parser.Cpp.contextManager;
import java.util.Hashtable;


public class Scope 
{
	//Name of the scope (set only for class/function scopes).
    String scopeName;

    //Indicates whether this is a class scope or not.
    boolean type;     // Indicates if this is a type.

    //(partial) table of type symbols introduced in this scope.
    Hashtable typeTable = new Hashtable();
    
    
    Hashtable<String,String> symbolType= new Hashtable<String,String>();
   
    
    
    //Parent scope. (null if it is the global scope).
    Scope parent;

    //Creates a scope object with a given name.
    public Scope(String name, boolean isType, Scope p) 
    {
        scopeName = name;
        type = isType;
        parent = p;
    }

    //Creates an unnamed scope (like for compound statements).
    public Scope(Scope p) 
    {
        type = false;
        parent = p;
    }

    //Inserts a name into the table to say that it is the name of a type.
    public void PutTypeName(String name) 
    {
        typeTable.put(name, name);
    }

    //A type with a scope (class/struct/union).
    public void PutTypeName(String name, Scope sc) 
    {
        typeTable.put(name, sc);
    }

    // Checks if a given name is the name of a type in this scope.
    public boolean IsTypeName(String name) 
    {
        return typeTable.get(name) != null;
    }

    public Scope GetScope(String name) 
    {
        Object sc = typeTable.get(name);

        if (sc instanceof Scope || sc instanceof ClassScope)
            return (Scope) sc;

        return null;
    }

	public String getScopeName()
	{
		return scopeName;
	}
	
	public String getFullScopeName()
	{
		Scope sc=parent;
		String output=getScopeName();
		
		while(sc.parent!=null)
		{
			if(sc.getScopeName()!=null)
				output=sc.getScopeName()+"::"+output;
			sc=sc.parent;
		}
		
		if(output==null)
			return "GLOBAL_SCOPE";
		return output;		
	}

	public Scope getParent()
	{
		return parent;
	}

	public String getSymbolType(String symbol)
	{
		String output=null;
		Scope sc= this;
		
		
		while(sc!=null)
		{
			output= sc.symbolType.get(symbol);
			if(output!=null)
				return output;
			
			sc=sc.parent;
		}
		return null;
	}

	public void addSymbol(String type,String symbol)
	{
		this.symbolType.put(type, symbol);
	}
}
