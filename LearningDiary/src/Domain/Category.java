package Domain;

public class Category {
	
	int id;
	String name;
	int bookcounts;
	
	
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category(int id,String name, int bookcountsString) {
		this.id = id;
		this.name = name;
		this.bookcounts = bookcountsString;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBookcounts() {
		return bookcounts;
	}
	public void setBookcounts(int bookcounts) {
		this.bookcounts = bookcounts;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", bookcounts="
				+ bookcounts + "]";
	}
	
	
}
