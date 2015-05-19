package Domain;

public class Books {
	
	int id;
	int category_id;
	String category_name;
	String image;
	String name;
	String book_format;
	String notes;
	
	
	public Books(int id, int category_id, String category_name, String image,
			String name, String book_format, String notes) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.category_name = category_name;
		this.image = image;
		this.name = name;
		this.book_format = book_format;
		this.notes = notes;
	}
	
	
	
	public String getCategory_name() {
		return category_name;
	}



	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBook_format() {
		return book_format;
	}
	public void setBook_format(String book_format) {
		this.book_format = book_format;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}



	@Override
	public String toString() {
		return "Books [id=" + id + ", category_id=" + category_id
				+ ", category_name=" + category_name + ", image=" + image
				+ ", name=" + name + ", book_format=" + book_format
				+ ", notes=" + notes + "]";
	}
	
	
	
	
}
