package Domain;

public class UserBooks {
	
	int id;
	int user_id;
	String image;
	String name;
	String book_format;
	String notes;
	
	public UserBooks(int id, int users_id, String image, String name,
			String book_format, String notes) {
		super();
		this.id = id;
		this.user_id = users_id;
		this.image = image;
		this.name = name;
		this.book_format = book_format;
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
		return "UserBooks [id=" + id + ", user_id=" + user_id + ", image="
				+ image + ", name=" + name + ", book_format=" + book_format
				+ ", notes=" + notes + "]";
	}
	
	
}
