package bean;

public class student {

	private int id;
	private String name;
	private int dob;
	private int doj;
	
	public student (int id,String name,int dob,int doj )
	{
		super();
		this.id=id;
		this.name=name;
		this.dob=dob;
		this.doj=doj;
	}
	public int getid()
	{
		return id;
	}
	public void setid(int i)
	{
		this.id=i;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public int getdob() 
	{	
		return dob; 
	}
	public void setdob(int dob)
	{
		this.dob=dob;
	}
	public int getdoj()
	{
		return doj;
	}
	public void setdoj(int doj)
	{
		this.doj=doj;
	}
}
