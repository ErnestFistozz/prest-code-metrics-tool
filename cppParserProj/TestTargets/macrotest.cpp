
#define MULTIPLY(x, y) (x) * (y)

// Test for simple macro expansion
void Foo::Bar()
{
	int a = 3;
	int b = 5;
	int c = MULTIPLY(a, b);
}

#define SIZE 1024
#define SIZE_W 128
#define SIZE_H 256

#define SIZE_X ((SIZE_W) + (SIZE_H))

#define DEFAULT SIZE

#define MULTILINEMACRO(x) \
	(x + 1 \
	* 2)

void Foo::Bar2()
{
	int s = SIZE;
	int w = SIZE_W * SIZE_H;
	int result = MULTIPLY(SIZE_W, SIZE_H);
	
	int x = SIZE_X;
	
	int d = DEFAULT;
	
	int mld = MULTILINEMACRO(d);
}


/*
Testi.
*/
#define SEMICOLON ;

void Foo::Bar3()
{
	int a = 4 SEMICOLON
	int b = 4 - 2 SEMICOLON
}