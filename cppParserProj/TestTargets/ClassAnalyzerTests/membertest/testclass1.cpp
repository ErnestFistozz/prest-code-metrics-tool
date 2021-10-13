
testClass::testClass()
{
	int b1 = a1;
	int b2 = a2;
	char b3 = a3;
	
	a4->bar();
	
	int* b4;
	
	doSomething();
}

testClass::~testClass()
{
	a1 = 0;
	a2 = 0;
	a3 = 'a';
}

void testClass::doSomething()
{
	std::cout << "this does something." << std::endl;
}