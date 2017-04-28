package discoverita.jpa.hierarchy.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("regularemployee")
public class RegularWorker extends Worker {

	@Column(name = "salary")
	private float salary;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Column(name = "bonus")
	private int bonus;

}
