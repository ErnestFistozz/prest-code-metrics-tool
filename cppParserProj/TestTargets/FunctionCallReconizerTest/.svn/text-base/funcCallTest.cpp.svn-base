//When testing these functions starting with w should not be recognized
Test::doSomething()
{
	//Variable
	int w1(); //ok
	
	//typecasts
	int(w2); //ok
	(int)w3; //ok
	
	a1(); //ok
	a2(2); //ok
	a3(2,2); //ok
	
	//Strings as parameter
	a4("hello"); //OK
	a5("w2()"); //NOT ok problem with tokens
	
	//Function call as parameter
	a6(b6()); //Ok
	a7(b7(c7()),d7()); //c7() is recognized twice
	
	// ::, ->, and . tokens
	
	Namespace1::a7(); //Ok
	Namespace1::Namespace2::a8(); //ok
	
	Struct1.a9(); //ok
	myObj->a10(); //ok
	myObj->a11()->a12(); //ok
	
	//Other
	if(a13()); //ok
	if(0+a14()); //ok
	if(2*a15(); //ok
	for(int w4=a16();w4 < b16();w4++); //ok
	
	//assignment
	int w5=a17(); //ok
	
	
	
	
}