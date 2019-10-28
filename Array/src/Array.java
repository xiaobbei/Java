
public class Array<E> {
	
	private E[] data;
	private int size;
	@SuppressWarnings("unchecked")
	public Array(int capacity)
	{
		data = (E[]) new Object[capacity];
		size = 0;
	}
	public Array()
	{
		this(10);
	}
	public int Getcapacity()
	{
		return data.length;
	}
	public int Getsize()
	{
		return size;
	}
	public boolean Isempty()
	{
		return size == 0;
	}
	public void Insert(int index,E x)
	{
		if(size == data.length)
		{
			System.out.println("数组已满，无法插入");
		}
		if(index<0 || index>size)
		{
			System.out.println("插入位置有误");
		}
		for(int i = size -1;i>index;--i)
		{
			data[i+1] = data[i];
		}
		data[index] = x;
		size++;
	}
	
	public void AddLast(E x)
	{
		Insert(size,x);
	}
	public void AddFirst(E x)
	{
		Insert(0,x);
	}
	public E GetIndex(int index) 
	{
		if(index<0 || index>size)
		{
			System.out.println("位置错误");
		}
		return data[index];
	}
	public void SetIndex(int index,E x)
	{
		if(index<0 || index>data.length)
		{
			System.out.println("位置错误");
		}
		data[index] = x;
	}
	public boolean Find_X(E x)
	{
		for(int i = 0;i<data.length;++i)
		{
			if(data[i] == x)
				return true;
		}
		return false;
	}
	public int Find_X_Index(E x)
	{
		for(int i= 0;i<data.length;++i)
		{
			if(data[i] == x)
				return i;
		}
		return -1;
	}
	public E Del_Ind_X(int index)
	{
		if(index<0 || index>=size)
		{
			System.out.println("位置错误");
		}
		E res = data[index];
		for(int i= index + 1;i<size;++i)
		{
			data[i] = data[i+1];
		}
		return res;
	}
	public E Del_Frist()
	{
		return Del_Ind_X(0);
	}
	public void Del_Val_X(E x)
	{
		int index = Find_X_Index(x);
		if(index != -1)
			Del_Ind_X(index);
	}
	public void Print_Arr()
	{
		for(int i = 0;i<size;++i)
		{
			System.out.print(data[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String []args)
	{
		Array Arr = new Array(15);
		for(int i = 0;i<10;++i)
		{
			Arr.Insert(i, i+1);
		}
		Arr.Print_Arr();
		System.out.println(Arr.Del_Ind_X(13));
		//Arr.Print_Arr();
	}
}
