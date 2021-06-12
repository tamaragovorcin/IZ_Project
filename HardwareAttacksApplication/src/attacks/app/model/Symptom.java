package attacks.app.model;

public class Symptom {

	private int id;
	private String name;
	private boolean checked;

	public Symptom() {
	}

	public Symptom(String name) {
		this.name = name;
		this.checked = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}