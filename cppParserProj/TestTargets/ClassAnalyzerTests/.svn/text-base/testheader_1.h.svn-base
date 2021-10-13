
class Test
{
	public:
		
		// Public members
		int a;
		int b, c;
		
		// Constructors
		Test();
		Test(int p1, int p2);
		
		// Destructor
		~Test();
		
		// Void-type functions
		void doSomething();
		void doSomething(int p1);
		void doSomethingElse();
		
		// Non-void-type functions
		int getSomething();
		int getSomething(int p1);
		
		// Non-basetype functions
		Foo::Bar getBar();
		Foo::Bar getBar(int p1);
		
		// Non-basetype parameters
		void setBar(Foo::Bar b);
		int setBarAndGetSomething(Foo::Bar b, int count);
		
		// Template return type
		Foo::Baz<int, double> getTemplateType();
		Foo::Baz<int, double> getTemplateType(int count);
		
		// Template parameters
		void setTemplateType(Foo::Baz<int, double> b);
		void setTemplateType(Foo::Baz<int, double> b, int count);
		
		// Functions with attributes
		virtual void virtualFunction() = 0;
		const void constFunction();
		
		// Const parameters
		void constParamFunction(const Foo::Bar b&);
		
		// Function with body, should be handled in the function analyzer
		void funcWithBody() { a = 4; int findThis = 7; }
		
}