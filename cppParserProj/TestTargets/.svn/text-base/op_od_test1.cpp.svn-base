/* **************************
 * Tests for operator-operand
 * recognition.
 * Author: Harri Pellikka
   **************************/
   
void Foo::FuncTest()
{
	doSomething();
	asd(besd());
}
   
// Array recognition tests (different uses of arrays)
void Foo::ArrayTest()
{
	int billy[5];         // declaration of a new array
	billy[2] = 75;        // access to an element of the array.
	billy[0] = a;
	billy[a] = 75;
	b = billy [a+2];
	billy[billy[a]] = billy[2] + 5;
	
	int jimmy [3][5];
}

// Parenthesis tests (randomly placed parentheses)
void Foo::ParenthesisTest()
{
	int a = (1);
	int b = (a * 5) + 2;
	int c = ((4+1)/4) * (123 - (a));
}

// Splitter tests (lines with varying whitespaces and lines breaks)
void Foo::SplitTest()
{
	int a;
	int b ;
	int
	c
	;
	int d = 1;
	int e=2;
	int f =3;
	int g= 4;
	if(a == b)
	{
		a = 0;
	}
	if(c==d)
	{
		c = a;
	}
	if(e ==f);
	if(f== g);
	
	if(true&&false)
	{
		
	}
}

// Operator tests. This function includes most of the operators present
// in C++11.
void Foo::Operators()
{
	// Basic comparison operators
	if(a1 < b1) {}
	if(a2 <= b2) {}
	if(a3 > b3) {}
	if(a4 >= b4) {}
	if(a5 == b5) {}
	if(c5 != d5) {}

	// Bit shift operators
	a6 << b6; // Single Left
	a7 << b7 << c7; // Multiple Left
	a8 >> b8; // Single Right
	a9 >> b9 >> c9; // Multiple Right
	
	// Arithmetic operators
	a10 = b10 + c10;
	a11 = b11 - c11;
	a12 = b12 * c12;
	a13 = b13 / c13;
	a14 = b14 % c14;
	
	// Unary plus and minus
	a15 = +b15;
	a16 = -b16;
	a17 = b17 - +c17;
	a18 = b18 + -c18;
	
	// Pre- and post-increment / -decrement
	a19 = b19++;
	a20 = b20--;
	a21 = ++b21;
	a22 = --b22;
	
	// Logical operators (default cases)
	if(a23) {} // unary true-false
	if(!a24) {} // NOT
	if(a25 && b25) {} // AND
	if(a26 || b26) {} // OR
	if(!a27 && !b27) {} // NOT and AND
	
	// Logical operators (non-symbol cases)
	if(not a28) {} // NOT
	if(a29 and b29) {} // AND
	if(a30 or b30) {} // OR				
	
	// Bitwise logical operators
	if(~a31) {} // Bitwise NOT
	if(a32 & b32) {} // Bitwise AND
	if(a33 | b33) {} // Bitwise OR				
	if(a34 ^ b34) {} // Bitwise XOR
	
	// Compound assignment operators
	a35 += b35;
	a36 -= b36;
	a37 *= b37;
	a38 /= b38;
	a39 %= b39;
	a40 &= b40;
	a41 |= b41;
	a42 ^= b42;
	a43 <<= b43;
	a44 >>= b44;
	
	// Array subscript
	a45 = b45[0];
	a46 = b46[c46];
	a47[0] = b47;
	a48[b48] = c48;
	a49[b49] = c49[d49];
	
	// Function call and comma
	doSomething(a50, b50);
	
	// Scope resolution
	SomeScope::doSomething();
	
	// Sizeof
	a51 = sizeof(b51);
	
	// Templates
	vector<int> a52;
	vector<vector<int>> a53;  // >> causes problems
}

// Operand recognition test. This function tries to include
// varying operands that should all be recognized.
void Foo::operands()
{
	int a1;
	int a2, b2;
	int a3 = 1;
	int a4 = 2, b4 = 7;
	
	char** a5 = "Here's a string.";
	char a6 = 'p';
}

void Foo::cc1()
{
	int a = 1;
	
	// For
	for(int i = 0; i < 10; ++i)
	{
	
	}
	
	for(int a = 0; a < 15; a++)
	{
		
	}
	
	do
	{
		a++;
		--b;
		++c;
		d--;
	}while(a <= 25 && b > -4);
	
	// If
	if(true)
	{
	
	}
	
	// If-elseif
	if(true)
	{
	
	}
	else if(false)
	{
		
	}
	
	if(true && true) // Second true not recognized (listed as operator)
	{
	
	}
	
	
}
